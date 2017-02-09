package br.com.zurcs.base.core.enums;

public enum StatusEnum {

	ATIVO(true, "Ativo"),

	INATIVO(false, "Inativo");

	private boolean chave;

	private String valor;

	private StatusEnum( final boolean chave, final String valor ) {
		this.chave = chave;
		this.valor = valor;
	}

	/**
	 * Retorna o valor do atributo <code>chave</code>
	 *
	 * @return <code>boolean</code>
	 */
	public boolean isChave() {

		return this.chave;
	}

	/**
	 * Retorna o valor do atributo <code>valor</code>
	 *
	 * @return <code>String</code>
	 */
	public String getValor() {

		return this.valor;
	}

}
