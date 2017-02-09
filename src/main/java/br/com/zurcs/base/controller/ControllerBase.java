package br.com.zurcs.base.controller;

import java.io.Serializable;

public interface ControllerBase extends Serializable {
	
	void showAtencao(String mensagemAtencao);

	void showInformacao(String mensagemInformacao);

	void showErro(String mensagemErro);

	void showSucesso(String mensagemSucesso);

	void showExcecao(Exception e);

	boolean hasMensagemAtencao();

	void clearMensagensAtencao();

	boolean hasMensagemSucesso();

	void clearMensagensSucesso();
	
	/**
	 * Adiciona atributo na session
	 * */
	public void addAtributeSession(String name, Object obj);
	
	/**
	 * Remove atributo da session
	 * */
	public void removeAttributeSession(String name);
	
	/**
	 * Recupera atributo da session
	 * */
	public <T extends Object> T getAttributeSession(String name);
	
	/**
	 * Adiciona atributo no request
	 * */
	public void addAtributeRequest(String name, Object obj) ;
		
	/**
	 * Remove atributo do request
	 * */
	public void removeAttributeRequest(String name);
	
	/**
	 * Recupera atributo do request
	 * */
	public <T extends Object> T getAttributeRequest(String name);
	
	/**
	 * Recupera parametro do request
	 * */
	public <T extends Object> T getParameterRequest(String name);
	
	/**
	 * Recupera parametros do request
	 * */
	public String[] getParameterValues(String nomeParametro);
}
