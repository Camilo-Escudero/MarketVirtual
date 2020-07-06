package com.Equipe.Dynamite.virtual.market.resources.exceptions;

public class ProductCreateError extends Exception{
	
	private static final long serialVersionUID = -7717691994704695707L;
	
	public static final String DESCRIPTION="Bad information send";
	
	public ProductCreateError() {
		super(DESCRIPTION);
	}
	
	public ProductCreateError(String message) {
		super(DESCRIPTION+""+message);
	}
	

}
