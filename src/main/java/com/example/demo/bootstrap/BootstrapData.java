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
        Author Kunal = new Author();
        Kunal.setFirstName("Kunal");
        Kunal.setLastName("Natesh");

        Book kuna_book = new Book();
        kuna_book.setTitle("Kunal's Book");

        Author kunalSaved = authorRepository.save(Kunal);
        Book kunaBookSaved = bookRepository.save(kuna_book);

        kunalSaved.getBooks().add(kunaBookSaved);

        Author suchi = new Author();
        suchi.setFirstName("Suchi");
        suchi.setLastName("K");

        Book suchiken = new Book();
        suchiken.setTitle("Suchi's Book");

        Author suchiSaved = authorRepository.save(suchi);
        Book suchikenSaved = bookRepository.save(suchiken);



        suchiSaved.getBooks().add(suchiken);
        kunaBookSaved.getAuthors().add(Kunal);
        suchikenSaved.getAuthors().add(suchi);

        authorRepository.save(kunalSaved);
        authorRepository.save(suchiSaved);
        bookRepository.save(kunaBookSaved);
        bookRepository.save(suchikenSaved);

        System.out.println("Authors: " + authorRepository.count());
        System.out.println("Books: " + bookRepository.count());


        Publisher Amazon = new Publisher();
        Publisher Flipkart = new Publisher();

        Publisher savedAmazon = publisherRepository.save(Amazon);
        Publisher savedFlipkart = publisherRepository.save(Flipkart);

        System.out.println("Publishers: " + authorRepository.count());

    }
}
