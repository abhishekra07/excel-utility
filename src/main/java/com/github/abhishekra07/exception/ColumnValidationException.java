package com.github.abhishekra07.exception;

public class ColumnValidationException extends RuntimeException {
    public ColumnValidationException(String message) {
        super(message);
    }
}