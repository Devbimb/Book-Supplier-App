package com.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;


import com.example.model.Supplier;

@Repository
@EnableJpaRepositories
public interface SupplierRepo extends JpaRepository<Supplier, Long>{


			//@Query(value = "select * from books where name = ?1", nativeQuery = true)
			//List<Supplier> findsByName(long name);

			// LOGIN---> LOGIN SUPPLIER DETAIL CHECK
			@Query("SELECT bks from Supplier bks WHERE bks.userName = ?1 and bks.password=?2")
			List<Supplier> login(String userName, String password);
			
			//--------------------------------------------------------------
			// RETRIEVE---> RETRIEVE SUPPLIER BY ID
			@Query("SELECT bks from Supplier bks WHERE bks.id = ?1")
			List<Supplier> findAll(Long id);
			
			//--------------------------------------------------------------
			// RETRIEVE---> RETRIEVE SUPPLIER BY NAME		
			@Query("SELECT bks from Supplier bks WHERE bks.supplierName = ?1")
			Supplier findSupplierByName(String supplierName);
			
			//--------------------------------------------------------------
//			// RETRIEVE---> RETRIEVE SUPPLIER BY ADDRESS
//			@Query("SELECT bks from Supplier bks WHERE bks.supplierAddress = ?1 and bks.supplierEmail = 2?")
//			Supplier findSupplierByAddress(String supplierAddress, String supplierEmail);

			//--------------------------------------------------------------
//			// RETRIEVE---> RETRIEVE SUPPLIER BY PHONE
			@Query("SELECT bks from Supplier bks WHERE bks.supplierPhone = ?1")
			Supplier findSupplierByPhone(long supplierPhone);
	}

