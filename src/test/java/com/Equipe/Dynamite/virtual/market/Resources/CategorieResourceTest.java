package com.Equipe.Dynamite.virtual.market.Resources;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.springframework.beans.factory.annotation.Autowired;
import com.Equipe.Dynamite.virtual.market.dtos.CategorieDTo;
import com.Equipe.Dynamite.virtual.market.dtos.ProductDto;
import com.Equipe.Dynamite.virtual.market.resources.CategorieResource;

public class CategorieResourceTest {
	
	
	@SuppressWarnings("deprecation")
	@Rule
	public ExpectedException thrown = ExpectedException.none();

	@Autowired
	private RestService restService;
	private ProductDto productDto;
	private CategorieDTo categorieDTo;
	
	@Before
	public void Before() {
		this.productDto = new ProductDto(1, 5, "backpac", "wallet made from lether", 5.50, null, null);
		this.categorieDTo = new CategorieDTo(1, "color", this.productDto);
	
	}
	@Test
	public void createCategorie() {
		restService.restBuilder().path(CategorieResource.CATEGORIE).body(categorieDTo).post().build();
	}
	

	@Test
	public void readAllCategorieTest() {
		String json = restService.restBuilder(new RestBuilder<String>()).clazz(String.class)
				.path(CategorieResource.CATEGORIE).get().build();

		System.out.println("-->" + json);
	}

	@Test
	public void readCategorieByIdTest() {
		String json = restService.restBuilder(new RestBuilder<String>()).clazz(String.class)
				.path(CategorieResource.CATEGORIE).path(CategorieResource.ID).expand(1).get().build();

		System.out.println("-->" + json);
	}

	@Test
	public void editCategorieTest() {
		this.categorieDTo.setNombre("Ropa");
		this.productDto.setId(15);
		restService.restBuilder().path(CategorieResource.CATEGORIE)
		.path(CategorieResource.ID).expand(1).body(categorieDTo).put().build();

		
	}

	
	
	
	
	
	
	

}
