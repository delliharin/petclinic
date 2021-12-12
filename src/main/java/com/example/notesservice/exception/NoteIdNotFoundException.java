package com.example.notesservice.exception;

public class NoteIdNotFoundException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public NoteIdNotFoundException(String msg) {
        super(msg);
    }
}
