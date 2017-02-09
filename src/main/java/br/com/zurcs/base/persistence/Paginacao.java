package br.com.zurcs.base.persistence;

import java.io.Serializable;

/**
 * Objeto representativo de uma paginação de consulta na JPA
 *
 */
public class Paginacao implements Serializable {

	private static final long serialVersionUID = -7849682623715247020L;
	
	private int firstResult;
	private int maxResults;

	public int getFirstResult() {
		return firstResult;
	}

	public void setFirstResult(int firstResult) {
		this.firstResult = firstResult;
	}

	public int getMaxResults() {
		return maxResults;
	}

	public void setMaxResults(int maxResults) {
		this.maxResults = maxResults;
	}

}
