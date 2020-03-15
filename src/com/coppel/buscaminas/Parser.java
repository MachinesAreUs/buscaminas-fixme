package com.coppel.buscaminas;

import java.io.BufferedReader;
import java.io.StringReader;

public class Parser {

	public static BuscaMinas parsea(String str) throws Exception {
		BufferedReader reader = new BufferedReader(new StringReader(str));
		
		Celda[][] celdas = null;
		
        String cadena;        
        int numFila = 0;
        
        while((cadena = reader.readLine()) != null) {
        	if (numFila == 0) {
        		Dimensiones dim = parseaEncabezados(cadena);
        		celdas = new Celda[dim.filas][dim.columnas];
        	} else {
        		celdas[numFila -1] = parseaFila(cadena);
        	}
        	numFila++;
        }
        return new BuscaMinas(celdas);
	}

	public static Celda[] parseaFila(String cadena) {
		Celda[] fila = new Celda[cadena.length()];
		for (int i = 0; i < cadena.length(); i++) {
			Celda celda = new Celda();
			char c = cadena.charAt(i);
			if (c == '*') {
				celda.setMina(true);
			}
			fila[i] = celda;
		}
		return fila;
	}

	public static Dimensiones parseaEncabezados(String str) {
		String[] datos = str.split(" ");
		int filas = Integer.parseInt(datos[0]);
		int columnas = Integer.parseInt(datos[1]);
		return new Dimensiones(filas, columnas);
	}
	
	public static class Dimensiones {

		public int filas;
		public int columnas;
		
		public Dimensiones(int filas, int columnas) {
			this.filas = filas;
			this.columnas = columnas;
		}
	}
}
