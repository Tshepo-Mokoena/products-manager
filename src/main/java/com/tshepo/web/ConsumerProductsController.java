package com.tshepo.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.tshepo.persistence.Product;
import com.tshepo.service.IConsumerProductsService;

@RestController
@RequestMapping("/api/consumer/")
public class ConsumerProductsController {
	
	private IConsumerProductsService consumerProductsService;
	
	@Autowired
	private ConsumerProductsController(IConsumerProductsService consumerProductsService) 
	{
		this.consumerProductsService = consumerProductsService; 
	}
	
	@PostMapping(value = "products", consumes = 
		{ 
				MediaType.MULTIPART_FORM_DATA_VALUE 
		})
	public ResponseEntity<?> createNewProduct(@RequestPart Product product, @RequestPart MultipartFile image) 
	{		
		return new ResponseEntity<>(consumerProductsService.createNewProduct(product, image), HttpStatus.CREATED);
	}
			
	@GetMapping("products/{productId}")
	public ResponseEntity<?> getByProductId(@PathVariable String productId) 
	{		
		return new ResponseEntity<>(consumerProductsService.getByProductId(productId), HttpStatus.OK);
	}
	
	@GetMapping("products")
	public ResponseEntity<List<Product>> getProducts(@PathVariable String productId) 
	{		
		return new ResponseEntity<>(consumerProductsService.getProducts(), HttpStatus.OK);
	}
	//Update Product
	//Product Search
	//Find Products BY NAME;
	//Find Active Products Search;
	
	//TODO Category End-Points
	
	//TODO Product Categories End-Points

}
