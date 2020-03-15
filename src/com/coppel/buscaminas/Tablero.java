package com.coppel.buscaminas;

import java.util.ArrayList;
import java.util.List;

public class Tablero {

	public int filas;
	public int columnas;
	
	Celda arrayCeldas[][];

	public Tablero(Celda[][] celdas) {
		this.arrayCeldas = celdas;
	}
	
	public Tablero(int filas, int columnas) {
		this.filas = filas;
		this.columnas = columnas;
		inicializarCeldas();
	}
	
	private void inicializarCeldas() {
		arrayCeldas = new Celda[filas][columnas];
		for (int i = 0; i < filas; i++) {
			for (int j = 0; j < columnas; j++) {
				arrayCeldas[i][j] = new Celda();
			}
		}
	}
	
	public void agregarFila(int renglon, String cadena) {
		for (int i = 0; i < columnas; i++) {
			char c = cadena.charAt(i);
			if (c == '*') {
				setMina(renglon, i);
			}
		}
	}
	
	public void setMina(int fila, int columna) {
		arrayCeldas[fila][columna].setMina(true);
	}

	public void completarTablero() throws Exception{
		for (int i = 0; i < filas; i++) {			
			for (int j = 0; j < columnas; j++) {
				Celda celda = arrayCeldas[i][j];
				if (!celda.isMina()) {
					asignarNumMinasVecinas(i, j);
				}
			}
		}
	}

	private void asignarNumMinasVecinas(int i, int j) {		
		List<Celda> vecinos = obtenerVecinos(i, j);
		int suma = contarMinas(vecinos);
		arrayCeldas[i][j].setMinasVecinos(suma);					
	}

	private int contarMinas(List<Celda> celdas) {
		int suma = 0;
		for (Celda vecino : celdas) {
			if (vecino.isMina())
				suma++;
		}
		return suma;
	}

	private List<Celda> obtenerVecinos(int i, int j) {
		List<Celda> vecinos = new ArrayList<Celda>();
		for (int ivecino = i-1; ivecino <= i+1; ivecino++) {
			for (int jvecino = j-1; jvecino <= j+1; jvecino++ ) {
				if (fronterasValidas(ivecino, jvecino) && !yoMismo(i, j, ivecino, jvecino)) {
					vecinos.add(arrayCeldas[ivecino][jvecino]);
				}
			}
		}
		return vecinos;
	}
	
	private boolean yoMismo(int i, int j, int ivecino, int jvecino) {
		return ivecino == i && jvecino == j;
	}
	
	private boolean fronterasValidas(int i, int j) {
		return filaValida(i) && columnaValida(j); 
	}

	private boolean filaValida(int i) {
		return i >= 0 && i < filas;
	}
	
	private boolean columnaValida(int j) {
		return j >= 0 && j < columnas;
	}
	
	public void imprimir() {
		System.out.println(this.toString());
	}
	
	public String toString() {
		StringBuffer sb = new StringBuffer();
		
		for (int i = 0; i<filas; i++) {
			for (int j=0; j<columnas; j++) {
				Celda celda = arrayCeldas[i][j];
				if (celda.isMina) {
					sb.append('*');
				} else {
					sb.append(celda.getVecinos());
				}
			}
			sb.append('\n');
		}
		return sb.toString();
	}
}
