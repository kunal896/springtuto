package com.example.demo.service;

import com.example.demo.domain.Book;
import com.example.demo.repository.BookRepository;

public class BookServiceImpl implements BookService{

    private BookRepository bookRepository;


    @Override
    public Iterable<Book> findAll()
    {
        return bookRepository.findAll();
    }
}
