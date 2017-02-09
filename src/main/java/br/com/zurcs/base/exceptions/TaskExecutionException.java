package br.com.zurcs.base.exceptions;

import java.io.Serializable;

public class TaskExecutionException extends InfraException implements Serializable {

	/** Atributo serialVersionUID. */
	private static final long serialVersionUID = -1921437658305134308L;

	public TaskExecutionException() {
		this.severity = SeverityException.ERROR;
	}

	public TaskExecutionException( String messagekey, String message, Throwable causa ) {
		super(messagekey, message, causa);
	}

	public TaskExecutionException( String messagekey, String message ) {
		super(messagekey, message);
	}

	public TaskExecutionException( String messagekey, String message, SeverityException severity ) {
		super(messagekey, message, severity);
	}

	public TaskExecutionException( Throwable causa ) {
		super(causa);
	}
}
