package com.example.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dto.SupplierDTO;
import com.example.exception.SupplierNotFoundException;
import com.example.model.Supplier;
import com.example.repository.SupplierRepo;


@Service
public class SupplierService {

	
	@Autowired
	private SupplierRepo supplierrepo;
	
	@Autowired
	private ModelMapper mapper;
	
	private SupplierDTO mapToDTO(Supplier bks1)
	{
		return this.mapper.map(bks1, SupplierDTO.class);
	}		
//-----------------------------------------------------------------------------------------------------------

	public SupplierService(SupplierRepo supplierrepo, ModelMapper mapper) {
//		super();
		this.supplierrepo = supplierrepo;
		this.mapper = mapper;
	}
//-----------------------------------------------------------------------------------------------------------
	//--------------------------------------------------------------
	//--------------------------C  R  U  D--------------------------
	//--------------------------------------------------------------

	// c---> CREATE SUPPLIER DTO
	public SupplierDTO createSupplier(Supplier bks1) 
	{
		Supplier saved = this.supplierrepo.save(bks1);
		return this.mapToDTO(saved);
	}

	//--------------------------------------------------------------
	
	// R---> READ ALL SUPPLIER
	public List<SupplierDTO> readSupplier() 
	{
		return this.supplierrepo.findAll().stream()
							.map(this::mapToDTO)
							.collect(Collectors.toList());
	}
	//--------------------------------------------------------------
	
	// U---> UPDATE BOOKSUPPLIER	
	public SupplierDTO updateSupplier(Long id, Supplier bks2) 
	{
		Optional<Supplier>existingOptional = this.supplierrepo.findById(id);
		Supplier existing = existingOptional.get();
		
		existing.setAccess(bks2.getAccess()); 
		existing.setSupplierName(bks2.getSupplierName()); 
		existing.setSupplierAddress(bks2.getSupplierAddress()); 
		existing.setSupplierPhone(bks2.getSupplierPhone()); 
		existing.setSupplierEmail(bks2.getSupplierEmail());
		 
		Supplier updated =  this.supplierrepo.save(existing);
		return this.mapToDTO(updated);
	}
	
	//--------------------------------------------------------------
	
	// D---> DELETE SUPPLIER			
	public boolean deleteSupplier(long id) 
	{
		this.supplierrepo.deleteById(id); //delete without info
		boolean exists = this.supplierrepo.existsById(id);
		return !exists;
	}
	//--------------------------------------------------------------
	
//-----------------------------------------------------------------------------------------------------------
	//--------------------------------------------------------------
	//--------------------Q  U  E  R  I  E  S-----------------------
	//--------------------------------------------------------------	
	
	// LOGIN---> LOGIN SUPPLIER/PASS FLAG
	public int checkCredentials(String userName, String password)
	{
		int flag = 0;
		if(!supplierrepo.login(userName, password).isEmpty())
		{
			flag = 1;
			System.out.println("inside " + flag);
			return flag;
		}
			System.out.println("out -- " + flag);
			return flag;
	}
	
//	//--------------------------------------------------------------
//	// RETRIEVE---> RETRIEVE SUPPLIER BY ID
	public SupplierDTO findById(long id) 
	{
        Supplier found = this.supplierrepo
        						 .findById(id)
        						 .orElseThrow(SupplierNotFoundException::new);
        return this.mapToDTO(found);
    }
//	
//	//--------------------------------------------------------------
//	// RETRIEVE---> RETRIEVE SUPPLIER BY NAME
	public SupplierDTO findSupplierByName(String supplierName) 
	{
        return mapToDTO(supplierrepo.findSupplierByName(supplierName));
    }
//	
//	//--------------------------------------------------------------
////	// RETRIEVE---> RETRIEVE SUPPLIER BY ADDRESS
//	public SupplierDTO findSupplierByAddress(String supplierAddress, String supplierEmail) 
//	{
//        return mapToDTO(supplierrepo.findSupplierByAddress(supplierAddress, supplierEmail));
//    }
////
//	//--------------------------------------------------------------
	// RETRIEVE---> RETRIEVE SUPPLIER BY PHONE
	public SupplierDTO findSupplierByPhone(long supplierPhone) 
	{
        return mapToDTO(supplierrepo.findSupplierByPhone(supplierPhone));
    }
//	//--------------------------------------------------------------



//	public List<Supplier> getSupplierByName(String supplierName){ 
//		return this.booksupplierrepo.findSupplierByName(supplierName);
//	}
//	public List<Supplier> getSupplierByAddress(String supplierAddress){ 
//		return this.booksupplierrepo.findSupplierByAddress(supplierAddress);
//	}
//	public List<Supplier> getSupplierByPhone(String supplierPhone){ 
//		return this.supplierrepo.findSupplierByPhone(supplierPhone);
//	}
//	
//	public List<Supplier> getSupplierByEmail(String supplierEmail){ 
//		return this.supplierrepo.findSupplierByEmail(supplierEmail);
//	}
}



