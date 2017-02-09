package br.com.zurcs.base.core.enums;

/**
 * <p>
 * <b>Title:</b> ParametroGeralEnum.java
 * </p>
 * 
 * <p>
 * <b>Description:</b> Enum para mapeamento de parametros gerais mais comuns da aplicação.
 * </p>
 * 
 * <p>
 * <b>Company: </b> Rodolfo Cruz T.I.
 * </p>
 * 
 * @author Rodolfo Cruz - rodolfocruz.ti@gmail.com
 * 
 * @see br.com.zurcs.base.core.enums.ParametroGeralEnumHelper
 * @version 1.0.0
 */
public enum ParametroGeralEnum {

	/*
	 * ATRIBUTOS EMAIL
	 */
	MAIL_SMTP_FULL("mail.smtp.full"),

	MAIL_SMTP_HOST("mail.smtp.host"),

	MAIL_SMTP_PORT("mail.smtp.port"),

	MAIL_SMTP_USER("mail.smtp.user"),

	MAIL_SMTP_PASSWORD("mail.smtp.password"),

	MAIL_SMTP_AUTH("mail.smtp.auth"),

	MAIL_SMTP_START_TLS("mail.smtp.starttls.enable"),

	MAIL_SMTP_QUIT_WAIT("mail.smtp.quitwait"),

	MAIL_SMTP_SSL_TRUST("mail.smtp.ssl.trust"),

	MAIL_SMTP_FROM("mail.smtp.from"),

	MAIL_DEBUG("mail.debug"),

	MAIL_SEND_CC("mail.send.cc"), // Define se envia email de cópia

	MAIL_SEND_CC_TO("mail.send.cc.to"),

	MAIL_SEND_CCO("mail.send.cco"), // Define se envia email de cópia oculta

	MAIL_SEND_CCO_TO("mail.send.cco.to"),
	
	MAIL_COMUNICACAO_ATIVA("mail.comunicacao.ativa"),
	
	MAIL_EMAILS_DESENVOLVEDORES("mail.emails.desenvolvedores"),
	
	MODO_DESENVOLVIMENTO_ENABLE("modo.desenvolvimento.enable"),

	NOTIFICATION_EMAIL_ENABLE("notification.message.email.enable"),

	NOTIFICATION_SMS_ENABLE("notification.message.sms.enable"),

	NOTIFICATION_TASK_ENABLE("notification.message.task.enable"),

	SESSION_TIMEOUT("session.timeout"),

	/*
	 * ATRIBUTOS SAP JCO
	 */
	JCO_DESTINATION_DEST("jco.destination.dest"),

	JCO_DESTINATION_CLIENT("jco.destination.client"),

	JCO_DESTINATION_SYSNR("jco.destination.sysnr"),

	JCO_DESTINATION_AHOST("jco.destination.ashost"),

	JCO_DESTINATION_USERNAME("jco.destination.username"),

	JCO_DESTINATION_PASSWORD("jco.destination.password"),

	JCO_DESTINATION_SAPROUTER("jco.destination.saprouter"),

	JCO_DESTINATION_SAPROUTER_COMPLETO("jco.destination.saprouter_completo"),

	JCO_DESTINATION_LANG("jco.destination.lang"),

	JCO_DESTINATION_USESAPLOGIN("jco.destination.useSapLogin"),

	JCO_DESTINATION_PEAKLIMIT("jco.destination.peaklimit"),

	JCO_DESTINATION_POOLCAPACITY("jco.destination.poolcapacity"),

	JCO_DESTINATION_TRACE("jco.destination.trace"),

	JCO_DESTINATION_TRACELEVEL("jco.destination.tracelevel"),

	JCO_DESTINATION_TRACEPATH("jco.destination.tracePath"),

	/*
	 * SAP JCO RFC-SERVER
	 */
	JCO_SERVER_CLIENT_COUNT("jco.server.connection_count"),

	JCO_SERVER_GWHOST("jco.server.gwhost"),

	JCO_SERVER_GWSERVER("jco.server.gwserver"),

	JCO_SERVER_PROG_ID("jco.server.prog_id"),

	JCO_SERVER_SAPROUTER("jco.server.saprouter"),

	JCO_SERVER_SERVER_NAME("jco.server.server_name"),

	JCO_SERVER_FUNCTION_NAME("jco.server.function_name"),

	JCO_SERVER_REPOSITORY_NAME("jco.server.repository_name"),

	/*
	 * LDAP
	 */
	LDAP_SERVIDOR("ldap.servidor"),

	LDAP_PORTA("ldap.porta"),

	LDAP_DOMINIO("ldap.dominio"),

	LDAP_USUARIO("ldap.usuario"),

	LDAP_SENHA("ldap.senha"),

	/*
	 * SENHA MASTER DA APLICAÇÃO
	 */
	PASSWORD_MASTER("password.master"),
	
	EMAIL_SOLICITACAO_CASDATRO("email.solicitacao.cadastro"),
	
	/*
	 * AUTENTICACAO WS SOAP
	 */
	WS_SOAP_AUTENTICACAO_ENABLE("ws.soap.autenticacao.enable"),
	
	/*
	 * URL DE ACESSO AO SISTEMA[Ex: http://zurcs.com.br/] 
	 */
	URL_ACESSO_SISTEMA("url.acesso.sistema");

	private ParametroGeralEnum( String key ) {
		this.key = key;
	}

	private String key;

	public String getKey() {

		return key;
	}

}
