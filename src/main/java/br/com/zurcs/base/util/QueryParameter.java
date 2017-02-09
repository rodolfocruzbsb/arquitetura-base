package br.com.zurcs.base.util;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import br.com.zurcs.commons.util.validators.IsNullUtil;

public class QueryParameter implements Serializable {

	private static final long serialVersionUID = -8233411634166583221L;

	private final Map<String, Object> parameters = new HashMap<>();

	private QueryParameter( final String name, final Object value ) {

		this.parameters.put(name, value);
	}

	/**
	 * Método responsável por criar um QueryParameter nulo.
	 *
	 *
	 * @return
	 */
	public static QueryParameter nullQueryParameter() {

		// TODO Aplicar o Null Pattern.
		return null;
	}

	public static QueryParameter with(final String name, final Object value) {

		return new QueryParameter(name, value);
	}

	public QueryParameter and(final String name, final Object value) {

		this.parameters.put(name, value);
		return this;
	}

	public Map<String, Object> parameters() {

		return this.parameters;
	}

	public boolean isNull() {

		return IsNullUtil.isNullOrEmpty(this.parameters);
	}

	public static void main(final String[] args) {

		final QueryParameter parameters = QueryParameter.with("nome", "José").and("cpf", "111.222.333-44").and("id", "10");

		final Map<String, Object> param = parameters.parameters();

		for (final Map.Entry<String, Object> entry : param.entrySet()) {
			System.out.println(entry.getKey() + "=" + entry.getValue());
		}
		System.out.println("----------------------------------------");
		System.out.println(parameters);

	}

	@Override
	public String toString() {

		StringBuilder builder = new StringBuilder("QueryParameter={");

		if (this.parameters != null) {

			for (final Map.Entry<String, Object> entry : this.parameters.entrySet()) {

				builder.append(entry.getKey()).append("=").append(entry.getValue()).append(", ");
			}

		}

		builder = new StringBuilder(StringUtils.removeEnd(builder.toString(), ", "));

		builder.append("}");

		return builder.toString();
	}
}
