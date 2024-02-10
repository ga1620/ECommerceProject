package com.ecom.ECommerce.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ecom.ECommerce.models.Product;

@Repository
public interface ProductRepo extends CrudRepository<Product, Integer> {

}
