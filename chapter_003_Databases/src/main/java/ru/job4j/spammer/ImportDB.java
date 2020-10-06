package ru.job4j.spammer;

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class ImportDB {

    private Properties cfg;
    private String dump;

    public ImportDB(Properties cfg, String dump) {
        this.cfg = cfg;
        this.dump = dump;
    }

    public List<User> load() throws IOException {
        List<User> users = new ArrayList<>();
        try (BufferedReader rd = new BufferedReader(new FileReader(dump))) {
            rd.lines().forEach(t -> {
                String[] buffer = t.split(";");
                users.add(new User(buffer[0], buffer[1]));
            });
        }
        return users;
    }

    public void save(List<User> users) throws ClassNotFoundException, SQLException {
        Class.forName(cfg.getProperty("driver-class-name"));
        try (Connection cnt = DriverManager.getConnection(
                cfg.getProperty("db.url"),
                cfg.getProperty("db.user"),
                cfg.getProperty("db.password")
        )) {
            for (User user : users) {
                try (PreparedStatement ps = cnt
                        .prepareStatement("INSERT INTO users (name, email) VALUES (?, ?)")) {
                    ps.setString(1, user.name);
                    ps.setString(2, user.email);
                    ps.execute();
                }
            }
        }
    }

    private static class User {
        String name;
        String email;

        public User(String name, String email) {
            this.name = name;
            this.email = email;
        }
    }

    public static void main(String[] args) throws Exception {
        Properties cfg = new Properties();
        try (FileInputStream in
                     = new FileInputStream("./chapter_003_Databases/src/main/java/ru/job4j/spammer/app.properties")) {
            cfg.load(in);
        }
        ImportDB db = new ImportDB(cfg,
                "./chapter_003_Databases/src/main/java/ru/job4j/spammer/dump.txt");
        db.save(db.load());
    }
}
