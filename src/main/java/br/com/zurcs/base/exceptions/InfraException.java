package br.com.zurcs.base.exceptions;

import java.io.Serializable;

public class InfraException extends RuntimeException implements Serializable {

	private static final long serialVersionUID = 2803020076834794246L;

	protected String messagekey;

	protected SeverityException severity;

	public InfraException() {
		this.severity = SeverityException.ERROR;
	}

	public InfraException( String messagekey, String message, Throwable causa ) {
		super(message, causa);
		this.messagekey = messagekey;
		this.severity = SeverityException.ERROR;
	}

	public InfraException( String messagekey, String message ) {
		super(message);
		this.messagekey = messagekey;
		this.severity = SeverityException.ERROR;
	}

	public InfraException( String messagekey, String message, SeverityException severity ) {
		super(message);
		this.messagekey = messagekey;
		this.severity = severity;
	}

	public InfraException( Throwable causa ) {
		super(causa);
		this.severity = SeverityException.ERROR;
	}

	public SeverityException getSeveridadeException() {

		return severity;
	}

	public String getMessagekey() {

		return messagekey;
	}
}
