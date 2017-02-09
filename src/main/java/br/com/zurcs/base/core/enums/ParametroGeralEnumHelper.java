package br.com.zurcs.base.core.enums;

import java.util.ArrayList;
import java.util.List;

public class ParametroGeralEnumHelper {

	private static final String LDAP = "LDAP_";

	private static final String MAIL = "MAIL_";

	private static final String JCO_DESTINATION = "JCO_DESTINATION_";

	private static final String JCO_SERVER = "JCO_SERVER";

	private ParametroGeralEnumHelper() {

	}

	/**
	 * <p>
	 * Recupera todas as Keys de parametro geral relacionado ao EMAIL
	 * </p>
	 * 
	 * @author Rodolfo Cruz - rodolfocruz.ti@gmail.com
	 *
	 * @return
	 */
	public static ParametroGeralEnum[] getMailKeys() {

		return getKeysStartsWith(MAIL);
	}

	/**
	 * <p>
	 * Recupera todas as Keys de parametro geral relacionado ao Connectors RFC
	 * </p>
	 * 
	 * @author Rodolfo Cruz - rodolfocruz.ti@gmail.com
	 *
	 * @return
	 */
	public static ParametroGeralEnum[] getSapJcoDestinationKeys() {

		return getKeysStartsWith(JCO_DESTINATION);
	}

	/**
	 * <p>
	 * Recupera todas as Keys de parametro geral relacionado ao Servidor RFC
	 * </p>
	 * 
	 * @author Rodolfo Cruz - rodolfocruz.ti@gmail.com
	 *
	 * @return
	 */
	public static ParametroGeralEnum[] getSapJcoServerKeys() {

		return getKeysStartsWith(JCO_SERVER);
	}

	public static ParametroGeralEnum[] getLdapKeys() {

		return getKeysStartsWith(LDAP);
	}

	/**
	 * Método responsável por retornar os Enums que iniciam com o parametro informado
	 *
	 * @author Rodolfo Cruz - rodolfocruz.ti@gmail.com
	 *
	 * @param prefix
	 * @return
	 */
	public static ParametroGeralEnum[] getKeysStartsWith(String prefix) {

		int qtdEnums = ParametroGeralEnum.values().length;

		List<ParametroGeralEnum> result = new ArrayList<ParametroGeralEnum>();

		for (int i = 0; i < qtdEnums; i++) {

			if (ParametroGeralEnum.values()[i].toString().startsWith(prefix)) {

				result.add(ParametroGeralEnum.values()[i]);
			}
		}

		return result.toArray(new ParametroGeralEnum[0]);
	}
}
