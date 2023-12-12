package com.web;

import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class ProductServiceImpl {

	 @Override
	    public Iterable<Product> getAllProducts() {
	        return productRepository.findAll();
	    }

	    @Override
	    public Product getProduct(long id) {
	        return productRepository
	          .findById(id)
	          .orElseThrow(() -> new ResourceNotFoundException("Product not found"));
	    }

	    @Override
	    public Product save(Product product) {
	        return productRepository.save(product);
	    }
}
