package com.driver.Converter;

import com.driver.RequestDto.BookRequestDto;
import com.driver.models.Author;
import com.driver.models.Book;
import com.driver.repositories.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class BookConverter {

    public static Book convertDtoToBook(BookRequestDto bookRequestDto) {

        Book book;
        try {
            book = Book.builder().name(bookRequestDto.getName()).genre(bookRequestDto.getGenre()).
                    available(bookRequestDto.isAvailable()).build();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return book;
    }
}
