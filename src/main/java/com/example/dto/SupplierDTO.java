package com.example.dto;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.example.model.Book;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data

public class SupplierDTO {

	@Id
//		@GeneratedValue(strategy = GenerationType.AUTO)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(unique = true)
	@NotNull
	@Size(min = 2, max = 20, message = "Username should be betweeen two and twenty characters.")
	private String userName;

//		@NotNull
//		@Column (nullable = false)
	@Size(min = 3, max = 15, message = "Password should not be less than three and greater than 15.")
	private String password;

	@Column(unique = true)
	private String supplierEmail;

	@Column
	private String supplierName;

	@Column
	private String supplierAddress;

	@Column(unique = true)
	private long supplierPhone;

	@Min(value = 0)
	@Max(value = 2)
	private int access; // 0 = admin, 1 = operator, 2 = customer

	@OneToMany(mappedBy = "supplier", fetch = FetchType.EAGER)
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JsonIgnore
	private List<Book> book = new ArrayList<>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSupplierEmail() {
		return supplierEmail;
	}

	public void setSupplierEmail(String supplierEmail) {
		this.supplierEmail = supplierEmail;
	}

	public String getSupplierName() {
		return supplierName;
	}

	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}

	public String getSupplierAddress() {
		return supplierAddress;
	}

	public void setSupplierAddress(String supplierAddress) {
		this.supplierAddress = supplierAddress;
	}

	public long getSupplierPhone() {
		return supplierPhone;
	}

	public void setSupplierPhone(long supplierPhone) {
		this.supplierPhone = supplierPhone;
	}

	public int getAccess() {
		return access;
	}

	public void setAccess(int access) {
		this.access = access;
	}

	public List<Book> getBook() {
		return book;
	}

	public void setBook(List<Book> book) {
		this.book = book;
	}

}
