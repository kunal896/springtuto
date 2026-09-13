package com.example.demo.bootstrap;

import com.example.demo.domain.Author;
import com.example.demo.domain.Book;
import com.example.demo.repository.AuthorRepository;
import com.example.demo.repository.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootstrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    public BootstrapData(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Author Kunal = new Author();
        Book kuna_book = new Book();

        Author kunalSaved = authorRepository.save(Kunal);
        Book kunaBookSaved = bookRepository.save(kuna_book);

        kunalSaved.getBooks().add(kunaBookSaved);

        Author suchi = new Author();
        Book suchiken = new Book();

        Author suchiSaved = authorRepository.save(suchi);
        Book suchikenSaved = bookRepository.save(suchiken);

        suchiSaved.getBooks().add(suchiken);

    }
}
