package com.driver.controller;

import com.driver.models.Book;
import com.driver.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//Add required annotations
@RestController
public class BookController {


    //Write createBook API with required annotations

    @Autowired
    BookService bookService;

    @PostMapping("/book/")
    public ResponseEntity<String> createBook(@RequestBody()Book book){

        try {
            bookService.createBook(book);
        } catch (Exception e) {
            System.out.println(e);
        }

        return new ResponseEntity<>("Created", HttpStatus.CREATED);
    }

    //Add required annotations
    @GetMapping("/getBooks")
    public ResponseEntity getBooks(@RequestParam(value = "genre", required = false) String genre,
                                   @RequestParam(value = "available", required = false, defaultValue = "false") boolean available,
                                   @RequestParam(value = "author", required = false) String author){

        List<Book> bookList = bookService.getBooks( genre, available, author); //find the elements of the list by yourself
        return new ResponseEntity<>(bookList, HttpStatus.OK);

    }
}
