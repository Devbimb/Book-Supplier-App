package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.dto.SupplierDTO;
import com.example.model.Supplier;
import com.example.repository.SupplierRepo;
import com.example.service.SupplierService;

@RestController
@RequestMapping //(value = "/bks")
public class SupplierController {

	@Autowired
	private SupplierService supplierservice;

	@Autowired
	private SupplierRepo supplierrepo;

	private SupplierController(SupplierService supplierservice, SupplierRepo supplierrepo) {
		super();
		this.supplierservice = supplierservice;
		this.supplierrepo = supplierrepo;
	}

	// ---------------------C R U D ----I N----P O S T M A N---------------------
	// c---> CREATE SUPPLIER
	@PostMapping("/Supplier/createsupplier")
	@ResponseStatus(code = HttpStatus.CREATED)

	public SupplierDTO createsupplier(@RequestBody Supplier bks1) 
	{
		return this.supplierservice.createSupplier(bks1);
	}
	// --------------------------------------------------------------

	// R---> READ ALL SUPPLIER
	@GetMapping("/Supplier/readsupplier")
	public List<SupplierDTO> readsupplier() 
	{
		return this.supplierservice.readSupplier();
	}

	// --------------------------------------------------------------

	// U---> UPDATE SUPPLIER
	@PutMapping("/Supplier/updatesupplier/{id}")
	public SupplierDTO updatesupplier(@PathVariable Long id, @RequestBody Supplier bks2) 
	{
		return this.supplierservice.updateSupplier(id, bks2);
	}
	// --------------------------------------------------------------

	// D---> DELETE SUPPLIER
	@DeleteMapping("/Supplier/deletesupplier/{id}")
	public void deletesupplier(@PathVariable Long id) 
	{
		this.supplierservice.deleteSupplier(id);
	}

//	//--------------------------------------------------------------
	// LOGIN---> LOGIN SUPPLIER/PASS FLAG
	@GetMapping("Supplier/login/{userName}/{password}")
	public int login(@PathVariable String userName, @PathVariable String password) 
	{
		return this.supplierservice.checkCredentials(userName, password);
	}
	// --------------------------------------------------------------
	// RETRIEVE---> RETRIEVE SUPPLIER BY ID
	@GetMapping("/Supplier/readsupplierById/{id}")
	public SupplierDTO readById(@PathVariable Long id) 
	{
		return this.supplierservice.findById(id);
	}

//	//--------------------------------------------------------------
	// RETRIEVE---> RETRIEVE SUPPLIER BY NAME
	@GetMapping("/Supplier/readsupplierByName/{supplierName}")
	public SupplierDTO readByName(@PathVariable String supplierName) 
	{
		return this.supplierservice.findSupplierByName(supplierName);
	}

////	//--------------------------------------------------------------
//	// RETRIEVE---> RETRIEVE SUPPLIER BY ADDRESS
//	@GetMapping("/Supplier/readsupplier/{supplierAddress, SupplierEmail}")
//	public SupplierDTO readByAddress(@PathVariable String supplierAddress, @PathVariable String supplierEmail) 
//	{
//		return this.supplierservice.findSupplierByAddress(supplierAddress, supplierEmail);
//	}
////			
	// --------------------------------------------------------------
	// RETRIEVE---> RETRIEVE SUPPLIER BY PHONE
	@GetMapping("/Supplier/readsupplierByPhone/{supplierPhone}")
	public SupplierDTO readByPhone(@PathVariable long supplierPhone) 
	{
		return this.supplierservice.findSupplierByPhone(supplierPhone);
	}

	//--------------------------------------------------------------
	@GetMapping("/Supplier/readOne")
	public void readOne() {
	}
}
