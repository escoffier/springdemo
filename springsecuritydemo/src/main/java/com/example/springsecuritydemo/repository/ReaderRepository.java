package com.example.springsecuritydemo.repository;

import com.example.springsecuritydemo.model.Book;
import com.example.springsecuritydemo.model.Reader;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReaderRepository extends JpaRepository<Reader, String> {

    public Reader findByUsername(String username);
}
