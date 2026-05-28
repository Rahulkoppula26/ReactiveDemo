package com.wipro.ReactiveDemo.Entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Setter
@Getter
@Document
public class Book {
	@Id
	private int id;
	private String name;
	private int price;
	private String publisher;
	
	
}
