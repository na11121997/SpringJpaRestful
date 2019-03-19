package com.cg.product.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cg.product.beans.Product;
import com.cg.product.daoservices.IProductRepo;
import com.cg.product.exceptions.ProductDetailsNotFoundException;
@Component("productServices")
public class ProductServiceImpl implements IProductService{

	@Autowired
	private IProductRepo productDao;
	
	@Override
	public Product createProduct(Product product) {
		return productDao.save(product);
	}

	@Override
	public Product updateProduct(Product product) {
		return productDao.save(product);
	}

	@Override
	public boolean deleteProduct(String productId)throws ProductDetailsNotFoundException {
		productDao.delete(findProduct(productId));
		return true;
	}

	@Override
	public List<Product> viewProducts() {
		return productDao.findAll();
	}

	@Override
	public Product findProduct(String productId)throws ProductDetailsNotFoundException {
		return productDao.findById(productId).orElseThrow
				(()-> new ProductDetailsNotFoundException("Product details not found"+productId));
	}

}
