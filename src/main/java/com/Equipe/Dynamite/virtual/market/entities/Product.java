package com.Equipe.Dynamite.virtual.market.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;

@Entity
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private int stock;
	@Column(length = 50)
	private String name;
	private String description;
	private double price;
	@ManyToOne(optional = false,cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Categorie categorie;
	@Lob
	private Byte[] image;
	public Product() {
	}
	public Product(int id, int stock, String name, String description, double price, Categorie categorie,
			Byte[] image) {
		super();
		this.id = id;
		this.stock = stock;
		this.name = name;
		this.description = description;
		this.price = price;
		this.categorie = categorie;
		this.image = image;
	}
	public Product(Byte[] image) {
		super();
		this.image = image;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Categorie getCategorie() {
		return categorie;
	}

	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}

	public Byte[] getImage() {
		return image;
	}

	public void setImage(Byte[] image) {
		this.image = image;
	}

	
}
