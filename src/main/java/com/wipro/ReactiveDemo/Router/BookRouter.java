package com.wipro.ReactiveDemo.Router;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import com.wipro.ReactiveDemo.Handler.BookHandler;
import static org.springframework.web.reactive.function.server.RequestPredicates.*;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;


@Configuration
public class BookRouter {

    @Bean
    public RouterFunction<?> routes(BookHandler handler) {

        return route(GET("/books"),
                handler::getBooksList)

                .andRoute(GET("/book/{id}"),
                        handler::getBookData)

                .andRoute(POST("/add"),
                        handler::saveBook);
    }
}
