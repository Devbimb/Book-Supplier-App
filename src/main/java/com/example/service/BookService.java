package com.example.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.example.dto.BookDTO;
import com.example.exception.BookNotFoundException;
import com.example.model.Book;
import com.example.repository.BookRepo;

@Service
public class BookService {
	
	@Autowired
	private BookRepo bookrepo;

	@Autowired
	private ModelMapper mapper;
	
	private BookDTO mapToDTO(Book bk1) 
	{
		return this.mapper.map(bk1, BookDTO.class);
	}
//-----------------------------------------------------------------------------------------------------------
	public BookService(BookRepo bookrepo, ModelMapper mapper) {
		super();
		this.bookrepo = bookrepo;
		this.mapper = mapper;
	}
//-----------------------------------------------------------------------------------------------------------
	//--------------------------------------------------------------
	//--------------------------C  R  U  D--------------------------
	//--------------------------------------------------------------
	// c---> CREATE BOOK DTO
	public BookDTO createBook(Book bk1) 
	{
		Book saved = this.bookrepo.save(bk1);
		return this.mapToDTO(saved);
	}
	
//--------------------------------------------------------------
	// R---> READ ALL BOOK
	public List<BookDTO> readBook() 
	{
		return this.bookrepo.findAll().stream()
							.map(this::mapToDTO)
							.collect(Collectors.toList());
	}
	
	//--------------------------------------------------------------
		// U---> UPDATE BOOK		
	public BookDTO updateBook(Long id, Book bk2) {
		Optional<Book> existingOptional = this.bookrepo.findById(id);
		Book existing = existingOptional.get();
		
		existing.setBkname(bk2.getBkname());
		existing.setBktitle(bk2.getBktitle());
		existing.setBkauthor(bk2.getBkauthor());
		existing.setBkpublisher(bk2.getBkpublisher());
		existing.setBkedition(bk2.getBkedition());
		existing.setBkqantity(bk2.getBkqantity());
		existing.setBktype(bk2.getBktype());
		existing.setBksource(bk2.getBksource());
		existing.setSourcetype(bk2.getSourcetype());
		existing.setSourceName(bk2.getSourceName());
		existing.setSourceAddress(bk2.getSourceAddress());
		existing.setSourcePhone(bk2.getSourcePhone());
		existing.setBkstate(bk2.getBkstate());
		existing.setBkneed(bk2.getBkneed());
		existing.setBkneed(bk2.getBkneed());
		
		Book updated = this.bookrepo.save(existing);
		return this.mapToDTO(updated);
		
	}
	//--------------------------------------------------------------
	// D---> DELETE BOOK			
	public boolean deleteBook(long id) 
	{
		this.bookrepo.deleteById(id);
		boolean exists = this.bookrepo.existsById(id);
		return !exists;
	}
	//--------------------------------------------------------------
	
//-----------------------------------------------------------------------------------------------------------
	//--------------------------------------------------------------
	//--------------------Q  U  E  R  I  E  S-----------------------
	//--------------------------------------------------------------	
	
//	//--------------------------------------------------------------
//	// RETRIEVE---> RETRIEVE BOOKSUPPLIER BY ID
	public BookDTO findById(long id) 
	{
      Book found = this.bookrepo
      						 .findById(id)
      						 .orElseThrow(BookNotFoundException::new);
      return this.mapToDTO(found);
  }
	
//	//--------------------------------------------------------------
////	// RETRIEVE---> RETRIEVE BOOK BY NAME
	public BookDTO findBookByName(String bkname) 
	{
      return mapToDTO(bookrepo.findBookByName(bkname));
    }
////	
////	//--------------------------------------------------------------
////	// RETRIEVE---> RETRIEVE BOOK BY TITLE AND AUTHOR 
//	public BookDTO findBookByTitleAuthor(String bktitle, String bkauthor) 
//	{
//      return mapToDTO(bookrepo.findBookByTitleAuthor(bktitle, bkauthor));
//  }
////
////	//--------------------------------------------------------------
//	// RETRIEVE---> RETRIEVE BOOK BY QUANTITY
	public BookDTO findBookByQuantity(long bkqantity) 
	{
      return mapToDTO(bookrepo.findBookByQuantity(bkqantity));
  }
////	//--------------------------------------------------------------
//	
}
