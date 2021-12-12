package com.example.notesservice.service;

import com.example.notesservice.dto.NotesDto;

import java.util.List;

public interface NoteService {
    List<NotesDto> findAll();
    NotesDto save(NotesDto noteDto);
    NotesDto deleteById(Integer id);
    NotesDto getById(Integer id);
    NotesDto updateStatus(Integer id, String status);
    List<NotesDto> findByAuthor(String author);
    List<NotesDto> findByStatus(String status);
}
