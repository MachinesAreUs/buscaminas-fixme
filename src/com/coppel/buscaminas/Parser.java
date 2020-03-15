package com.coppel.buscaminas;

import java.io.BufferedReader;
import java.io.StringReader;

public class Parser {

	public static Tablero parse(String str) throws Exception {
		BufferedReader reader = new BufferedReader(new StringReader(str));
		
		Celda[][] celdas = null;
		
        String cadena;        
        int numFila = 0;
        
        while((cadena = reader.readLine()) != null) {
        	if (numFila == 0) {
        		Dimensiones dim = parseaEncabezados(cadena);
        		celdas = new Celda[dim.filas][dim.columnas];
        	} else {
        		celdas[numFila -1] = parsearFila(cadena);
        	}
        	numFila++;
        }
        return new Tablero(celdas);
	}

	public static Celda[] parsearFila(String cadena) {
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
	
	public static void agregarFila(Tablero tablero, int renglon, String cadena) {
		for (int i = 0; i < cadena.length(); i++) {
			char c = cadena.charAt(i);
			if (c == '*') {
				tablero.setMina(renglon, i);
			}
		}
	}
}
