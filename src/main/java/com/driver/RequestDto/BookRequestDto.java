package com.driver.RequestDto;

import com.driver.models.Author;
import com.driver.models.Genre;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Data
public class BookRequestDto {
    private String name;
    @Enumerated(EnumType.STRING)
    private Genre genre;

    private Author author;

    public BookRequestDto(){
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public BookRequestDto(String name, Genre genre, Author author) {
        this.name = name;
        this.genre = genre;
        this.author = author;
    }
}
