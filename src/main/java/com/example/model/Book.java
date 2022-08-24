package com.example.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List; 
import java.util.ArrayList;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "book")
public class Book {

	@Id
//	@GeneratedValue(strategy = GenerationType.AUTO)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	@Column(name = "book_id", nullable = false, columnDefinition = "int default 1")
	private Long id;
	
	@Column //(unique=true, length = 8)
	private String bkname;
	
	@Column
	private String bktitle;
	
	@Column
	private String bkauthor;
	
	@Column
	private String bkpublisher;
	
	@Column
	private String bkedition;
	
	@Column
	private long bkqantity;
	
	@Column
	private String bktype;
	
	@Column
	private String bksource;
	
	@Column
	private String sourcetype;
	
	@Column
	private String sourceName;
	
	@Column
	private String sourceAddress;

	@Column(unique = true)
	private long sourcePhone;
	
	@Column
	private String bkstate;
	
	@Column
	private String bkneed;
	
	@ManyToOne(targetEntity = Supplier.class)
	@JsonBackReference
	private Supplier supplier;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getBkname() {
		return bkname;
	}

	public void setBkname(String bkname) {
		this.bkname = bkname;
	}

	public String getBktitle() {
		return bktitle;
	}

	public void setBktitle(String bktitle) {
		this.bktitle = bktitle;
	}

	public String getBkauthor() {
		return bkauthor;
	}

	public void setBkauthor(String bkauthor) {
		this.bkauthor = bkauthor;
	}

	public String getBkpublisher() {
		return bkpublisher;
	}

	public void setBkpublisher(String bkpublisher) {
		this.bkpublisher = bkpublisher;
	}

	public String getBkedition() {
		return bkedition;
	}

	public void setBkedition(String bkedition) {
		this.bkedition = bkedition;
	}

	public Long getBkqantity() {
		return bkqantity;
	}

	public void setBkqantity(Long bkqantity) {
		this.bkqantity = bkqantity;
	}

	public String getBktype() {
		return bktype;
	}

	public void setBktype(String bktype) {
		this.bktype = bktype;
	}

	public String getBksource() {
		return bksource;
	}

	public void setBksource(String bksource) {
		this.bksource = bksource;
	}

	public String getSourcetype() {
		return sourcetype;
	}

	public void setSourcetype(String sourcetype) {
		this.sourcetype = sourcetype;
	}

	public String getSourceName() {
		return sourceName;
	}

	public void setSourceName(String sourceName) {
		this.sourceName = sourceName;
	}

	public String getSourceAddress() {
		return sourceAddress;
	}

	public void setSourceAddress(String sourceAddress) {
		this.sourceAddress = sourceAddress;
	}

	public Long getSourcePhone() {
		return sourcePhone;
	}

	public void setSourcePhone(Long sourcePhone) {
		this.sourcePhone = sourcePhone;
	}

	public String getBkstate() {
		return bkstate;
	}

	public void setBkstate(String bkstate) {
		this.bkstate = bkstate;
	}

	public String getBkneed() {
		return bkneed;
	}

	public void setBkneed(String bkneed) {
		this.bkneed = bkneed;
	}

	public Supplier getSupplier() {
		return supplier;
	}

	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}

	public Book(Long id, String bkname, String bktitle, String bkauthor, String bkpublisher, String bkedition,
			long bkqantity, String bktype, String bksource, String sourcetype, String sourceName, String sourceAddress,
			long sourcePhone, String bkstate, String bkneed, Supplier supplier) {
		super();
		this.id = id;
		this.bkname = bkname;
		this.bktitle = bktitle;
		this.bkauthor = bkauthor;
		this.bkpublisher = bkpublisher;
		this.bkedition = bkedition;
		this.bkqantity = bkqantity;
		this.bktype = bktype;
		this.bksource = bksource;
		this.sourcetype = sourcetype;
		this.sourceName = sourceName;
		this.sourceAddress = sourceAddress;
		this.sourcePhone = sourcePhone;
		this.bkstate = bkstate;
		this.bkneed = bkneed;
		this.supplier = supplier;
	}

	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getStatus() {
		// TODO Auto-generated method stub
		return 0;
	}

}
