package com.example.notesservice.controller;


import com.example.notesservice.annotation.IsValidStatus;
import com.example.notesservice.dto.NotesDto;
import com.example.notesservice.exception.NoteIdNotFoundException;
import com.example.notesservice.exception.NotesException;
import com.example.notesservice.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/noteservice")
@Validated
public class NoteController {

    @Autowired
    private NoteService noteService;

    @GetMapping("/all")
    public ResponseEntity<?> findAllNotes(){
        List<NotesDto> notes = noteService.findAll();
        return new ResponseEntity<>(notes, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<?> saveNotes(@Valid @RequestBody NotesDto notesDto) throws NotesException {
        NotesDto savedNote = noteService.save(notesDto);
        return new ResponseEntity<>(savedNote, HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteNotes(@PathVariable Integer id) throws NoteIdNotFoundException {
        NotesDto notesDto = noteService.deleteById(id);
        return new ResponseEntity<>(notesDto,HttpStatus.ACCEPTED);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<?> getByID(@PathVariable Integer id) throws NoteIdNotFoundException{
        NotesDto notesDto = noteService.getById(id);
        return new ResponseEntity<>(notesDto,HttpStatus.OK);
    }

    @PutMapping("/update/{id}/{status}")
    public ResponseEntity<?> updateStatus(@PathVariable Integer id, @PathVariable @IsValidStatus(listOfValidStatus = "completed|pending") String status){
        NotesDto notesDto = noteService.updateStatus(id,status) ;
        return new ResponseEntity<>(notesDto,HttpStatus.CREATED);
    }

    @GetMapping("/findByAuthor/{author}")
    public ResponseEntity<?> findByAuthor(@PathVariable String author){
        List<NotesDto> notes = noteService.findByAuthor(author);
        return new ResponseEntity<>(notes, HttpStatus.OK);
    }

    @GetMapping("/findByStatus/{status}")
    public ResponseEntity<?> findByStatus(@PathVariable String status){
        List<NotesDto> notes = noteService.findByStatus(status);
        return new ResponseEntity<>(notes, HttpStatus.OK);
    }
}
