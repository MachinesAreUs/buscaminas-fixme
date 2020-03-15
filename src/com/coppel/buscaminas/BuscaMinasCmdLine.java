package com.coppel.buscaminas;

import java.nio.file.Files;
import java.nio.file.Paths;

public class BuscaMinasCmdLine {

	public static void main(String[] args) throws Exception {
		BuscaMinas juego = leeJuegoDesdeArchivo(args[0]);
		juego.completaJuego();
		juego.imprime();
	}

	private static BuscaMinas leeJuegoDesdeArchivo(String rutaArchivo) throws Exception {
		String texto = new String(Files.readAllBytes(Paths.get(rutaArchivo)));
		return Parser.parsea(texto);
	}
}
