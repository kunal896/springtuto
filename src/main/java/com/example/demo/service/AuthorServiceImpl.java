package com.example.demo.service;

import com.example.demo.domain.Author;
import com.example.demo.repository.AuthorRepository;
import org.springframework.stereotype.Service;

@Service
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;

    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }


    @Override
    public Iterable<Author> findAll() {
        return authorRepository.findAll();
    }

    @Override
    public void save(Author author){
        authorRepository.save(author);
    }
}
