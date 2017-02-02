package fi.bookstore.controller;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import fi.bookstore.model.Book;
import fi.bookstore.model.BookRepository;

@Controller
public class BookController {
	
	@RequestMapping("/index") 
	public String index(Model model){
	
		return "/index";
	}
	
	 

}
