package com.web.entities;

import java.net.http.HttpHeaders;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.web.Order;

public class Responce {
	


	@PostMapping
		public ResponseEntity<Order> create(@RequestBody OrderForm form) {
		    List<OrderProductDto> formDtos = form.getProductOrders();
		    validateProductsExistence(formDtos);
		    // create order logic
		    // populate order with products

		    order.setOrderProducts(orderProducts);
		    this.orderService.update(order);

		    String uri = ServletUriComponentsBuilder
		      .fromCurrentServletMapping()
		      .path("/orders/{id}")
		      .buildAndExpand(order.getId())
		      .toString();
		    HttpHeaders headers = new HttpHeaders();
		    headers.add("Location", uri);

		    return new ResponseEntity<>(order, headers, HttpStatus.CREATED);
		}
	
	}


