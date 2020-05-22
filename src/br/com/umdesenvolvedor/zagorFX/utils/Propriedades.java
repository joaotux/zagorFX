package br.com.umdesenvolvedor.zagorFX.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class Propriedades {
	private static Properties prop = new Properties();
	private static FileInputStream file;

	public static Properties getPropriedades() {

		try {
			
			file = new FileInputStream(new File("").getAbsoluteFile() + "/dados.properties");

			prop.load(file);

		} catch (IOException e) {
			e.printStackTrace();
		}

		return prop;
	}

	public static Properties alteraPropriedade(String chave, String valor) {
		try {
			file = new FileInputStream(new File("").getAbsoluteFile() + "/dados.properties");
			
			prop.load(file);
			
			prop.put(chave, valor);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		File file = new File(new File("").getAbsoluteFile() + "/dados.properties");
		
		FileOutputStream fos = null;
		try {
			
			fos = new FileOutputStream(file);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		try {
			
			prop.store(fos, "UTF-8");
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			fos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return prop;
	}
}
