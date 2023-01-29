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
    private AuthorRepository authorRepository;


    @Autowired
    BookRepository bookRepository;

    @Autowired
    CardRepository cardRepository;

    public String create(Book book) {

        //Author is parent - so adding book to author booklist and saving it
        Author author = book.getAuthor();

        List<Book> bookList = author.getBooksWritten();
        bookList.add(book);
        author.setBooksWritten(bookList);

        authorRepository.save(author);
        bookRepository.save(book);

        return "Book saved sucessfully";
    }

    public void createBook(Book book){
        bookRepository.save(book);
    }

    public List<Book> getBooks(String genre, boolean available, String author){
        List<Book> books = null; //find the elements of the list by yourself
        books = bookRepository.findBooksByGenreAuthor(genre,author,available);

        return books;
    }
}
