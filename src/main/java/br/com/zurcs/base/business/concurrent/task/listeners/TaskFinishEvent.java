package br.com.zurcs.base.business.concurrent.task.listeners;

import java.util.EventObject;

public class TaskFinishEvent extends EventObject {

	/** Atributo serialVersionUID. */
	private static final long serialVersionUID = 3693030042136820608L;

	public TaskFinishEvent( Object source ) {
		super(source);
	}

}
