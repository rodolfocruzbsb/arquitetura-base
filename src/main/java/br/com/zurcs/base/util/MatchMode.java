package br.com.zurcs.base.util;

/**
 * <p>
 * Esta classe representa a org.hibernate.criterion.MatchMode utilizada para nao deixar no modulo dependencia direta com os MatchMode do hibernate
 * </p>
 */
public enum MatchMode {

	ANYWHERE("Contém"),

	EXACT("Igual"),

	START("Inicia"),

	END("Termina");

	private MatchMode( String label ) {
		this.label = label;
	}

	private String label;

	public String getLabel() {

		return label;
	}

}
