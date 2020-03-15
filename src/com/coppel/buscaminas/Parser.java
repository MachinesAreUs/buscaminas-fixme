package com.coppel.buscaminas;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Parser {
	
	public static BuscaMinas parsea(String str) throws Exception {
		List<String> lineas = new LinkedList<String>(Arrays.asList(str.split("\n")));
				
		Dimensiones dim = parseaEncabezados(lineas.get(0).trim());
		Celda[][] celdas = new Celda[dim.filas][dim.columnas];
		
		lineas.remove(0);
		
		for (int numFila = 0; numFila < dim.filas; numFila++) {
			celdas[numFila] = parseaFila(lineas.get(numFila).trim());
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
