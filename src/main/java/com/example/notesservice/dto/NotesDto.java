package com.example.notesservice.dto;

import com.example.notesservice.annotation.IsValidStatus;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Objects;

public class NotesDto {

    private long id;
    @NotNull
    @Size(min = 5, max = 20)
    private String title;
    @NotNull
    @Size(min = 5, max = 20)
    private String author;
    @NotNull
    @Size(min = 5, max = 200)
    private String description;
    @NotNull
    @IsValidStatus(listOfValidStatus = "completed|pending")
    private String status;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NotesDto notesDto = (NotesDto) o;
        return id == notesDto.id && Objects.equals(title, notesDto.title) && Objects.equals(author, notesDto.author) && Objects.equals(description, notesDto.description) && Objects.equals(status, notesDto.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, author, description, status);
    }

    @Override
    public String toString() {
        return "NotesDto{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", description='" + description + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
