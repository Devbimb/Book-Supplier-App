package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.dto.BookDTO;
import com.example.model.Book;
import com.example.repository.BookRepo;
import com.example.service.BookService;

	@RestController
	@RequestMapping//(value = "/book")
	public class BookController {
		
		@Autowired
		private BookService bookservice;
		
		@Autowired
		private BookRepo bookrepo;
		
		public BookController(BookService bookservice, BookRepo bookrepo) {
			super();
			this.bookservice = bookservice;
			this.bookrepo = bookrepo;
		}
		//---------------------C R U D ----I N----P O S T M A N---------------------
		// c---> CREATE BOOK	
		@PostMapping("/Book/createbook")
		@ResponseStatus(code = HttpStatus.CREATED)
		public BookDTO createbook(@RequestBody Book bk1) 
		{
			return this.bookservice.createBook(bk1);
		}
		//--------------------------------------------------------------
		// R---> READ ALL BOOK
		@GetMapping("/Book/readbook")
		public List<BookDTO> readbook()
		{
			return this.bookservice.readBook();
		}
		//--------------------------------------------------------------
		// U---> UPDATE BOOK
		@PutMapping("/Book/updatebook/{id}")
		public BookDTO updatebook(@PathVariable Long id,@RequestBody Book bk2)
		{
			return this.bookservice.updateBook(id, bk2);
		}
		//--------------------------------------------------------------
		// D---> DELETE BOOK
			
		@DeleteMapping("/Book/deletebook/{id}")
		//public boolean deletebook(@PathVariable Long id) 
		public void deletebook(@PathVariable Long id)
		{
			//return this.bookservice.deleteBook(id);
			this.bookservice.deleteBook(id);
		}
		
		//--------------------------------------------------------------
		// RETRIEVE---> RETRIEVE BOOK BY ID
		@GetMapping("/Book/readbookById/{id}")
		public BookDTO readBookById(@PathVariable Long id)
		{
			return this.bookservice.findById(id);
		}	
//		//--------------------------------------------------------------
//		// RETRIEVE---> RETRIEVE BOOKSUPPLIER BY NAME
		@GetMapping("/Book/readbookByName/{bkname}")
		public BookDTO readBookByName(@PathVariable String bkname)
		{
			return this.bookservice.findBookByName(bkname);
		}	
//		
////		//--------------------------------------------------------------
//		// RETRIEVE---> RETRIEVE BOOK BY TITLE AND AUTHOR
//		@GetMapping("/Book/readbookByTitle&Author/{bktitle, bkauthor}")
//		public BookDTO readBookByTitleAuthor(@PathVariable String bktitle, @PathVariable String bkauthor)
//		{
//			return this.bookservice.findBookByTitleAuthor(bktitle, bkauthor);
//		}	
//	//	
//		//--------------------------------------------------------------
//		// RETRIEVE---> RETRIEVE BOOK BY QUANTITY
		@GetMapping("/Book/readbookByQuantity/{bkqantity}")
		public BookDTO readBookByQuantity(@PathVariable Long bkqantity)
		
		{
			return this.bookservice.findBookByQuantity(bkqantity);
		}	
		
	}
