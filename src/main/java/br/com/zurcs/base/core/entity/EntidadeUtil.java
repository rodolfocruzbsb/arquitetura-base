package br.com.zurcs.base.core.entity;

import br.com.zurcs.base.entity.Entidade;
import br.com.zurcs.commons.util.validators.IsNullUtil;


public class EntidadeUtil {

	public static boolean isNullEntidade(Entidade<?> entidade) {

		return IsNullUtil.isNull(entidade);
	}

	public static boolean isNullOrEmptyEntidade(Entidade<?> entidade) {

		return IsNullUtil.isNull(entidade)

				|| IsNullUtil.isNullOrEmpty(entidade.getId());

	}

	public static boolean isNotNullOrEmptyEntidade(Entidade<?> entidade) {

		return !isNullOrEmptyEntidade(entidade);
	}

	public static boolean isNotNullEntidade(Entidade<?> entidade) {

		return !isNullEntidade(entidade);
	}

}
