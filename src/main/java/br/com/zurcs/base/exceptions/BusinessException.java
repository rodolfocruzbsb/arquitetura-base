package br.com.zurcs.base.exceptions;

import java.io.Serializable;

public class BusinessException extends InfraException implements Serializable {

	private static final long serialVersionUID = 1557030676130420715L;

	public BusinessException() {
		this.severity = SeverityException.ERROR;
	}

	public BusinessException( String messagekey, String message, Throwable causa ) {
		super(messagekey, message, causa);
	}

	public BusinessException( String messagekey, String message ) {
		super(messagekey, message);
	}

	public BusinessException( String messagekey, String message, SeverityException severity ) {
		super(messagekey, message, severity);
	}

	public BusinessException( Throwable causa ) {
		super(causa);
	}
}
