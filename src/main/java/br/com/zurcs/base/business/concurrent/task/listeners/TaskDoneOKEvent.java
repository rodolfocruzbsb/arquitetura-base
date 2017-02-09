package br.com.zurcs.base.business.concurrent.task.listeners;

import java.util.EventObject;

public class TaskDoneOKEvent extends EventObject {

	/** Atributo serialVersionUID. */
	private static final long serialVersionUID = 1870593886530316108L;

	public TaskDoneOKEvent( Object source ) {
		super(source);
	}

}
