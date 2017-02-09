package br.com.zurcs.base.entity;

import java.io.Serializable;

public interface Entidade<ID extends Serializable> extends Serializable {

	ID getId();

	void setId(ID id);

	default boolean hasChanged(Object obj) {

		return false;
	}

}
