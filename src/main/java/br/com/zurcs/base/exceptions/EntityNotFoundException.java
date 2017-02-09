package br.com.zurcs.base.exceptions;

import java.io.Serializable;

public class EntityNotFoundException extends InfraException implements Serializable {

	/** Atributo serialVersionUID. */
	private static final long serialVersionUID = -7685257772160144953L;

	public EntityNotFoundException() {
		this.severity = SeverityException.ATENCAO;
	}

	public EntityNotFoundException( String messagekey, String message, Throwable causa ) {
		super(messagekey, message, causa);
	}

	public EntityNotFoundException( String messagekey, String message ) {
		super(messagekey, message);
	}

	public EntityNotFoundException( String messagekey, String message, SeverityException severity ) {
		super(messagekey, message, severity);
	}

	public EntityNotFoundException( Throwable causa ) {
		super(causa);
	}
}
