 package com.web;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Transient;

@Entity
	public class OrderProduct {

	    @EmbeddedId
	    @JsonIgnore
	    private OrderProductPK pk;

	    @Column(nullable = false)
		private Integer quantity;

	    // default constructor

	    public OrderProduct(Order order, Product product, Integer quantity) {
	        pk = new OrderProductPK();
	        pk.setOrder(order);
	        pk.setProduct(product);
	        this.quantity = quantity;
	    }

	    @Transient
	    public Product getProduct() {
	        return this.pk.getProduct();
	    }

	    @Transient
	    public Double getTotalPrice() {
	        return getProduct().getPrice() * getQuantity();
	    }

		public OrderProductPK getPk() {
			return pk;
		}

		public void setPk(OrderProductPK pk) {
			this.pk = pk;
		}

		public Integer getQuantity() {
			return quantity;
		}

		public void setQuantity(Integer quantity) {
			this.quantity = quantity;
		}

	    // standard getters and setters

	    // hashcode() and equals() methods
	

}
