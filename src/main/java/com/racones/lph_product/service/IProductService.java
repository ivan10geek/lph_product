package com.racones.lph_product.service;

import java.util.List;

import com.racones.lph_product.entity.Product;

public interface IProductService {

	Product addProduct(Product product);

	Product updateProduct(Product product);

	List<Product> getAllProducts();

	Product getProductById(Integer productId);

	String deleteProduct(Integer productId);

}
