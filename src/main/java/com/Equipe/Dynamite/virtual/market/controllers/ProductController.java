package com.Equipe.Dynamite.virtual.market.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;


import com.Equipe.Dynamite.virtual.market.dtos.ProductDto;
import com.Equipe.Dynamite.virtual.market.entities.Product;
import com.Equipe.Dynamite.virtual.market.repositories.ProductRepository;


@Controller
public class ProductController {
	
	@Autowired
	private ProductRepository productRepository;
	
	public Optional<Product> getProductById(int id) {
		Optional<Product> prodOptional = this.productRepository.findById(id);
		return prodOptional;
	}
	
	public void createProduct(ProductDto productDto) {
		Product product = new Product(productDto.getId(), productDto.getStock(), productDto.getName(), productDto.getDescription(), productDto.getPrice(), null, productDto.getImage());
		this.productRepository.save(product);		
	}
	
	public List<ProductDto> readAllProducts(){
		List<Product> productList= this.productRepository.findAll();
		List<ProductDto> productsDto= new ArrayList<ProductDto>();
		for(Product product: productList) {
			productsDto.add(new ProductDto(product));
		}
		return productsDto;
		
	}
	
	public Optional<ProductDto> findProductById(int id){
		Optional<Product> prodOptional= this.getProductById(id);
		if (prodOptional.isPresent()) {
			return Optional.of(new ProductDto(prodOptional.get()));
		} else {
			return Optional.empty();
		}
	}
	
	public boolean editProduct(int id, ProductDto productDto) {
		Optional<Product> prodOptional= this.getProductById(id);
		if(!prodOptional.isPresent()) return false;
		Product product= prodOptional.get();
		product.setDescription(productDto.getDescription());
		product.setName(productDto.getName());
		product.setPrice(product.getPrice());
		product.setStock(productDto.getStock());
		product.setImage(productDto.getImage());
		this.productRepository.save(product);
		return true;
	}

}
