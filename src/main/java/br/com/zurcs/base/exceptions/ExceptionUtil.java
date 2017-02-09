package br.com.zurcs.base.exceptions;

import static br.com.zurcs.commons.util.validators.IsNullUtil.isNull;
import static br.com.zurcs.commons.util.validators.IsNullUtil.isNullOrEmpty;

import java.io.ByteArrayOutputStream;
import java.io.PrintWriter;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class ExceptionUtil {

	private static final Logger LOGGER = LogManager.getLogger(ExceptionUtil.class);

	public static boolean isInfraException(Exception e) {

		return ( e instanceof InfraException );
	}

	public static void throwsIfTrue(String key, String message, boolean... conditions) {

		throwsIfTrue(key, message, SeverityException.ERROR, conditions);
	}

	public static void throwsIfTrue(String key, String message, SeverityException severity, boolean... conditions) {

		if (!isNullOrEmpty(conditions)) {

			for (boolean condition : conditions) {

				if (condition) {

					throw new BusinessException(key, message, severity);
				}
			}
		}
	}

	public static void throwsIfNull(String key, String message, Object... conditions) {

		throwsIfNull(key, message, SeverityException.ERROR, conditions);
	}

	public static void throwsIfNull(String key, String message, SeverityException severity, Object... conditions) {

		if (!isNullOrEmpty(conditions)) {

			for (Object condition : conditions) {

				if (isNull(condition)) {

					throw new BusinessException(key, message, severity);
				}
			}
		}
	}

	public static String getException(final Throwable th) {

		String value = null;

		try {
			final ByteArrayOutputStream out = new ByteArrayOutputStream();

			final PrintWriter s = new PrintWriter(out);

			th.printStackTrace(s);

			s.close();

			value = new String(out.toByteArray());

			out.close();
		} catch (final Exception ex) {

			ExceptionUtil.LOGGER.error(ex);
		}

		return value;
	}

}
