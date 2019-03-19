package com.cg.product.daoservices;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.product.beans.Product;
//Dao Layer-extends JpaRepository and hence has all of its DAO implementations
public interface IProductRepo extends JpaRepository<Product, String>{

}
