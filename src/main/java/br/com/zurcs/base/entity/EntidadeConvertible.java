package br.com.zurcs.base.entity;

public interface EntidadeConvertible<T extends Entidade<?>> {
	
	public T toEntity();
	
}
