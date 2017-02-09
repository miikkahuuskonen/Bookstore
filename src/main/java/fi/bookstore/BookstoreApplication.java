package fi.bookstore;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fi.bookstore.model.Book;
import fi.bookstore.model.BookRepository;
import fi.bookstore.model.User;
import fi.bookstore.model.UserRepository;

@SpringBootApplication
public class BookstoreApplication {
	private static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner demo(BookRepository repository, UserRepository urepository) {
	  
	 return (args) -> {
		 Book a = new Book(0, "Jaanin elämä", "Miikka Alatalo", 2016, "isbn1234", 13.37);
		 Book b = new Book(0, "Javaa jokaiselle", "Jaan Java", 2015, "isbn4321", 16.00);
		 Book c = new Book(0, "Git workflow", "Erik Erimieli", 2016, "isbn5678", 29.90);
		 repository.save(a);
		 repository.save(b);
		 repository.save(c);
		 
		 User user1 = new User("user", "$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6", "USER");
		 User user2 = new User("admin", "$2a$05$bvIG6Nmid91Mu9RcmmWZfO5HJIMCT8riNW0hEp8f6/FuA2/mHZFpe", "ADMIN");
		 urepository.save(user1);
		 urepository.save(user2);
		 
		 log.info("fetch all books");
			for (Book book : repository.findAll()) {
				log.info(book.toString());
			}
	   
	 }; 
	 
	}
}
