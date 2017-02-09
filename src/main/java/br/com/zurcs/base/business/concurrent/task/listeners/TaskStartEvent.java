package br.com.zurcs.base.business.concurrent.task.listeners;

import java.util.EventObject;

public class TaskStartEvent extends EventObject {

	/** Atributo serialVersionUID. */
	private static final long serialVersionUID = 7888749178330158818L;

	public TaskStartEvent( Object source ) {
		super(source);
	}

}
