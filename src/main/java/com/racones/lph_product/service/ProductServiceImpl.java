package com.racones.lph_product.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.racones.lph_product.entity.Product;
import com.racones.lph_product.repository.ProductRepository;

@Service
public class ProductServiceImpl implements IProductService{
	
	@Autowired
	ProductRepository productRepository;
	
	@Override
	public List<Product> getAllProducts() {
		return productRepository.findAll();
	}
	
	@Override
	public Product addProduct(Product product) {
		return productRepository.save(product);
	}
	
	@Override
	public Product updateProduct(Product product) {
		Product existingProduct = productRepository.findById(product.getProductId()).orElse(null);
		existingProduct.setTitle(product.getTitle());
		existingProduct.setDescription(product.getDescription());
		existingProduct.setCategory(product.getCategory());
		existingProduct.setPrice(product.getPrice());
		existingProduct.setImage(product.getImage());
		
		return productRepository.save(product);
	}
	
	@Override
	public Product getProductById(Integer productId) {
		Optional<Product> product = this.productRepository.findById(productId);
		return product.isPresent() ? product.get() : null;
	}
	
	@Override
	public String deleteProduct(Integer productId) {
		productRepository.deleteById(productId);
		return "Product ID: " + productId + " was deleted";
	}

}
