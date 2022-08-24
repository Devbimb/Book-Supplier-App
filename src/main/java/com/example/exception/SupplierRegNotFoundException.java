package com.example.exception;

import java.sql.SQLException;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.CONFLICT, reason = "supplierEmail already in use.")
	public class SupplierRegNotFoundException extends SQLException 
	{
		private static final long serialVersionUID = 1L;
	}
	
	
	
//		public BookSupplierNotFoundException () {}
//		public BookSupplierNotFoundException(String msg) {
//			super(msg);
//		}


















































//POSTing a duplicate email is a conflict with "the current state of the resource" as a collection. Add link to resolve the issue