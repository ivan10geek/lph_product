package com.racones.lph_product.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.racones.lph_product.entity.Product;
import com.racones.lph_product.service.IProductService;

@RestController
@RequestMapping("/home")
public class ProductController {
	
	@Autowired
	IProductService iProductService;
	
	@GetMapping(value = "/getAllProducts", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Product>> getAllProducts() {
		List<Product> products = new ArrayList<>();
		try {
			products = iProductService.getAllProducts();
		} catch (Exception e) {
			return new ResponseEntity<List<Product>>(products, HttpStatus.OK);
		}
		return new ResponseEntity<List<Product>>(products, HttpStatus.OK);
	}
	
	@PostMapping(value = "/addProduct", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Product> addProduct(@RequestBody Product product) {
		Product a = new Product();
		try {
			a = iProductService.addProduct(product);
		} catch (Exception e) {
			return new ResponseEntity<Product>(a, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<Product>(a, HttpStatus.OK);
	}
	
	@PutMapping("/updateProduct")
	public ResponseEntity<Product> updateProduct(@RequestBody Product product) {
		Product a = new Product();
		try {
			a = iProductService.updateProduct(product);
		}catch(Exception e) {
			return new ResponseEntity<Product>(a, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<Product>(a, HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	public String deletePrduct(@PathVariable("id") Integer id) {
		return iProductService.deleteProduct(id);
	}

}
