package Practice;

import reactor.core.publisher.Mono;

public class ErrorHandling {
	
	public static Mono<String> getData() {
		// Simulate an error scenario
		double number = Math.random();
		if (number < 0.5) {
			return Mono.error(new RuntimeException("Error occurred!   " + number));
		} else {
			return Mono.just("Success     " + number);
		}
	} 
	
	public static void main(String[] args) {
		
		getData().subscribe(data -> System.out.println("Data: " + data),
				error -> System.err.println("Error: " + error.getMessage()));
	}

	

}