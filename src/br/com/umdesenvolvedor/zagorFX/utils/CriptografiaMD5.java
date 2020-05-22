package br.com.umdesenvolvedor.zagorFX.utils;

import java.security.MessageDigest;

public class CriptografiaMD5 {

	private static MessageDigest md = null;

	static {
		try {

			md = MessageDigest.getInstance("MD5");

		} catch (Exception e) {
			System.err.println(e);
		}
	}

	public static char[] hexCodes(byte[] text) {
		char[] hexOutput = new char[text.length * 2];
		String hexString;

		for (int i = 0; i < text.length; i++) {
			hexString = "00" + Integer.toHexString(text[i]);
			hexString.toUpperCase().getChars(hexString.length() - 2, hexString.length(), hexOutput, i * 2);
		}
		return hexOutput;
	}

	public static String criptografar(String pwd) {
		if (md != null) {
			return new String(hexCodes(md.digest(pwd.getBytes())));
		}
		return null;
	}

}
