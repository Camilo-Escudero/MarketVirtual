package com.Equipe.Dynamite.virtual.market.resources.exceptions;

public class CategorieCreateError extends Exception {
	
	private static final long serialVersionUID = -7717691994704695707L;
	public static final String DESCRIPTION="Bad information send";
	
	public CategorieCreateError() {
		super (DESCRIPTION);
		
	}
	public CategorieCreateError(String message) {
		super(DESCRIPTION+""+message);
	}
	

}
