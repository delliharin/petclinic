package com.example.notesservice.exception;

public class NotesException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public NotesException(String msg) {
        super(msg);
    }
}
