package fi.bookstore;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import fi.bookstore.model.Book;
import fi.bookstore.model.BookRepository;

@SpringBootApplication
public class BookstoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner demo(BookRepository repository) {
	  
	 return (args) -> {
		 Book a = new Book(0, "Jaanin elämä", "Miikka Alatalo", 2016, "isbn1234", 13.37);
		 Book b = new Book(0, "Javaa jokaiselle", "Jaan Java", 2015, "isbn4321", 16.00);
		 Book c = new Book(0, "Git workflow", "Erik Erimieli", 2016, "isbn5678", 29.90);
		 repository.save(a);
		 repository.save(b);
		 repository.save(c);
	   
	 }; 
	 
	}
}
