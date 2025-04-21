package com.example.book.management.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.book.management.entity.BookEntity;
import com.example.book.management.repositor.BookRepository;

@Service
public class BookService {
	
	
	@Autowired
	private BookRepository repoObj;
	
	public List<BookEntity> getAllBook() {
		return repoObj.findAll();
	}

	public void save(BookEntity b) {
		repoObj.save(b);
		
	}

	public BookEntity getBookById(int id) {
		// TODO Auto-generated method stub
		return repoObj.findById(id).get();
	}

	public void deleteById(int id) {
		// TODO Auto-generated method stub
		repoObj.deleteById(id);
	}
}
