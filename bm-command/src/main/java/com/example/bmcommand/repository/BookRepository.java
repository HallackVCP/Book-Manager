package com.example.bmcommand.repository;

import com.example.bmcommand.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
