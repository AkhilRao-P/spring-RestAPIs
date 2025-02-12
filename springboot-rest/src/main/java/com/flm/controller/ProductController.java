package com.flm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.flm.dto.ProductForm;
import com.flm.entity.Product;
import com.flm.exception.ProductNotFoundException;
import com.flm.service.ProductService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class ProductController {

	@Autowired
	private ProductService productService;
	
	@PostMapping("/saveProduct")
	public Product saveProduct(@RequestBody ProductForm productForm) {
		Product product = new Product();
		product.setName(productForm.getName());
		product.setModel(productForm.getModel());
		product.setPrice(productForm.getPrice());
		product.setQuantity(productForm.getQuantity());
		return productService.saveProduct(product);
	}
	
	@PutMapping("/updateProduct")
	public Product updateProduct(@RequestBody Product product) {
		return productService.updateProduct(product);
	}
	
	@GetMapping("/getAllProducts")
	public List<Product> getAllProducts() {
		return productService.getAllProducts();
	}
	
	@DeleteMapping("/deleteProduct/{id}")
	public void deleteProduct(@PathVariable Long id) throws Exception {
		productService.deleteProduct(id);
		throw new Exception();
	}
	
	@GetMapping("/getProduct/{id}")
	public Product getProduct(@PathVariable Long id) throws ArrayIndexOutOfBoundsException {
		return productService.getProduct(id);
	}
}
