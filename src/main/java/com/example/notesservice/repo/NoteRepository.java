package com.example.notesservice.repo;

import com.example.notesservice.model.Note;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NoteRepository extends JpaRepository<Note,Integer> {

    List<Note> findByAuthor(String author);
    List<Note> findByStatus(String status);

}
