package com.flm.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.flm.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{

}
