package com.example.book.management.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.book.management.entity.BookEntity;
import com.example.book.management.entity.MyBookListEntity;
import com.example.book.management.service.BookService;
import com.example.book.management.service.MybookListService;

@Controller
public class BookController {
		
	
	@Autowired
	private BookService serviceObj;
	
	@Autowired
	private MybookListService mybookListServiceObj;
	
	@GetMapping("/mainpage")
	public String home() {
		return "home";
	}
	
	@GetMapping("/book_Register")
	public String bookRegister() {
		return "bookRegister";
	}
	
	
	
	@GetMapping("/available_books")
	public ModelAndView getAllBook() {
		List<BookEntity>list=serviceObj.getAllBook();
//		ModelAndView m=new ModelAndView();
//		m.setViewName("bookList");
//		m.addObject("book",list);
		return new ModelAndView("bookList","book",list);
	}
	
	@PostMapping("/save")
	public String addBook(@ModelAttribute BookEntity b) {
		serviceObj.save(b);
		return "redirect:/available_books";
	}
	
	
	@GetMapping("/my_books")
	public String getMyBooks(Model model){
		System.out.println("entry------------");
		List<MyBookListEntity>list=mybookListServiceObj.getAllMyBooks();
		model.addAttribute("book",list);
		return "myBooks";
	}
	
	@RequestMapping("/mylist/{id}")
	public String getMyList(@PathVariable("id") int id) {
		BookEntity b=serviceObj.getBookById(id);
		MyBookListEntity mb=new MyBookListEntity(b.getId(),b.getName(),b.getAuthor(),b.getPrice());
		mybookListServiceObj.saveMyBooks(mb);
		return "redirect:/my_books";
	}
	
	@RequestMapping("/editBook/{id}")
	public String editBook(@PathVariable("id") int id,Model model) {
		BookEntity b=serviceObj.getBookById(id);
		model.addAttribute("book",b);
		return "bookEdit";
	}
	@RequestMapping("/deleteBook/{id}")
	public String deleteBook(@PathVariable("id")int id) {
		serviceObj.deleteById(id);
		return "redirect:/available_books";
	}
	
	@RequestMapping("/deleteMyList/{id}")
	public String deleteMyBook(@PathVariable("id")int id) {
		mybookListServiceObj.deleteById(id);
		return "redirect:/available_books";
	}
	
	
	
}