package com.example.springsecuritydemo.repository;

import com.example.springsecuritydemo.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BooksRepository extends JpaRepository<Book, Long> {
    public List<Book> findByReader(String reader);
}
