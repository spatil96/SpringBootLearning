package com.springframework.spring5webapp.bootstrap;


import com.springframework.spring5webapp.model.Author;
import com.springframework.spring5webapp.model.Book;
import com.springframework.spring5webapp.model.Publisher;
import com.springframework.spring5webapp.repositories.AuthorRepo;
import com.springframework.spring5webapp.repositories.BookRepo;
import com.springframework.spring5webapp.repositories.PublisherRepo;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

/**
 * Created by jt on 5/16/17.
 */
@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private AuthorRepo authorRepository;
    private BookRepo bookRepository;
    private PublisherRepo publisherRepo;

    public DevBootstrap(AuthorRepo authorRepository, BookRepo bookRepository, PublisherRepo publisherRepo) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepo = publisherRepo;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }

    private void initData(){
        Publisher pub = new Publisher();
        pub.setName("foo");
        publisherRepo.save(pub);
        //Eric
        Author eric = new Author("Eric", "Evans");
        Book  ddd = new Book("Domain Driven Design", "1234", pub);
        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);

        authorRepository.save(eric);
        bookRepository.save(ddd);


        //Rod
        Author rod = new Author("Rod", "Johnson");
        Book noEJB = new Book("J2EE Development without EJB", "23444", pub);
        rod.getBooks().add(noEJB);
        noEJB.getAuthors().add(rod);

        authorRepository.save(rod);
        bookRepository.save(noEJB);
    }
}
