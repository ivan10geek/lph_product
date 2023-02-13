package com.racones.lph_product.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.racones.lph_product.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Integer>{

}
