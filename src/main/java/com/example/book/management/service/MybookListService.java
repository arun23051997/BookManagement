package com.example.book.management.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.book.management.entity.MyBookListEntity;
import com.example.book.management.repositor.MyBookListRepo;

@Service
public class MybookListService {
	
	@Autowired
	MyBookListRepo myBookListRepoObj;
	
	
	public List<MyBookListEntity> getAllMyBooks(){
		return myBookListRepoObj.findAll();
	}


	public void saveMyBooks(MyBookListEntity mb) {
		myBookListRepoObj.save(mb);
		
	}
	public void deleteById(int id) {
		myBookListRepoObj.deleteById(id);
	}
}
