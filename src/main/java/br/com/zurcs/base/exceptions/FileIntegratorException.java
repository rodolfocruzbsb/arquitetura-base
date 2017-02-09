package br.com.zurcs.base.exceptions;

import java.io.Serializable;

public class FileIntegratorException extends InfraException implements Serializable {

	private static final long serialVersionUID = 1557030676130420715L;

	public FileIntegratorException() {
		this.severity = SeverityException.ERROR;
	}

	public FileIntegratorException( String messagekey, String message, Throwable causa ) {
		super(messagekey, message, causa);
	}

	public FileIntegratorException( String messagekey, String message ) {
		super(messagekey, message);
	}

	public FileIntegratorException( String messagekey, String message, SeverityException severity ) {
		super(messagekey, message, severity);
	}

	public FileIntegratorException( Throwable causa ) {
		super(causa);
	}
}
