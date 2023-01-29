package com.driver.services;

import com.driver.models.Author;
import com.driver.models.Book;
import com.driver.repositories.AuthorRepository;
import com.driver.repositories.BookRepository;
import com.driver.repositories.CardRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class BookService {
    @Autowired
    BookRepository bookRepository;


    public void createBook(Book book){

        bookRepository.save(book);
    }

    public List<Book> getBooks(String genre, boolean available, String author){
        if(genre != null && author != null){
            return bookRepository.findBooksByGenreAuthor(genre, author, available);
        }else if(genre != null){
            return bookRepository.findBooksByGenre(genre, available);
        }else if(author != null){
            return bookRepository.findBooksByAuthor(author, available);
        }else{
            return bookRepository.findByAvailability(available);
        }
    }

}
