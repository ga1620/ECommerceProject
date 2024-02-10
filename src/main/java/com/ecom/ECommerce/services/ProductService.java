package com.ecom.ECommerce.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ecom.ECommerce.interfaces.ProductInterface;
import com.ecom.ECommerce.models.Product;
import com.ecom.ECommerce.models.ProductDTO;
import com.ecom.ECommerce.repository.ProductRepo;

@Service
public class ProductService implements ProductInterface{

	@Autowired
	ProductRepo productRepo;

	public ResponseEntity<Object> createProduct(ProductDTO product) {
		Product resProduct = null;
		try {
			if (product.getName() == null || product.getName().isEmpty())
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Name must not be null or empty");
			if (product.getDescription() == null || product.getDescription().isEmpty())
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Description must not be null or empty");
			if (product.getPrice() == null)
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Price must not be null or empty");
			if (product.getQuntyAvailable() == null)
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Quntity must not be null or empty");

			Product prod = new Product();
			prod.setDescription(product.getDescription());
			prod.setName(product.getName());
			prod.setPrice(product.getPrice());
			prod.setQuntyAvailable(product.getQuntyAvailable());

			resProduct = productRepo.save(prod);
		} catch (Exception e) {
			// TODO: handle exception
			return ResponseEntity.status(HttpStatus.CONFLICT)
					.body("Exception while Creating Product " + e.getMessage());
		}

		return ResponseEntity.status(HttpStatus.OK).body(resProduct);

	}

	public ResponseEntity<Object> getProduct(int id) {
		Product resProduct;
		try {
			Optional<Product> product = productRepo.findById(id);
			if (product.isEmpty())
				return ResponseEntity.status(HttpStatus.OK).body("No Product found for Id " + id);
			resProduct = product.get();

		} catch (Exception e) {
			// TODO: handle exception
			return ResponseEntity.status(HttpStatus.CONFLICT).body("Exception while Getting Product " + e.getMessage());
		}

		return ResponseEntity.status(HttpStatus.OK).body(resProduct);
	}

	public ResponseEntity<Object> updateProduct(ProductDTO product) {
		try {
			Optional<Product> productRes = productRepo.findById(product.getId());
			if (productRes.isEmpty())
				return ResponseEntity.status(HttpStatus.OK).body("No Product found");
			Product updateProduct = productRes.get();
			updateProduct.setDescription(product.getDescription());
			updateProduct.setName(product.getName());
			updateProduct.setPrice(product.getPrice());
			updateProduct.setQuntyAvailable(product.getQuntyAvailable());

			productRepo.save(updateProduct);
		} catch (Exception e) {
			// TODO: handle exception
			return ResponseEntity.status(HttpStatus.CONFLICT).body("Exception while Update Product " + e.getMessage());
		}

		return ResponseEntity.status(HttpStatus.OK).body("Product update Sucessfully");
	}

	public ResponseEntity<Object> deleteProduct(int id) {
		try {
			Optional<Product> productRes = productRepo.findById(id);
			if (productRes.isEmpty())
				return ResponseEntity.status(HttpStatus.OK).body("No Product found");

			productRepo.deleteById(id);
		} catch (Exception e) {
			// TODO: handle exception
			return ResponseEntity.status(HttpStatus.CONFLICT).body("Exception while Update Product " + e.getMessage());
		}

		return ResponseEntity.status(HttpStatus.OK).body("Product delete Sucessfully");
	}
	
	public ResponseEntity<Object> addDiscountOrTaxOnProduct(int id,String cag,int percentage)
	{
		String res="";
		try {
			Optional<Product> productRes = productRepo.findById(id);
			if (productRes.isEmpty())
				return ResponseEntity.status(HttpStatus.OK).body("No Product found");
			
			Product product = productRes.get();
			int price = product.getPrice();
			if(cag.toUpperCase().equals("TAX"))
			{
				int taxvalue = price * percentage /(100+percentage);
				price = price + taxvalue;
				product.setPrice(price);
				productRepo.save(product);
				res = "Tax of "+percentage+"% added and current amount is "+ price;
			}
			else
			{
				int disvalue = price * percentage /100;
				price = price - disvalue;
				product.setPrice(price);
				productRepo.save(product);
				res = "Discount of "+percentage+"% added and current amount is"+ price;
			}
		}catch (Exception e) {
			// TODO: handle exception
			return ResponseEntity.status(HttpStatus.CONFLICT).body("Exception while Adding Tax/Percentage on Product " + e.getMessage());
		}
		
		return ResponseEntity.status(HttpStatus.OK).body("Sucess for "+res);
	}

}
