package com.ecom.ECommerce.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecom.ECommerce.interfaces.ProductInterface;
import com.ecom.ECommerce.models.ProductDTO;

@RestController
@RequestMapping("product")
public class ProductController {

	@Autowired
	ProductInterface productService;

	@PostMapping("/create")
	public ResponseEntity<Object> createProduct(@RequestBody ProductDTO product) {
		return productService.createProduct(product);
	}

	@GetMapping("/getById/{id}")
	public ResponseEntity<Object> getProduct(@PathVariable int id) {
		return productService.getProduct(id);
	}

	@PostMapping("/update")
	public ResponseEntity<Object> updateProduct(@RequestBody ProductDTO product) {
		return productService.updateProduct(product);
	}

	@PostMapping("/delete/{id}")
	public ResponseEntity<Object> updateProduct(@PathVariable int id) {
		return productService.deleteProduct(id);
	}

	@PostMapping("/addTaxDiscount/{id}/{cat}/{value}")
	public ResponseEntity<Object> addDiscountOrTaxOnProduct(@PathVariable int id, @PathVariable String cat,
			@PathVariable int value) {
		return productService.addDiscountOrTaxOnProduct(id, cat, value);
	}
}
