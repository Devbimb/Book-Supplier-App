package com.example;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.example.dto.BookDTO;
import com.example.model.Book;
import com.example.repository.BookRepo;
import com.example.service.BookService;

@SpringBootTest
public class BookServiceUnitTest {

	@Autowired
	private BookService service;
		
	@MockBean
	private BookRepo repo;	
//	
	
	final Book SAVED_BOOK = new Book(1L, "science", "Send Down the Rain", "Chinua Achebe", "Oxford",
			"second", 3, "Novel", "Donated", "Individual", "Wood", "UK", 124563, "Wornout", "repaired", null);
	
	@Test
	void testCreateBook() throws Exception
	{
		final Book TEST_BOOK = new Book(null, "science", "Send Down the Rain", "Chinua Achebe", "Oxford",
				"second", 3, "Novel", "Donated", "Individual", "Wood", "UK", 124563, "Wornout", "repaired", null);

		given(this.repo.save(TEST_BOOK)).willReturn(TEST_BOOK);
		
		BookDTO saveDto = this.service.createBook(TEST_BOOK);
		
		assertThat(saveDto).usingRecursiveComparison().isEqualTo(TEST_BOOK);
		
	}
	
	@Test
	void testUpdateBook()
	{
		given(repo.save(any(Book.class))).willReturn(SAVED_BOOK);
		
		Book SAVED_Book = repo.save(SAVED_BOOK);
		
		assertThat(SAVED_Book.getBkname()).isNotNull();
	}
	
	@Test
	void testFindAllBook()
	{
		List<Book> Books = new ArrayList<>();
		Books.add(SAVED_BOOK);
		Books.add(new Book (2L, "scencei", "Send the Rain Down ", "AchebeChinua", "ordOxf",
				"Third", 2, "Journal", "Paid", "Company", "Grass", "US", 145623, "good", "not need repair", null));
		Books.add(new Book (3L, "Biology", "Modern Biology", "Okeke", "Cambrigde",
				"fourth", 3, "Text book", "Donated", "QA", "Grass", "US", 145623, "Excellent", "not need repair", null));
		
		given(repo.findAll()).willReturn(Books);
		
		List<BookDTO> expected = service.readBook();
		
		assertThat(expected).usingRecursiveComparison().isEqualTo(Books);
	}
	
	@Test
	void testFindByIdBook()
	{
		final Long id = 1L;
		final Book TEST_Book_ID = new Book();
		
		given(repo.findById(id)).willReturn(Optional.of(TEST_Book_ID));
		
		final BookDTO expected = service.findById(id);
		
		assertThat(expected).isNotNull();
	}
	
	@Test
	void testDeletionBook()
	{
		final Long id = 1L;
		
		service.deleteBook(id);
		service.deleteBook(id);
		
		verify(repo, times(2)).deleteById(id);
	}
}	