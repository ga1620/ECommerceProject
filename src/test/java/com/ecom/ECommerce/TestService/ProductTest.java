package com.ecom.ECommerce.TestService;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit4.SpringRunner;

import com.ecom.ECommerce.models.Product;
import com.ecom.ECommerce.models.ProductDTO;
import com.ecom.ECommerce.repository.ProductRepo;
import com.ecom.ECommerce.services.ProductService;

@RunWith(SpringRunner.class)
public class ProductTest {

	@InjectMocks
	ProductService productService;

	@Mock
	ProductRepo productRepo;

	@BeforeEach
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void createProductTest1() {
		ProductDTO product = new ProductDTO("", "xyz", 12, 20);
		when(productRepo.save(Mockito.any())).thenReturn(product);
		assertEquals(productService.createProduct(product).getStatusCode(), HttpStatus.BAD_REQUEST);

	}

	@Test
	public void createProductTest2() {
		ProductDTO product = new ProductDTO("Gaurav", "xyz", 12, 20);
		when(productRepo.save(Mockito.any())).thenReturn(product);
		assertEquals(productService.createProduct(product).getStatusCode(), HttpStatus.CONFLICT);

	}

	@Test
	public void getProductTest() {
		Product pro = new Product();
		pro.setId(1);
		pro.setDescription("xyz");
		pro.setName("xyz");
		pro.setPrice(123);
		pro.setQuntyAvailable(100);

		when(productRepo.findById(Mockito.anyInt())).thenReturn(Optional.of(pro));

		assertEquals(productService.getProduct(Mockito.anyInt()).getStatusCode(), HttpStatus.OK);

	}
	
	@Test
	public void updateProductTest()
	{
		ProductDTO product = new ProductDTO(1,"Gaurav", "xyz", 12, 20);
		Product pro = new Product();
		pro.setId(1);
		pro.setDescription("xyz");
		pro.setName("xyz");
		pro.setPrice(123);
		pro.setQuntyAvailable(100);
		when(productRepo.save(Mockito.any())).thenReturn(pro);
		when(productRepo.findById(Mockito.anyInt())).thenReturn(Optional.of(pro));
		assertEquals(productService.updateProduct(product).getStatusCode(), HttpStatus.OK);
	}
	
	@Test
	public void deleteProduct()
	{
		Product pro = new Product();
		pro.setId(1);
		pro.setDescription("xyz");
		pro.setName("xyz");
		pro.setPrice(123);
		pro.setQuntyAvailable(100);
		when(productRepo.save(Mockito.any())).thenReturn(pro);
		when(productRepo.findById(Mockito.anyInt())).thenReturn(Optional.of(pro));
		
		assertEquals(productService.deleteProduct(Mockito.anyInt()).getStatusCode(), HttpStatus.OK);
	}
	
	@Test
	public void addDiscountOrTaxOnProduct()
	{
		Product pro = new Product();
		pro.setId(1);
		pro.setDescription("xyz");
		pro.setName("xyz");
		pro.setPrice(123);
		pro.setQuntyAvailable(100);
		when(productRepo.save(Mockito.any())).thenReturn(pro);
		when(productRepo.findById(Mockito.anyInt())).thenReturn(Optional.of(pro));
		
		assertEquals(productService.addDiscountOrTaxOnProduct(Mockito.anyInt(),Mockito.anyString(),Mockito.anyInt()).getStatusCode(), HttpStatus.CONFLICT);
	}
}
