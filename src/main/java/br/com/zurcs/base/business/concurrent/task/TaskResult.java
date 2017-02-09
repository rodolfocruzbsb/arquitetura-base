package br.com.zurcs.base.business.concurrent.task;

import java.time.Duration;
import java.time.Instant;

import br.com.zurcs.commons.util.validators.IsNullUtil;

public final class TaskResult {

	private Instant inicio;

	private Instant fim;

	private Boolean success;

	private String mensagem;

	private String idProcesso;

	private int qtdRegistrosAfetador;

	private TaskResult() {

	}

	public TaskResult( Instant inicio ) {
		this.inicio = inicio;
	}

	public static TaskResult newInstance() {

		return new TaskResult();
	}

	public static TaskResult newInstance(Instant inicio) {

		return new TaskResult(inicio);
	}

	public Duration getDuracao() {

		return IsNullUtil.isNotNull(inicio) && IsNullUtil.isNotNull(fim) ? Duration.between(inicio, fim) : null;
	}

	public String getDuracaoStr() {

		Duration duracao = this.getDuracao();
		return IsNullUtil.isNotNull(duracao) ? this.getDuracao().toString() : null;
	}

	/**
	 * Retorna o valor do atributo <code>inicio</code>
	 *
	 * @return <code>Instant</code>
	 */
	public Instant getInicio() {

		return inicio;
	}

	/**
	 * Define o valor do atributo <code>inicio</code>.
	 *
	 * @param inicio
	 */
	public void setInicio(Instant inicio) {

		this.inicio = inicio;
	}

	/**
	 * Retorna o valor do atributo <code>fim</code>
	 *
	 * @return <code>Instant</code>
	 */
	public Instant getFim() {

		return fim;
	}

	/**
	 * Define o valor do atributo <code>fim</code>.
	 *
	 * @param fim
	 */
	public void setFim(Instant fim) {

		this.fim = fim;
	}

	/**
	 * Retorna o valor do atributo <code>success</code>
	 *
	 * @return <code>Boolean</code>
	 */
	public Boolean getSuccess() {

		return success;
	}

	/**
	 * Define o valor do atributo <code>success</code>.
	 *
	 * @param success
	 */
	public void setSuccess(Boolean success) {

		this.success = success;
	}

	/**
	 * Retorna o valor do atributo <code>mensagem</code>
	 *
	 * @return <code>String</code>
	 */
	public String getMensagem() {

		return mensagem;
	}

	/**
	 * Define o valor do atributo <code>mensagem</code>.
	 *
	 * @param mensagem
	 */
	public void setMensagem(String mensagem) {

		this.mensagem = mensagem;
	}

	/**
	 * Retorna o valor do atributo <code>idProcesso</code>
	 *
	 * @return <code>String</code>
	 */
	public String getIdProcesso() {

		return idProcesso;
	}

	/**
	 * Define o valor do atributo <code>idProcesso</code>.
	 *
	 * @param idProcesso
	 */
	public void setIdProcesso(String idProcesso) {

		this.idProcesso = idProcesso;
	}

	/**
	 * Retorna o valor do atributo <code>qtdRegistrosAfetador</code>
	 *
	 * @return <code>int</code>
	 */
	public int getQtdRegistrosAfetador() {

		return qtdRegistrosAfetador;
	}

	/**
	 * Define o valor do atributo <code>qtdRegistrosAfetador</code>.
	 *
	 * @param qtdRegistrosAfetador
	 */
	public void setQtdRegistrosAfetador(int qtdRegistrosAfetador) {

		this.qtdRegistrosAfetador = qtdRegistrosAfetador;
	}

	/**
	 * Descrição Padrão: <br>
	 * <br>
	 *
	 * {@inheritDoc}
	 *
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {

		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("SincronizacaoResult [");
		stringBuilder.append(" idProcesso=").append(idProcesso);
		stringBuilder.append(", qtdRegistrosAfetador=").append(qtdRegistrosAfetador);
		stringBuilder.append(", inicio=").append(inicio);
		stringBuilder.append(", fim=").append(fim);
		stringBuilder.append(", duracao=").append(getDuracao());
		stringBuilder.append(", success=").append(success);
		stringBuilder.append(", mensagem=").append(mensagem);
		stringBuilder.append("]");
		return stringBuilder.toString();
	}

	public static void main(String[] args) {

		TaskResult t = TaskResult.newInstance();
		t.inicio = Instant.now();
		t.fim = t.inicio.plusSeconds(45);
		System.out.println(t);
	}
}
