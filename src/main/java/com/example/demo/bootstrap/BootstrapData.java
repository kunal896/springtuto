package com.example.demo.bootstrap;

import com.example.demo.domain.Author;
import com.example.demo.domain.Book;
import com.example.demo.domain.Publisher;
import com.example.demo.repository.AuthorRepository;
import com.example.demo.repository.BookRepository;
import com.example.demo.repository.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootstrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootstrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Inside bootstrap overrriden run method.");

        Author kunal = new Author();
        kunal.setFirstName("Kunal");
        kunal.setLastName("Natesh");

        Book kunaBook = new Book();
        kunaBook.setTitle("Kunal's Book");

        Author kunalSaved = authorRepository.save(kunal);
        Book kunaBookSaved = bookRepository.save(kunaBook);

        Author suchi = new Author();
        suchi.setFirstName("Suchi");
        suchi.setLastName("K");

        Book suchiken = new Book();
        suchiken.setTitle("Suchi's Book");

        Author suchiSaved = authorRepository.save(suchi);
        Book suchikenSaved = bookRepository.save(suchiken);

        Publisher amazon = new Publisher();
        Publisher flipkart = new Publisher();

        amazon.setPublisherName("Amazon.com");
        flipkart.setPublisherName("Flipkart.com");

        Publisher savedAmazon = publisherRepository.save(amazon);
        Publisher savedFlipkart = publisherRepository.save(flipkart);

        // Book owns the relationship (has @JoinTable), so only this side needs updating.
        // All mutations happen before a single save per book to avoid re-inserting
        // the join table row on a second flush.
        kunaBookSaved.getAuthors().add(kunalSaved);
        kunaBookSaved.setPublisher(savedAmazon);
        bookRepository.save(kunaBookSaved);

        suchikenSaved.getAuthors().add(suchiSaved);
        suchikenSaved.setPublisher(savedFlipkart);
        bookRepository.save(suchikenSaved);

        System.out.println("Authors: " + authorRepository.count());
        System.out.println("Books: " + bookRepository.count());
        System.out.println("Publishers: " + publisherRepository.count());
    }
}