package com.driver.services;

import com.driver.Converter.BookConverter;
import com.driver.RequestDto.BookRequestDto;
import com.driver.models.Author;
import com.driver.models.Book;
import com.driver.models.Card;
import com.driver.repositories.AuthorRepository;
import com.driver.repositories.BookRepository;
import com.driver.repositories.CardRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class BookService {
    @Autowired
    private AuthorRepository authorRepository;


    @Autowired
    BookRepository bookRepository;

    @Autowired
    CardRepository cardRepository;

    public String create(BookRequestDto bookRequestDto) {
        Book book   = BookConverter.convertDtoToBook(bookRequestDto);

        int aurthorId = bookRequestDto.getAuthorId();

        Author author = authorRepository.findById(aurthorId).get();
        book.setAuthor(author);

        List<Book> currentListOfBooks = author.getBooksWritten();
        currentListOfBooks.add(book);
        author.setBooksWritten(currentListOfBooks);

        authorRepository.save(author);

        int cardId = bookRequestDto.getCardId();

        Card card = null;
        book.setCard(card);

        List<Book> currBooks = card.getBooks();
        currBooks.add(book);
        card.setBooks(currBooks);

        cardRepository.save(card);

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
