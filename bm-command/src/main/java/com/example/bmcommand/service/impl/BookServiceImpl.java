package com.example.bmcommand.service.impl;


import com.example.bmcommand.domain.Book;
import com.example.bmcommand.dto.request.CreateBook;
import com.example.bmcommand.dto.request.UpdateBook;
import com.example.bmcommand.dto.response.BookResponse;
import com.example.bmcommand.map.BookMapper;
import com.example.bmcommand.repository.BookRepository;
import com.example.bmcommand.service.BookService;
import com.example.bmcommand.service.BrokerService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

    @Autowired
    BookRepository bookRepository;

    private final BookMapper bookMapper;

    @Autowired
    private BrokerService brokerService;

    @Override
    public BookResponse createBook(CreateBook createBookRequest) {
        Book book = bookMapper.toEntity(createBookRequest);
        Book savedBook = bookRepository.save(book);
        brokerService.send("book", bookMapper.toEvent(savedBook));
        return bookMapper.toResponse(savedBook);
    }

    @Override
    public BookResponse updateBook(UpdateBook updateBookRequest) {
        if (!bookRepository.existsById(updateBookRequest.id())) {
            throw new EntityNotFoundException("Livro não encontrado com o ID: " + updateBookRequest.id());
        }
        Book book = bookMapper.toEntity(updateBookRequest);
        Book updatedBook = bookRepository.save(book);
        brokerService.send("book", bookMapper.toEvent(updatedBook));
        return bookMapper.toResponse(updatedBook);
    }
}
