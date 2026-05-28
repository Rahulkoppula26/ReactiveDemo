package com.wipro.ReactiveDemo.Repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.wipro.ReactiveDemo.Entity.Book;

public interface BookRepository extends ReactiveMongoRepository<Book, Integer> {

}
