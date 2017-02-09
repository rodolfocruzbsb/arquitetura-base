package br.com.zurcs.base.business.concurrent.task;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Future;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import br.com.zurcs.base.business.concurrent.task.listeners.TaskDoneFailureEvent;
import br.com.zurcs.base.business.concurrent.task.listeners.TaskDoneFailureListener;
import br.com.zurcs.base.business.concurrent.task.listeners.TaskDoneOKEvent;
import br.com.zurcs.base.business.concurrent.task.listeners.TaskDoneOKListener;
import br.com.zurcs.base.business.concurrent.task.listeners.TaskFinishEvent;
import br.com.zurcs.base.business.concurrent.task.listeners.TaskFinishListener;
import br.com.zurcs.base.business.concurrent.task.listeners.TaskStartEvent;
import br.com.zurcs.base.business.concurrent.task.listeners.TaskStartListener;
import br.com.zurcs.base.exceptions.BusinessException;
import br.com.zurcs.base.exceptions.ExceptionUtil;
import br.com.zurcs.commons.util.validators.IsNullUtil;

/**
 * <p>
 * <b>Title:</b> Task.java
 * </p>
 * 
 * <p>
 * <b>Description:</b> Classe para execução de tarefas multithreads e com possibilidade de dependencia entre elas, além de ter a opção de retorno entre as threads.
 * </p>
 * 
 * <p>
 * <b>Company: </b> Rodolfo Cruz T.I.
 * </p>
 * 
 * @author Rodolfo Cruz - rodolfocruz.ti@gmail.com
 * 
 * @version 1.0.0
 */
public abstract class Task implements Callable<TaskResult> {

	/** Atributo logger. */
	protected Logger logger = LogManager.getLogger(this.getClass());

	protected TaskResult result;

	private final List<Future<TaskResult>> dependencias = new ArrayList<>();

	/**
	 * LISTENERS
	 */
	private final CopyOnWriteArrayList<TaskDoneOKListener> listenersDoneOk;

	private final CopyOnWriteArrayList<TaskDoneFailureListener> listenersDoneFailure;

	private final CopyOnWriteArrayList<TaskStartListener> listenersStart;

	private final CopyOnWriteArrayList<TaskFinishListener> listenersFinish;

	public Task() {

		this.result = TaskResult.newInstance();

		listenersStart = new CopyOnWriteArrayList<>();

		listenersDoneOk = new CopyOnWriteArrayList<>();

		listenersDoneFailure = new CopyOnWriteArrayList<>();

		listenersFinish = new CopyOnWriteArrayList<>();
	}

	/***********************
	 * DONE OK LISTENER
	 ***********************/
	/**
	 * Método responsável por <b>disparar</b> os listener de DoneOK, executados quando a tarefa é executada com <b>sucesso</b>
	 *
	 * @author Rodolfo Cruz - rodolfocruz.ti@gmail.com
	 *
	 */
	protected void fireDoneOKEvent() {

		TaskDoneOKEvent evt = new TaskDoneOKEvent(this);

		listenersDoneOk.parallelStream().forEach(l -> l.listen(evt));
	}

	/**
	 * Método responsável por <b>adicionar</b> listener para DoneOK, executados quando a tarefa é executada com <b>sucesso</b>
	 *
	 * @author Rodolfo Cruz - rodolfocruz.ti@gmail.com
	 *
	 * @param listener
	 */
	public void addDoneOkListener(TaskDoneOKListener listener) {

		if (IsNullUtil.isNotNull(listener)) {

			this.listenersDoneOk.add(listener);
		}
	}

	/**
	 * Método responsável por <b>remover</b> listener de DoneOK, executados quando a tarefa é finalizada com <b>sucesso</b>
	 *
	 * @author Rodolfo Cruz - rodolfocruz.ti@gmail.com
	 *
	 * @param listener
	 */
	public void removeDoneOkListener(TaskDoneOKListener listener) {

		if (IsNullUtil.isNotNull(listener)) {

			this.listenersDoneOk.remove(listener);
		}
	}

