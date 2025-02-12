package com.flm.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.flm.entity.Product;
import com.flm.exception.ProductNotFoundException;
import com.flm.repository.ProductRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ProductService {

	@Autowired
	private ProductRepository productRepository;
	
	@Transactional
	public Product saveProduct(Product product) {
		return productRepository.save(product);
	}
	
	@Transactional
	public Product updateProduct(Product product) {
		return productRepository.save(product);
	}
	
	@Transactional
	public void deleteProduct(Long id) {
		productRepository.deleteById(id);
	}
	
	public List<Product> getAllProducts(){
		return productRepository.findAll();
	}
	
	public Product getProduct(Long id) throws ArrayIndexOutOfBoundsException{
		Optional<Product> optProduct = productRepository.findById(id);
		if (optProduct.isPresent()) return optProduct.get();
		log.error("Product is not found!!");
		throw new ArrayIndexOutOfBoundsException("Product is not found!!");
	}
}
