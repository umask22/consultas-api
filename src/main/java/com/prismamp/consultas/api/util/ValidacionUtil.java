package com.prismamp.consultas.api.util;

public class ValidacionUtil {

	/*
	 * Patrones genericos
	 */
	public static final String REGEX_NRO_DOCUMENTO = "\\d{5,12}";
	public static final String REGEX_FIID = "[A-Z]{4}";
	public static final String REGEX_ALIAS = "[\\w.-]{6,22}";
	public static final String REGEX_CBU = "\\d{22}";
	public static final String REGEX_CANAL = "[A-Z]{1}";
	public static final String REGEX_TIPO_DOCUMENTO = "\\d{1}";
	public static final String REGEX_IP = "^([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\.([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\.([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\.([01]?\\d\\d?|2[0-4]\\d|25[0-5])$";
	public static final String REGEX_TARJETA = "\\d{8,19}";
	public static final String REGEX_NRO_CUENTA = "\\d{1,19}";
	public static final String REGEX_NRO_OPERACION = "\\d{1,19}";
	public static final String REGEX_TIPO_CUENTA = "\\d{2}";
	public static final String REGEX_ID_EMPRESA = "\\w{1,4}";
	public static final String REGEX_ID_CLIENTE = "\\d{1,19}";

	/*
	 * Patrones Doble Factor - TCORD
	 */

	public static final String REGEX_COORDENADA = "\\d{2}";
	public static final String REGEX_COORDENADA_DISPLAY = "[a-zA-Z]{1}[0-9]{1}";
	public static final String REGEX_CANTIDAD_COORDENADAS_DISPONIBLE = "\\d{3}";
	public static final String REGEX_NRO_SERIE = "\\d{1,4}";
	public static final String REGEX_REFERENCIA = "[\\w [ ]?]{1,12}";

	/*
	 * TSMS y TVIR
	 */
	public static final String REGEX_TOKEN = "[\\w]{1,10}";

}
