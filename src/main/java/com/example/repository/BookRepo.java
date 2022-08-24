package com.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.example.model.Book;

	@Repository
	@EnableJpaRepositories
	public interface BookRepo extends JpaRepository<Book, Long>
	{
		//--------------------------------------------------------------
		// RETRIEVE---> RETRIEVE BOOK BY ID
		@Query("SELECT bk from Book bk WHERE bk.id = ?1")
		List<Book> findAll(Long id);
		
		//--------------------------------------------------------------
		// RETRIEVE---> RETRIEVE BOOK BY NAME		
		@Query("SELECT bk from Book bk where bk.bkname =?1")
		Book findBookByName(String bkname);
//		
//		//--------------------------------------------------------------
//		// RETRIEVE---> RETRIEVE BOOK BY TITLE AND AUTHOR 
//		@Query("SELECT bk from Book bk WHERE bk.bktitle = ?1 and bk.bkauthor = 2?")
//		Book findBookByTitleAuthor(String bktitle, String bkauthor);
//
//		//--------------------------------------------------------------
////		// RETRIEVE---> RETRIEVE BOOK BY QUANTITY
		@Query("SELECT bk from Book bk WHERE bk.bkqantity = ?1")
		Book findBookByQuantity(Long bkqantity);
		
	}
