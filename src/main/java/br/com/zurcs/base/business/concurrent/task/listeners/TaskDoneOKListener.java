package br.com.zurcs.base.business.concurrent.task.listeners;

import java.util.EventListener;

@FunctionalInterface
public interface TaskDoneOKListener extends EventListener {

	void listen(TaskDoneOKEvent event);

}
