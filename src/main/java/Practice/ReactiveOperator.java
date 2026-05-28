package Practice;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

public class ReactiveOperator {

    public static void main(String[] args) {

        Flux<String> students = Flux.just(
                "sakshi",
                "rahul",
                "aman",
                "riya",
                "john"
        );

        Mono<List<String>> result = students

                // filter names starting with r
                .filter(name -> name.startsWith("r"))

                // convert to uppercase
                .map(String::toUpperCase)

                // print each value
                .doOnNext(System.out::println)

                // add welcome text
                .flatMap(name ->
                        Mono.just("Welcome " + name)
                )

                // convert Flux to List
                .collectList();

        result.subscribe(System.out::println);
    }
}