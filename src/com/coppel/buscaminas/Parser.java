package com.coppel.buscaminas;

import java.io.BufferedReader;
import java.io.StringReader;

public class Parser {

	public static Tablero parse(String str) throws Exception {
		BufferedReader reader = new BufferedReader(new StringReader(str));
		
        String cadena;
        Tablero tablero = new Tablero();
        int fila = 0;
        while((cadena = reader.readLine()) != null) {
        	if (fila == 0) {
        		String[] datos = cadena.split(" ");
        		int filas = Integer.parseInt(datos[0]);
        		int columnas = Integer.parseInt(datos[1]);
        		tablero.inicializar(filas, columnas);
        	}else {
        		agregarFila(tablero, fila - 1, cadena);
        	}
        	fila++;
        }
        return tablero;
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
