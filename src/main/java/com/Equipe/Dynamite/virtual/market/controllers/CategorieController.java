package com.Equipe.Dynamite.virtual.market.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import  com.Equipe.Dynamite.virtual.market.dtos.CategorieDTo;
import  com.Equipe.Dynamite.virtual.market.entities.Categorie;
import  com.Equipe.Dynamite.virtual.market.repositories.CategorieRepository;


@Controller
public class CategorieController {
	
	@Autowired
    private CategorieRepository categorieRepository;

	
	public Optional <Categorie> getCategorieById(int id){
		Optional <Categorie> catOptional=this.categorieRepository.findById(id);
		return catOptional;
	}
		public String createCategorie(CategorieDTo categorieDTo) {
	Categorie categorie=new Categorie (categorieDTo.getId(),categorieDTo.getNombre());
	this.categorieRepository.save(categorie);
	return "created";
}
	    public List<CategorieDTo> readAllCategorie() {
		List<Categorie> categorieList = this.categorieRepository.findAll();
		List<CategorieDTo> categorieListDto = new ArrayList<CategorieDTo>();
		for (Categorie categorie : categorieList) {
			categorieListDto .add(new CategorieDTo(categorie));

		}
		return categorieListDto;
	}
	public Optional<CategorieDTo> findCategorieById(int id) {
		Optional<Categorie> catOptional = this.getCategorieById(id);
		if (catOptional.isPresent()) {
			return Optional.of(new CategorieDTo(catOptional.get()));
		} else {
			return Optional.empty();
		}
	}

	public boolean editCaracteristic(int id, CategorieDTo categorieDTo) {
		Optional<Categorie> catOptional = this.getCategorieById(id);
		if (!catOptional.isPresent())
			return false;
		Categorie categorie= catOptional.get();
		categorie.setNombre(categorieDTo.getNombre());
		categorie.setId(categorieDTo.getId());
		this.categorieRepository.save(categorie);
		return true;
		
	}		
	
}
