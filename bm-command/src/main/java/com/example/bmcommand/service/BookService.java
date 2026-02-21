package com.example.bmcommand.service;

import com.example.bmcommand.dto.request.CreateBook;
import com.example.bmcommand.dto.request.UpdateBook;
import com.example.bmcommand.dto.response.BookResponse;

public interface BookService {
    public BookResponse createBook(CreateBook createBookRequest);
    public BookResponse updateBook(UpdateBook updateBookRequest);
}
