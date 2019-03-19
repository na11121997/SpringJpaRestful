package com.cg.product.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.cg.product.beans.Product;
import com.cg.product.exceptions.ProductDetailsNotFoundException;
import com.cg.product.services.IProductService;

@Controller
public class ProductServicesController {
	@Autowired
	IProductService productServices;
	
	//to create a product
	@RequestMapping(value="/createProduct",method=RequestMethod.POST,consumes=MediaType.APPLICATION_FORM_URLENCODED_VALUE)
	public ResponseEntity<String> acceptProductDetails(@ModelAttribute Product product) {
		product=productServices.createProduct(product);
		return new ResponseEntity<>("Product details successfully added - productId :"+product.getId(),HttpStatus.OK);
	}
	//to update a product by entering its productId and inserting its data in the body under raw via PUT request in application/json
	@RequestMapping(value={"/updateProduct/{productId}"},method=RequestMethod.PUT,consumes=MediaType.APPLICATION_JSON_VALUE,headers="Accept=application/json")
	public ResponseEntity<String> updateProductDetailsPathParam(@PathVariable(value="productId")String productId,@RequestBody  Product product) throws ProductDetailsNotFoundException{
		product=productServices.updateProduct(product);
		return new ResponseEntity<>("Product details successfully UPDATED - productId :"+product.getId(),HttpStatus.OK);
	}
	//to delete a product from the database
	@RequestMapping(value="/deleteProduct/{productId}",method=RequestMethod.DELETE)
	public ResponseEntity<String> removeProductbyPath(@PathVariable(value="productId")String productId) throws ProductDetailsNotFoundException{
		productServices.deleteProduct(productId);
		return new ResponseEntity<>("Product details successfully removed ",HttpStatus.OK);
	}
	//to view all the products in the database
	@RequestMapping(value={"/viewProducts"},method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE,headers="Accept=application/json")
	public ResponseEntity<List<Product>>getAllProductDetailsPathParam() {
		return new ResponseEntity<List<Product>>(productServices.viewProducts(),HttpStatus.OK);
	}
	// to find a product using its id
	@RequestMapping(value={"/findProduct"},method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE,headers="Accept=application/json")
	public ResponseEntity<Product> getProductDetailsRequestParam(@RequestParam String productId) throws ProductDetailsNotFoundException{
		Product product=productServices.findProduct(productId);
		return new ResponseEntity<Product>(product,HttpStatus.OK);
	}
	
	
}
