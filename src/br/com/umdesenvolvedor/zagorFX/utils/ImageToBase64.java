package br.com.umdesenvolvedor.zagorFX.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Base64;

public class ImageToBase64 {

	public static String converte(File file) {
		byte imageByte[] = new byte[(int) file.length()];
		FileInputStream fileInputStream = null;
		String base64Image = "";

		try {
			fileInputStream = new FileInputStream(file);
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}

		try {
			fileInputStream.read(imageByte);
		} catch (IOException e) {
			e.printStackTrace();
		}
		base64Image = Base64.getEncoder().encodeToString(imageByte);

		return base64Image;
	}
}
