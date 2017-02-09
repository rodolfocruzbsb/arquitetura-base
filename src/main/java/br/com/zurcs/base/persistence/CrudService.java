package br.com.zurcs.base.persistence;

import java.io.Serializable;
import java.util.List;

import br.com.zurcs.base.util.MatchMode;
import br.com.zurcs.base.util.QueryParameter;

public interface CrudService<T, ID extends Serializable> {

	/**
	 * */
	void validate(T entity);

	/**
	 * */
	boolean jaExiste(T entity);

	/**
	 * */
	T salvar(T entity);

	/**
	 * */
	void salvar(List<T> entitys);

	/**
	 * */
	void prepare(T entity);

	/**
	 * */
	T selecionarPorId(ID id);

	/**
	 * */
	T selecionarPorIdFull(ID id);

	List<T> selecionarPorId(List<ID> ids);

	/**
	 * */
	void excluir(ID id);

	void excluirComVerificacaoDeConstraints(ID id);

	/**
	 * */
	List<T> buscarTodos(String... ordenarPor);

	/**
	 * */
	Long buscarAgregacao(String nomeQueryNomeada, QueryParameter parameters);

	/**
	 * */
	List<T> buscarPorQueryNomeada(String nomeQueryNomeada, QueryParameter parameters);

	List<T> buscarPorQueryNomeada(String nomeQueryNomeada);

	/**
	 * */
	<O> O buscarPorGenericQueryNomeada(String nomeQueryNomeada, QueryParameter parameters);

	<O> O buscarPorGenericQueryNomeada(final String nomeQueryNomeada);

	/**
	 * */
	<Obj extends Object> Obj buscarUniqPorGenericQueryNomeada(String nomeQueryNomeada, QueryParameter parameters);

	/**
	 * */
	List<T> buscarPorExemplo(T exemplo, MatchMode matchMode, boolean ignoreCase, boolean filtraEntidadeAninhada, String... ordenarPor);

	/**
	 * */
	List<T> buscarPorExemplo(T exemplo, MatchMode matchMode, boolean ignoreCase, String... ordenarPor);

	/**
	 * */
	List<T> buscarPorExemplo(T exemplo, boolean filtraEntidadeAninhada, String... ordenarPor);

	/**
	 * */
	List<T> buscarPorExemplo(T exemplo, String... ordenarPor);

	/**
	 * */
	void executaOperacaoEmLote(String nomeOperacao, QueryParameter parameters);

	/**
	 * */
	void checkNullOrEmptyParameters(Object... parameters);

	Long count();

	default Long callSequence(String sequenceName) {

		return 0l;
	}
}
