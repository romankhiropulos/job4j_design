package ru.job4j.generics.store.exceptions;

public class ExistStorageException extends StorageException {
    public ExistStorageException(String message, String id) {
        super(message, id);
    }
}
