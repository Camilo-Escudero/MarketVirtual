package com.Equipe.Dynamite.virtual.market.dtos;
import  com.Equipe.Dynamite.virtual.market.entities.Categorie;

public class CategorieDTo {
	private int id;
	private String nombre;
	
	public CategorieDTo(int id, String nombre) {
		super();
		this.id = id;
		this.nombre = nombre;
	}
    
	public CategorieDTo(Categorie categorie ) {
		this.id = categorie.getId();
		this.nombre = categorie.getNombre();
		
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
	
	
	

}
