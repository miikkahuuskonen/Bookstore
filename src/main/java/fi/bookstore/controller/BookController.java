package fi.bookstore.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fi.bookstore.model.Book;

@Controller
public class BookController {
	
	@RequestMapping(value="/booklist", method=RequestMethod.GET) 
	public String booklist(@ModelAttribute Book friend, Model model){
	
		return "/booklist";
	}
	
	 

}
