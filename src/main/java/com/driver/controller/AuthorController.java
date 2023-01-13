package com.driver.controller;

import com.driver.RequestDto.AuthorRequestDto;
import com.driver.repositories.AuthorRepository;
import com.driver.services.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

//Add required annotations
@RestController
public class AuthorController {

    //Write createAuthor API with required annotations

    @Autowired
    AuthorService authorService;

    @PostMapping("/author")
    public ResponseEntity<String> createAuthor(@RequestBody()AuthorRequestDto authorRequestDto) {

        String res = null;
        try {
            res = authorService.createAuthor(authorRequestDto);
        } catch (Exception e) {
            System.out.println(e);
        }

        return new ResponseEntity<>(res, HttpStatus.CREATED);

    }


}
