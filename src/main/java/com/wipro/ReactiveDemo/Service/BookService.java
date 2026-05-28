package com.wipro.ReactiveDemo.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wipro.ReactiveDemo.Entity.Book;
import com.wipro.ReactiveDemo.Repository.BookRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class BookService {

	@Autowired
	BookRepository repository;

	public Mono<Book> addBook(Book obj) {
		return repository.save(obj);
	}

	public Flux<Book> getBooks() {
		return repository.findAll();
	}

	public Mono<Book> getOneBook(int id) {

		//Method- 1 (Error handling )
		// id not available
		   if(repository.existsById(id) == null)
		   {
			   return Mono.error(new RuntimeException("book is not found!"));
		   }
		return repository.findById(id);

		
		
		//Method- 2 (Error handling )
//		return repository.findById(id).onErrorResume(ex -> {
//
//			Book errorBook = new Book();
////			errorBook.setName(ex.getMessage());
//			errorBook.setName("Book Not found");
//			return Mono.just(errorBook);
//
//		});
		
		

	}

	public Mono<Book> updateBook(int id, Book newBook) {
		return repository.findById(id).flatMap(book -> {
			book.setName(newBook.getName());
			book.setPrice(newBook.getPrice());

			return repository.save(book);

		});
	}

	public String deleteBook(int id) {
		repository.deleteById(id);
		return "Book deleted";
	}

}
