package fi.bookstore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fi.bookstore.model.Book;
import fi.bookstore.model.BookRepository;

@Controller
public class BookController {
	
	@Autowired
	private BookRepository repository;
	
	@RequestMapping(value="/login")
    public String login() {	
       
		return "login";
	}
	
	@RequestMapping(value="/booklist", method=RequestMethod.GET) 
	public String booklist(Model model) {	
		List<Book> books= (List<Book>) repository.findAll();
		model.addAttribute("books", books);
	
		return "/booklist";
	}
	
	@RequestMapping(value= "/delete/{id}", method = RequestMethod.GET)
	public String deleteBook(@PathVariable("id") Long bookId) {
		repository.delete(bookId);
		return "redirect:/booklist";
	}
	
	@RequestMapping(value= "addStudent", method = RequestMethod.GET)
	public String addBook(Model model) {
		model.addAttribute("book", new Book());
		return "addStudent";
	}
	
	@RequestMapping(value= "save", method = RequestMethod.POST)
	public String saveBook(Book book) {
		repository.save(book);
		return "redirect:/booklist";
	}
	
	 

}
