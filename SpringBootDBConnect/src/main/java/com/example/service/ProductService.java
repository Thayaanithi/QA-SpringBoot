package com.example.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.exception.Productnotfoundexception;
import com.example.model.Product;
import com.example.productRepo.ProductRepo;

@Service
public class ProductService {
	private ProductRepo repo;
		
	public ProductService(ProductRepo repo) {
		super ();
		this.repo = repo;
	}

	public Product addProduct(Product prod) {
		return this.repo.save(prod);

	}

	public List<Product> readProduct() {
		return this.repo.findAll();

	}

	public Product updateProduct(int id, Product prod){
		Product Temp=this.repo.findById(id).orElseThrow(Productnotfoundexception::new);
		Optional<Product> myTempProduct=Optional.of(Temp);
		Product existing =myTempProduct.get();
		existing.setBrand(prod.getBrand());
		existing.setName(prod.getName());
		return this.repo.save(existing);

	}

	public boolean deleteProduct(int id) {
		this.repo.deleteById(id);
		boolean exists = this.repo.existsById(id);
		return !exists;
	}
	
	public List<Product> getProductByBrand(String brand) {
	return this.repo.findProductByBrand(brand);
	}
	 
	public List<Product> getProductByName(String name) {
	return this.repo.findProductByName (name);
	}
}
