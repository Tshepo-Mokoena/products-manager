package com.tshepo.persistence;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
@Entity
@Table(name = "product")
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "product_id", nullable = false, updatable = false, unique = true)
	private String productId;
	
	@NotBlank(message = "name should be atleast 2 characters")
	@Size(min = 2, max = 50, message = "name should be atleast 2 characters")
	@Column(name = "name", nullable = false, updatable = true, length = 50)
	private String name;
	
	@NotBlank(message = "description should be atleast 2 characters")
	@Size(min = 2, max = 1000, message = "description should be atleast 2 characters")
	@Column(nullable = false, updatable = true, columnDefinition = "text" ,length = 1000)
	private String description;
	
	@Column(nullable = false, name = "quantity")
	private Integer qty;
	
	@Column(nullable = false)
	private BigDecimal price;
	
	@Column(name = "product_image_url", nullable = true)
	private String productImageURL;
	
	@ManyToMany
    @JoinTable(name = "product_categories", joinColumns = @JoinColumn(name = "product_id"), inverseJoinColumns = @JoinColumn(name = "category_id"))
    private List<Category> categories;
	
	@Column(name = "active", nullable = false)
	private boolean active = false;
	
	@Column(name = "created_at", nullable = false, updatable = false)
	private LocalDateTime createdAt;

}