package com.Equipe.Dynamite.virtual.market.resources.exceptions;

public class ProductDontFound extends Exception {
	
private static final long serialVersionUID = -7717691994704695707L;
	
	public static final String DESCRIPTION="Product don't found";
	
	public ProductDontFound() {
		super(DESCRIPTION);
	}
	
	public ProductDontFound(String message ) {
		super(DESCRIPTION + " " +message);
	}

}
