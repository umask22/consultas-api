package com.prismamp.consultas.api.util;

import java.security.Security;
import java.security.spec.KeySpec;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Component;

@Component
public class SecurityUtil
{
	static byte[] salt = new byte[] { 0x7d, 0x60, 0x43, 0x5f, 0x02, (byte) 0xe9, (byte) 0xe0, (byte) 0xae };
	static String IV = "AAAAAAAAAAAAAAAA";
	
	public static String[] ATRIBUTOS_OCULTOS = new String[] { "password", "accessToken", "tokenMedioPago", "foto", "nuevoPassword" };
	public static String[] ATRIBUTOS_ENMASCARADOS = new String[] { "TD", "nroTarjeta", "track1", "track2", "cvv2", "tarjeta", "numeroTarjeta" };
	
	static
	{
		Security.addProvider(new org.bouncycastle.jce.provider.BouncyCastleProvider());
	}
	
	public static String encrypt(String jsonString, String key) throws Exception
	{
		try
		{
			SecretKeyFactory factory = SecretKeyFactory.getInstance("PBEWITHSHA256AND128BITAES-CBC-BC");
			KeySpec spec = new PBEKeySpec(key.toCharArray(), salt, 65536, 128);
			SecretKey tmp = factory.generateSecret(spec);
			SecretKey secret = new SecretKeySpec(tmp.getEncoded(), "AES");
			Cipher cipher = Cipher.getInstance("AES/CBC/PKCS7Padding", "BC");
			cipher.init(Cipher.ENCRYPT_MODE, secret, new IvParameterSpec(IV.getBytes("UTF-8")));

			byte[] ciphertext = cipher.doFinal(jsonString.getBytes("UTF-8"));

			byte[] encodedBytes = Base64.encodeBase64(ciphertext);
			return new String(encodedBytes);

		}
		catch (Exception e)
		{
			throw e;
		}
	}

	public static String decrypt(String text, String key) throws Exception
	{
		try
		{
			SecretKeyFactory factory = SecretKeyFactory.getInstance("PBEWITHSHA256AND128BITAES-CBC-BC");
			KeySpec spec = new PBEKeySpec(key.toCharArray(), salt, 65536, 128);
			SecretKey tmp = factory.generateSecret(spec);
			SecretKey secret = new SecretKeySpec(tmp.getEncoded(), "AES");
			Cipher cipher = Cipher.getInstance("AES/CBC/PKCS7Padding", "BC");
			cipher.init(Cipher.DECRYPT_MODE, secret, new IvParameterSpec(IV.getBytes("UTF-8")));

			byte[] encryptedData = Base64.decodeBase64(text.getBytes("UTF-8"));
			byte[] utf8 = cipher.doFinal(encryptedData);

			return new String(utf8, "UTF8");
		}
		catch (Exception e)
		{
			throw e;
		}
	}
	
	public static String getIpAddress(HttpServletRequest request)
	{
		if (request != null)
		{
			String ip = request.getHeader("X-Forwarded-For");
			if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip))
			{
				ip = request.getHeader("Proxy-Client-IP");
			}
			if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip))
			{
				ip = request.getHeader("WL-Proxy-Client-IP");
			}
			if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip))
			{
				ip = request.getHeader("HTTP_CLIENT_IP");
			}
			if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip))
			{
				ip = request.getHeader("HTTP_X_FORWARDED_FOR");
			}
			if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip))
			{
				ip = request.getRemoteAddr();
			}
			return ip;
		}
		else
		{
			return "0.0.0.0";
		}
	}
	
	/**
	 * Protects PAN, Track2, CVC (suitable for logs).
	 *
	 * <pre>
	 * "40000101010001" is converted to "400001____0001"
	 * "40000101010001=020128375" is converted to "400001____0001=0201_____"
	 * "40000101010001D020128375" is converted to "400001____0001D0201_____"
	 * "123" is converted to "___"
	 * </pre>
	 * 
	 * @param s
	 *            string to be protected
	 * @return 'protected' String
	 */
	public static String protect(String s)
	{
		if (StringUtils.isBlank(s))
			return "";
		
		StringBuilder sb = new StringBuilder();
		int len = s.length();
		int clear = len > 6 ? 6 : 0;
		int lastFourIndex = -1;
		if (clear > 0)
		{
			lastFourIndex = s.indexOf('=') - 4;
			if (lastFourIndex < 0)
				lastFourIndex = s.indexOf('^') - 4;
			if (lastFourIndex < 0 && s.indexOf('^') < 0)
				lastFourIndex = s.indexOf('D') - 4;
			if (lastFourIndex < 0)
				lastFourIndex = len - 4;
		}
		for (int i = 0; i < len; i++)
		{
			if (s.charAt(i) == '=' || s.charAt(i) == 'D' && s.indexOf('^') < 0)
				clear = 1; // use clear=5 to keep the expiration date
			else if (s.charAt(i) == '^')
			{
				lastFourIndex = 0;
				clear = len - i;
			}
			else if (i == lastFourIndex)
				clear = 4;
			sb.append(clear-- > 0 ? s.charAt(i) : '_');
		}
		s = sb.toString();
		// Addresses Track1 Truncation
		int charCount = s.replaceAll("[^\\^]", "").length();
		if (charCount == 2)
		{
			s = s.substring(0, s.lastIndexOf("^") + 1);
			s = StringUtils.rightPad(s, len, '_');
		}
		return s;
	}
}