	/***********************
	 * DONE FAILURE LISTENER
	 ***********************/
	/**
	 * Método responsável por <b>disparar</b> os listener de DoneFailure, executados quando a tarefa é executada com <b>falha</b>
	 *
	 * @author Rodolfo Cruz - rodolfocruz.ti@gmail.com
	 *
	 */
	protected void fireDoneFailureEvent() {

		TaskDoneFailureEvent evt = new TaskDoneFailureEvent(this);

		listenersDoneFailure.parallelStream().forEach(l -> l.listen(evt));
	}

	/**
	 * Método responsável por <b>adicionar</b> listener para DoneFailure, executados quando a tarefa é executada com <b>falha</b>
	 *
	 * @author Rodolfo Cruz - rodolfocruz.ti@gmail.com
	 *
	 * @param listener
	 */
	public void addDoneFailureListener(TaskDoneFailureListener listener) {

		if (IsNullUtil.isNotNull(listener)) {

			this.listenersDoneFailure.add(listener);
		}
	}

	/**
	 * Método responsável por <b>remover</b> listener para DoneFailure, executados quando a tarefa é executada com <b>falha</b>
	 *
	 * @author Rodolfo Cruz - rodolfocruz.ti@gmail.com
	 *
	 * @param listener
	 */
	public void removeDoneFailureListener(TaskDoneFailureListener listener) {

		if (IsNullUtil.isNotNull(listener)) {

			this.listenersDoneFailure.remove(listener);
		}
	}

	/***********************
	 * START LISTENER
	 ***********************/
	/**
	 * Método responsável por <b>disparar</b> os listener de Start, executados quando a tarefa é <b>iniciada</b>
	 *
	 * @author Rodolfo Cruz - rodolfocruz.ti@gmail.com
	 *
	 */
	protected void fireStartEvent() {

		TaskStartEvent evt = new TaskStartEvent(this);

		listenersStart.parallelStream().forEach(l -> l.listen(evt));
	}

	/**
	 * Método responsável por <b>adicionar</b> listener para Start, executados quando a tarefa é <b>iniciada</b>
	 *
	 * @author Rodolfo Cruz - rodolfocruz.ti@gmail.com
	 *
	 * @param listener
	 */
	public void addStartListener(TaskStartListener listener) {

		if (IsNullUtil.isNotNull(listener)) {

			this.listenersStart.add(listener);
		}
	}

	/**
	 * Método responsável por <b>remover</b> listener para DoneFailure, executados quando a tarefa é <b>iniciada</b>
	 *
	 * @author Rodolfo Cruz - rodolfocruz.ti@gmail.com
	 *
	 * @param listener
	 */
	public void removeStartListener(TaskStartListener listener) {

		if (IsNullUtil.isNotNull(listener)) {

			this.listenersStart.remove(listener);
		}
	}

	/***********************
	 * FINISH LISTENER
	 ***********************/
	protected void fireFinishEvent() {

		TaskFinishEvent evt = new TaskFinishEvent(this);

		listenersFinish.parallelStream().forEach(l -> l.listen(evt));
	}

	/**
	 * Método responsável por
	 *
	 * @author Rodolfo Cruz - rodolfocruz.ti@gmail.com
	 *
	 * @param listener
	 */
	public void addFinishListener(TaskFinishListener listener) {

		if (IsNullUtil.isNotNull(listener)) {

			this.listenersFinish.add(listener);
		}

	}

	/**
	 * Método responsável por remover um listener para TaskFinishListener
	 *
	 * @author Rodolfo Cruz - rodolfocruz.ti@gmail.com
	 *
	 * @param listener
	 */
	public void removeFinishListener(TaskFinishListener listener) {

		if (IsNullUtil.isNotNull(listener)) {

			this.listenersFinish.remove(listener);
		}
	}

