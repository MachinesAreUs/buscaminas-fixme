package com.coppel.buscaminas;

import java.nio.file.Files;
import java.nio.file.Paths;

public class BuscaMinasCmdLine {

	public static void main(String[] args) throws Exception {
		BuscaMinas juego = leerTablero(args[0]);
		juego.completarTablero();
		juego.imprimir();
	}

	private static BuscaMinas leerTablero(String rutaArchivo) throws Exception {
		String fileStr = new String(Files.readAllBytes(Paths.get(rutaArchivo)));
		return Parser.parse(fileStr);
	}
}
