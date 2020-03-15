package com.coppel.buscaminas;

import java.nio.file.Files;
import java.nio.file.Paths;

public class BuscaMinas {

	public static void main(String[] args) throws Exception {
		Tablero tablero = leerTablero(args[0]);
		tablero.completarTablero();
		tablero.imprimir();
	}

	private static Tablero leerTablero(String rutaArchivo) throws Exception {
		String fileStr = new String(Files.readAllBytes(Paths.get(rutaArchivo)));
		return Parser.parse(fileStr);
	}
}
