package ru.job4j.generics.store.exceptions;

public class StorageException extends RuntimeException {
    private final String id;

    public StorageException(String id) {
        this.id = id;
    }

    public StorageException(String message, String id) {
        super(message);
        this.id = id;
    }

    public String getId() {
        return id;
    }

}
