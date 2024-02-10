package com.ecom.ECommerce.interfaces;

import org.springframework.http.ResponseEntity;

import com.ecom.ECommerce.models.ProductDTO;

public interface ProductInterface {

	public ResponseEntity<Object> createProduct(ProductDTO product);
	public ResponseEntity<Object> getProduct(int id);
	public ResponseEntity<Object> updateProduct(ProductDTO product);
	public ResponseEntity<Object> deleteProduct(int id);
	public ResponseEntity<Object> addDiscountOrTaxOnProduct(int id,String cag,int percentage);
}
