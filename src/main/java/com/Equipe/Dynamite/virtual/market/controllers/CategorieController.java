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
	
	public void  createCategorie(CategorieDTo categorieDto) {
		Categorie categorie = new Categorie(categorieDto.getId(),categorieDto.getNombre());
		this.categorieRepository.save(categorie);
		
	}
	
	public List<CategorieDTo> readAllProducts(){
		List<Categorie> categorieList= this.categorieRepository.findAll();
		List<CategorieDTo> categoriesDTo=new ArrayList<CategorieDTo>() ;
		for (Categorie categorie: categorieList) {
			categoriesDTo.add(new CategorieDTo(categorie));
		}
		return categoriesDTo;
	}
	
	public Optional<CategorieDTo> findCategorieById(int id){
		Optional<Categorie> catOptional= this.categorieRepository.findById(id);
		if(catOptional.isPresent()) {
			return Optional.of(new CategorieDTo(catOptional.get()));
		}else {
			return Optional.empty();
		}
	}
}
