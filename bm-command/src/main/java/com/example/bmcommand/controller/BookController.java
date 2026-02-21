package com.example.bmcommand.controller;


import com.example.bmcommand.dto.request.CreateBook;
import com.example.bmcommand.dto.request.UpdateBook;
import com.example.bmcommand.dto.response.BookResponse;
import com.example.bmcommand.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController("/book")
public class BookController {


    @Autowired
    private BookService bookService;

    @PostMapping
    public ResponseEntity<BookResponse> createBook(@RequestBody CreateBook createBookRequest){
        return ResponseEntity.ok(bookService.createBook(createBookRequest));
    }

    @PutMapping
    public ResponseEntity<BookResponse> updateBook(@RequestBody UpdateBook updateBookRequest) {
        return ResponseEntity.ok(bookService.updateBook(updateBookRequest));
    }
}
