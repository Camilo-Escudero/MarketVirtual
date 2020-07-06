package com.Equipe.Dynamite.virtual.market.resources;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import com.Equipe.Dynamite.virtual.market.controllers.CategorieController;
import com.Equipe.Dynamite.virtual.market.dtos.CategorieDTo;
import com.Equipe.Dynamite.virtual.market.resources.exceptions.CategorieCreateError;

@RequestMapping(CategorieResource.CATEGORIE)
public class CategorieResource {
	
	public static final String CATEGORIE = "/categories";
	
	@Autowired
	private CategorieController categorieController;
	
	@PostMapping
	public void createCategorie(@Valid @RequestBody CategorieDTo categorieDTo )throws CategorieCreateError{
		this.categorieController.createCategorie(categorieDTo);
		
	}
	
}
