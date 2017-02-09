package br.com.zurcs.base.business.concurrent.task.listeners;

import java.util.EventListener;

@FunctionalInterface
public interface TaskDoneFailureListener extends EventListener {

	void listen(TaskDoneFailureEvent event);
}
