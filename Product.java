package com.web;

import org.antlr.v4.runtime.misc.NotNull;

import jakarta.persistence.Basic;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
	public class Product {

	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	   
	    @Basic(optional = false)
	    private String name;

	    private Double price;

	    private String pictureUrl;

	    // all arguments contructor 
	    // standard getters and setters
 }


