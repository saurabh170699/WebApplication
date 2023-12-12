package com.web;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Entity
	@Table(name = "orders")
	public class Order {

	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    @JsonFormat(pattern = "dd/MM/yyyy")
	    private LocalDate dateCreated;

	    private String status;

	    @JsonManagedReference
	    @OneToMany(mappedBy = "pk.order")
	    @Valid
	    private List<OrderProduct> orderProducts = new ArrayList<>();

	    @Transient
	    public Double getTotalOrderPrice() {
	        double sum = 0D;
	        List<OrderProduct> orderProducts = getOrderProducts();
	        for (OrderProduct op : orderProducts) {
	            sum += op.getTotalPrice();
	        }
	        return sum;
	    }

	    @Transient
	    public int getNumberOfProducts() {
	        return this.orderProducts.size();
	    }

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public LocalDate getDateCreated() {
			return dateCreated;
		}

		public void setDateCreated(LocalDate dateCreated) {
			this.dateCreated = dateCreated;
		}

		public String getStatus() {
			return status;
		}

		public void setStatus(String status) {
			this.status = status;
		}

		public List<OrderProduct> getOrderProducts() {
			return orderProducts;
		}

		public void setOrderProducts(List<OrderProduct> orderProducts) {
			this.orderProducts = orderProducts;
		}

	    // standard getters and setters
}
