package br.com.zurcs.base.business.concurrent.task.listeners;

import java.util.EventListener;

@FunctionalInterface
public interface TaskFinishListener extends EventListener {

	void listen(TaskFinishEvent event);

}