	/**
	 * Descrição Padrão: <br>
	 * <br>
	 *
	 * {@inheritDoc}
	 *
	 * @see java.util.concurrent.Callable#call()
	 */
	@Override
	public TaskResult call() throws Exception {

		this.start();

		this.fireStartEvent();

		try {

			this.result.setInicio(Instant.now());

			this.tratarDependencias(result);

			this.execute();

			result.setSuccess(Boolean.TRUE);

		} catch (final Exception e) {

			logger.error(e);

			this.tratarErro(result, e);
		}

		result.setFim(Instant.now());

		if (result.getSuccess()) {

			this.doneOK();

			this.fireDoneOKEvent();
		} else {

			this.doneFailure();

			this.fireDoneFailureEvent();
		}

		this.finish();

		this.fireFinishEvent();

		return result;
	}

	private void tratarDependencias(final TaskResult result) {

		this.dependencias.stream().forEachOrdered(d -> {
			try {
				final TaskResult taskResult = d.get();
				
				ExceptionUtil.throwsIfTrue("XXXXX", "Ocorreu algum erro na execução da task dependente ["+taskResult.getIdProcesso()+"]", !taskResult.getSuccess());
				
				this.logger.debug(taskResult);


			} catch (Exception e) {

				throw new BusinessException(e);
			}
		});
	}

	private void tratarErro(final TaskResult result, final Exception e) {

		result.setMensagem(e.getMessage());

		result.setSuccess(Boolean.FALSE);

		result.setFim(Instant.now());

		this.tratarException(e, result);
	}

	/**
	 * Método responsável por adicionar tarefa a quail esta será dependente para ser executada.
	 *
	 * @author Rodolfo Cruz - rodolfocruz.ti@gmail.com
	 *
	 * @param dependencia
	 */
	public void addDependencia(final Future<TaskResult> dependencia) {

		if (IsNullUtil.isNotNull(dependencia)) {

			this.dependencias.add(dependencia);
		}

	}

	/**
	 * Método responsável por adicionar tarefas as quais esta será dependente para ser executada.
	 *
	 * @author Rodolfo Cruz - rodolfocruz.ti@gmail.com
	 *
	 * @param dependencias
	 */
	public void addDependencias(List<Future<TaskResult>> dependencias) {

		if (IsNullUtil.isNotNull(dependencias)) {

			dependencias.forEach(d -> this.dependencias.add(d));
		}

	}

	/**
	 * Método responsável por tratar de forma customizada o erro
	 *
	 * @author Rodolfo Cruz - rodolfocruz.ti@gmail.com
	 *
	 * @param e
	 * @param result
	 */
	protected void tratarException(final Exception e, final TaskResult result) {

	}

	/**
	 * Método responsável por realizar alguma ação no Start da rotina da task
	 *
	 * @author Rodolfo Cruz - rodolfocruz.ti@gmail.com
	 *
	 */
	protected void start() {

	}

	/**
	 * Método responsável por realizar alguma ação quando a task é realizada com <b>SUCESSO</b>
	 *
	 * @author Rodolfo Cruz - rodolfocruz.ti@gmail.com
	 *
	 */
	protected void doneOK() {

	}

	/**
	 * Método responsável por realizar alguma ação quando a task é realizada com <b>FALHA</b>
	 *
	 * @author Rodolfo Cruz - rodolfocruz.ti@gmail.com
	 *
	 */
	protected void doneFailure() {

	}

	/**
	 * Método responsável por realizar alguma ação quando a task é finalizada
	 *
	 * @author Rodolfo Cruz - rodolfocruz.ti@gmail.com
	 *
	 */
	protected void finish() {

	}

	/**
	 * Método responsável por executar a principal <b>ROTINA</b> da tarefa
	 *
	 * @author Rodolfo Cruz - rodolfocruz.ti@gmail.com
	 *
	 */
	protected abstract void execute() throws Exception;
}
