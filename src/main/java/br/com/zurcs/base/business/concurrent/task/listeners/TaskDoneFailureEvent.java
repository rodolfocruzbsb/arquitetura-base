package br.com.zurcs.base.business.concurrent.task.listeners;

import java.util.EventObject;

public class TaskDoneFailureEvent extends EventObject {

	/** Atributo serialVersionUID. */
	private static final long serialVersionUID = 4306005727541077559L;

	public TaskDoneFailureEvent( Object source ) {
		super(source);
	}

}
