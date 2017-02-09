package br.com.zurcs.base.test.util;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import java.util.Map;

import org.junit.BeforeClass;
import org.junit.Test;

import br.com.zurcs.base.util.QueryParameter;

public class QueryParameterTest {

	private static final String STRING_EXPECTED = "QueryParameter={cpf=111.222.333-44, nome=José, id=10}";
												
	private static final QueryParameter PARAMETERS = QueryParameter.with("nome", "José").and("cpf", "111.222.333-44").and("id", "10");

	@BeforeClass
	public static void runOnceBeforeClass() {

	}

	@Test
	public void deve_retornar_string_predefinida() {

		assertThat(STRING_EXPECTED, equalTo(PARAMETERS.toString()));
	}

	@Test
	public void deve_retornar_map_com_quantidade_de_parametros_predefinido() {

		final Map<String, Object> param = PARAMETERS.parameters();

		assertThat(param.size(), equalTo(3));
	}

}
