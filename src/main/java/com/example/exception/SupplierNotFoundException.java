package com.example.exception;

import javax.persistence.EntityNotFoundException;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "No supplier found!")
public class SupplierNotFoundException extends EntityNotFoundException 

{
	private static final long serialVersionUID = 1L;
}