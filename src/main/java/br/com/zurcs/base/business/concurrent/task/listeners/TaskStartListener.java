package br.com.zurcs.base.business.concurrent.task.listeners;

import java.util.EventListener;

@FunctionalInterface
public interface TaskStartListener extends EventListener {

	void listen(TaskStartEvent event);

}
