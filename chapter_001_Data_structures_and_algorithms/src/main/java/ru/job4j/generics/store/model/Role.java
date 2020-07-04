package ru.job4j.generics.store.model;

public class Role extends Base {
    private String roleName;
    private String userId;

    public Role(String id, String roleName, String userId) {
        super(id);
        this.roleName = roleName;
        this.userId = userId;
    }
}
