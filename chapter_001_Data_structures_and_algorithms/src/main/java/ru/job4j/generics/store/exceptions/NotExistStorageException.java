package ru.job4j.generics.store.exceptions;

public class NotExistStorageException extends StorageException {
    public NotExistStorageException(String message, String id) {
        super(message, id);
    }
}
