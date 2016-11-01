package com.fiapbank.objects;

public enum TipoConta {
	CC("Conta Corrente"), CP("Conta Poupança");
	
	private String value;
	
	TipoConta(String value){
		this.value = value;
	}
	
	public String getValue(){
		return this.value;
	}

}
