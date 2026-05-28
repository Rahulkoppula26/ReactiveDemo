//package com.wipro.ReactiveDemo.Controller;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.wipro.ReactiveDemo.Entity.Book;
//import com.wipro.ReactiveDemo.Service.BookService;
//
//import reactor.core.publisher.Flux;
//import reactor.core.publisher.Mono;
//
//@RestController
//public class BookController {
//	
//	    @Autowired
//	    BookService service;
//	
//	    @GetMapping("/books")
//	    public Flux<Book> getBooksList() {   // Flux
//	        return service.getBooks();
//	    }
//	    
//	    @GetMapping("/book/{id}")
//	    public Mono<Book> getBookData(@PathVariable int id) {    // Mono
//	        return service.getOneBook(id);
//	    }
//	    
//	    
//	    @PostMapping("/add")
//	    public Mono<Book> addBooks(@RequestBody Book obj) {   // Flux
//	        return service.addBook(obj);
//	    }
//	    
//	    @DeleteMapping("book.{id}")
//	    public String deleteBook(@PathVariable int id) {
//	    	return service.deleteBook(id);
//	    }
//	    
//}
