package com.example.demo.rest;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.example.model.Product;
import com.example.productRepo.ProductRepo;
import com.example.service.ProductService;

@SpringBootTest
public class ProductServiceUnitTest {
@Autowired
private ProductService service;
@MockBean
private ProductRepo repo;
@Test
void testCreate() {
	final Product TEST_PRODUCT = new Product(106,"Camera", "Nikon");
	final Product TEST_SAVED_PRODUCT= new Product(106, "Camera", "Nikon");
	

//WHEN
	Mockito.when(this.repo.save(TEST_PRODUCT)).thenReturn(TEST_SAVED_PRODUCT);
	//THEN
	Assertions.assertThat(this.service.addProduct(TEST_PRODUCT)).isEqualTo(TEST_SAVED_PRODUCT);
	//verify that our repo was accessed exactly once
	Mockito.verify(this.repo, Mockito.times(1)).save(TEST_PRODUCT);

}


} 