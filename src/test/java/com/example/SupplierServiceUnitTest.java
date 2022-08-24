package com.example;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.ArgumentMatchers.any;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.example.dto.SupplierDTO;
import com.example.model.Supplier;
import com.example.repository.SupplierRepo;
import com.example.service.SupplierService;

@SpringBootTest
public class SupplierServiceUnitTest {
		
	@Autowired
	private SupplierService service;
		
	@MockBean
	private SupplierRepo repo;	
//	
	
	final Supplier SAVED_SUPPLIER = new Supplier(1L, "funbim", "pas1s234", "akanji@gmail.com","Oxford",
			         "Uganda", 123456, 0, null);
	@Test
	void testCreateSupplier() throws Exception
	{
		final Supplier TEST_SUPPLIER = new Supplier(null, "funbim", "pas1s234", "akanji@gmail.com","Oxford",
		         "Uganda", 123456, 0, null);
		given(this.repo.save(TEST_SUPPLIER)).willReturn(TEST_SUPPLIER);
		
		SupplierDTO saveDto = this.service.createSupplier(TEST_SUPPLIER);
		
		assertThat(saveDto).usingRecursiveComparison().isEqualTo(TEST_SUPPLIER);
		
	}
	
	@Test
	void testUpdateSupplier()
	{
		given(repo.save(any(Supplier.class))).willReturn(SAVED_SUPPLIER);
		
		Supplier SAVED_Supplier = repo.save(SAVED_SUPPLIER);
		
		assertThat(SAVED_Supplier.getSupplierName()).isNotNull();
	}
	
	@Test
	void testFindAllSupplier()
	{
		List<Supplier> Suppliers = new ArrayList<>();
		Suppliers.add(SAVED_SUPPLIER);
		Suppliers.add(new Supplier (2L, "bimfun", "pa34s1s2", "njiaka@gmail.com","Oforxd",
		         "ndaUga", 124563, 1, null));
		Suppliers.add(new Supplier (3L, "Bimbim", "123pass", "bimtim@gmail.com", "Newyork", 
				 "Niger", 657489, 2, null));
		
		given(repo.findAll()).willReturn(Suppliers);
		
		List<SupplierDTO> expected = service.readSupplier();
		
		assertThat(expected).usingRecursiveComparison().isEqualTo(Suppliers);
	}
	
	@Test
	void testFindByIdSupplier()
	{
		final Long id = 1L;
		final Supplier TEST_Supplier_ID = new Supplier();
		
		given(repo.findById(id)).willReturn(Optional.of(TEST_Supplier_ID));
		
		final SupplierDTO expected = service.findById(id);
		
		assertThat(expected).isNotNull();
	}
	
	@Test
	void testDeletionSupplier()
	{
		final Long id = 1L;
		
		service.deleteSupplier(id);
		service.deleteSupplier(id);
		
		verify(repo, times(2)).deleteById(id);
	}
}