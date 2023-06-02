package com.springframework.spring5webapp.repositories;

import com.springframework.spring5webapp.model.Book;
import com.springframework.spring5webapp.model.Publisher;
import org.springframework.data.repository.CrudRepository;

public interface PublisherRepo extends CrudRepository<Publisher, Long> {
}
