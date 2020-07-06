package com.Equipe.Dynamite.virtual.market.resources;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Equipe.Dynamite.virtual.market.controllers.ProductController;
import com.Equipe.Dynamite.virtual.market.dtos.ProductDto;
import com.Equipe.Dynamite.virtual.market.resources.exceptions.ProductCreateError;

@RestController
@RequestMapping(ProductResource.PRODUCT)
public class ProductResource {
	
	public static final String PRODUCT = "/products";



	public static final String ID = null;

	
	
	@Autowired
	private ProductController productController;
	
	@PostMapping
	public void createProduct(@Valid @RequestBody ProductDto productDto )throws ProductCreateError{
		this.productController.createProduct(productDto);
		
	}

}
