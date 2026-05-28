package com.wipro.ReactiveDemo.Handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.wipro.ReactiveDemo.Entity.Book;
import com.wipro.ReactiveDemo.Service.BookService;

import reactor.core.publisher.Mono;

@Component
public class BookHandler {

    @Autowired
    BookService service;

   
    public Mono<ServerResponse> getBooksList(ServerRequest req) {   // Flux
    	  return ServerResponse.ok()
    	            .body(service.getBooks(), Book.class);
    }
    
//    public Mono<ServerResponse> getBookData(ServerRequest req) {
//
//       Long id = Long.parseLong(req.pathVariable("id"));
//    	Integer id = Integer.parseInt(req.pathVariable(id));
//        return service.getOneBook(id)
//                .flatMap(book ->
//
//                        ServerResponse.ok()
//                                .contentType(MediaType.APPLICATION_JSON)
//                                .bodyValue(book)
//                );
//    }
    
    public Mono<ServerResponse> getBookData(ServerRequest req) {

        Integer id = Integer.parseInt(req.pathVariable("id"));

        return service.getOneBook(id)
                .flatMap(book ->

                        ServerResponse.ok()
                                .contentType(MediaType.APPLICATION_JSON)
                                .bodyValue(book)
                );
    }
    public Mono<ServerResponse> saveBook(ServerRequest request) {

        return request.bodyToMono(Book.class)
                .flatMap(service::addBook)
                .flatMap(savedBook ->

                        ServerResponse.ok()
                                .contentType(MediaType.APPLICATION_JSON)
                                .bodyValue(savedBook)
                );
    }

    
}
