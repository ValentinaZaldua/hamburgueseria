package Hamburgueseria.Persistencia;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class Archivo {

	public static ArrayList<String> leerArchivo(String nombre) {
		try {
			ArrayList<String> lineas = new ArrayList<String>();

			BufferedReader br = new BufferedReader(new FileReader(nombre));
			String linea;
			while ((linea = br.readLine()) != null) {
				lineas.add(linea);
			}
			br.close();
			return lineas;
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}

	}

	public static ArrayList<String> leerArchivo2(String nombre_combo) {
		try {
			ArrayList<String> lineas = new ArrayList<String>();

			BufferedReader br = new BufferedReader(new FileReader(nombre_combo));
			String linea;
			while ((linea = br.readLine()) != null) {
				lineas.add(linea);
			}
			br.close();
			return lineas;
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
		
	}
}