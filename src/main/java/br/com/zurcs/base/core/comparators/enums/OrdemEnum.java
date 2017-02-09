package br.com.zurcs.base.core.comparators.enums;

public enum OrdemEnum {
	
	CRESCENTE(1), 
	
	DECRESCENTE(-1);
	
	public int fator;
	
	private OrdemEnum(int fator) {
		this.fator = fator;
	}
	
	
}
