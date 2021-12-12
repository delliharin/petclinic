package com.example.notesservice.exception;

public class InvalidNoteDataException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public InvalidNoteDataException(String msg) {
        super(msg);
    }
}

