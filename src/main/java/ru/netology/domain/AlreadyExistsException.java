package ru.netology.domain;

public class AlreadyExistsException extends RuntimeException {
    public AlreadyExistsException(String message) {
        super("ID is in service already");
    }
}
