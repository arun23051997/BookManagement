package com.example.book.management.repositor;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.book.management.entity.MyBookListEntity;

@Repository
public interface MyBookListRepo extends JpaRepository<MyBookListEntity,Integer>{

}
