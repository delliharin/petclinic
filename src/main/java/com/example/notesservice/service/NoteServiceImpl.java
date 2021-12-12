package com.example.notesservice.service;


import com.example.notesservice.dto.NotesDto;
import com.example.notesservice.exception.NoteIdNotFoundException;
import com.example.notesservice.model.Note;
import com.example.notesservice.repo.NoteRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class NoteServiceImpl implements NoteService {
    @Autowired
    private NoteRepository repository;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<NotesDto> findAll() {
        List<NotesDto> notesDtos = repository.findAll().stream().map(this::convertEntityToDto).collect(Collectors.toList());
        return notesDtos;
    }

    @Override
    public NotesDto save(NotesDto notesDto) {
        Note savedNote = repository.save(convertDtoToEntity(notesDto));
        return convertEntityToDto(savedNote);
    }

    @Override
    public NotesDto deleteById(Integer id) throws NoteIdNotFoundException {
        Note note = repository.findById(id).orElseThrow(()->new NoteIdNotFoundException("Note not found  for this id ::"+id));
        repository.delete(note);
        return convertEntityToDto(note);
    }

    @Override
    public NotesDto getById(Integer id) throws NoteIdNotFoundException{
        Note note = repository.findById(id).orElseThrow(()->new NoteIdNotFoundException("Note not found  for this id ::"+id));
        return convertEntityToDto(note);
    }

    @Override
    public NotesDto updateStatus(Integer id, String status) throws NoteIdNotFoundException{
        Note note = repository.findById(id).orElseThrow(()->new NoteIdNotFoundException("Note not found  for this id ::"+id));
        note.setStatus(status);
        Note updatedNote = repository.save(note);
        return convertEntityToDto(updatedNote);
    }

    @Override
    public List<NotesDto> findByAuthor(String author) {
      List<NotesDto> notesDto = repository.findByAuthor(author).stream().map(this::convertEntityToDto).collect(Collectors.toList());
        return notesDto;
    }

    @Override
    public List<NotesDto> findByStatus(String status) {
        List<NotesDto> notesDto = repository.findByStatus(status).stream().map(this::convertEntityToDto).collect(Collectors.toList());
        return notesDto;
    }

    private NotesDto convertEntityToDto(Note note){
      modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
      NotesDto notesDto = modelMapper.map(note,NotesDto.class);
      return notesDto;
    }

    private Note convertDtoToEntity(NotesDto notesDto){
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
        Note note= modelMapper.map(notesDto,Note.class);
        return note;
    }
}
