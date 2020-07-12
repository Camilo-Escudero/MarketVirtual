package com.Equipe.Dynamite.virtual.market.dtos;
import  com.Equipe.Dynamite.virtual.market.entities.Categorie;

public class CategorieDTo {
	private int id;
	private String nombre;
	private ProductDto product;
	
	public CategorieDTo(int id, String nombre,ProductDto product) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.product = product;
	}
    
	public CategorieDTo(Categorie categorie ) {
		this.id = categorie.getId();
		this.nombre = categorie.getNombre();
		this.product = new ProductDto(categorie.getProduct());
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public ProductDto getProduct() {
		return product;
	}

	public void setProduct(ProductDto product) {
		this.product = product;
	}
	
	
	
	

}
