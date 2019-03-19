package com.cg.product.services;

import java.util.List;

import com.cg.product.beans.Product;
import com.cg.product.exceptions.ProductDetailsNotFoundException;

public interface IProductService {//Service Layer Interface 
	Product createProduct(Product product);
	Product updateProduct(Product product);
	boolean deleteProduct(String productId)throws ProductDetailsNotFoundException;
	List<Product> viewProducts();
	Product findProduct(String productId)throws ProductDetailsNotFoundException;
}
