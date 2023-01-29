package com.driver.controller;

import com.driver.services.TransactionService;
import io.swagger.annotations.Authorization;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

//Add required annotations
@RestController("/transaction")
@Slf4j
public class TransactionController {

    //Add required annotations
    @Autowired
    TransactionService transactionService;

    @PostMapping("/issueBook")
    public ResponseEntity issueBook(@RequestParam("cardId") int cardId, @RequestParam("bookId") int bookId) throws Exception{
        try{
            String  transactionId =  transactionService.issueBook(cardId,bookId);
        }catch (Exception e){
            log.info("issueBook failed");
            System.out.println(e);
        }

       return new ResponseEntity<>("transaction completed", HttpStatus.ACCEPTED);
    }

    //Add required annotations

    @PostMapping("/transaction/returnBook")
    public ResponseEntity returnBook(@RequestParam("cardId") int cardId, @RequestParam("bookId") int bookId) throws Exception{
            transactionService.returnBook(cardId, bookId);
        return new ResponseEntity<>("transaction completed", HttpStatus.ACCEPTED);
    }
}
