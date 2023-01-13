package com.driver.controller;

import com.driver.RequestDto.BookRequestDto;
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
    public ResponseEntity<String> createBook(@RequestBody()BookRequestDto bookRequestDto){

        String res = null;
        try {
            res = bookService.create(bookRequestDto);
        } catch (Exception e) {
            System.out.println(e);
        }

        return new ResponseEntity<>(res, HttpStatus.CREATED);
    }

    //Add required annotations
    public ResponseEntity getBooks(@RequestParam(value = "genre", required = false) String genre,
                                   @RequestParam(value = "available", required = false, defaultValue = "false") boolean available,
                                   @RequestParam(value = "author", required = false) String author){

        List<Book> bookList = null; //find the elements of the list by yourself
        try{
            bookList = bookService.getBooks(genre,available,author);
        }catch (Exception e){
            System.out.println(e);
        }

        return new ResponseEntity<>(bookList, HttpStatus.OK);

    }
}
