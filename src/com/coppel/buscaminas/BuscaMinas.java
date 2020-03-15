package com.coppel.buscaminas;

import java.util.ArrayList;
import java.util.List;

public class BuscaMinas {

	public int filas;
	public int columnas;
	
	Celda celdas[][];

	public BuscaMinas(Celda[][] celdas) {
		this.celdas = celdas;
		this.filas = celdas.length;
		this.columnas = celdas[0].length;
	}

	public void completaJuego() throws Exception{
		for (int i = 0; i < filas; i++) {			
			for (int j = 0; j < columnas; j++) {
				Celda celda = celdas[i][j];
				if (!celda.isMina()) {
					asignaNumMinasVecinas(i, j);
				}
			}
		}
	}

	private void asignaNumMinasVecinas(int i, int j) {		
		List<Celda> vecinos = obtenVecinos(i, j);
		int suma = cuentaMinas(vecinos);
		celdas[i][j].setMinasVecinos(suma);					
	}

	private int cuentaMinas(List<Celda> celdas) {
		int suma = 0;
		for (Celda vecino : celdas) {
			if (vecino.isMina())
				suma++;
		}
		return suma;
	}

	private List<Celda> obtenVecinos(int i, int j) {
		List<Celda> vecinos = new ArrayList<Celda>();
		for (int ivecino = i-1; ivecino <= i+1; ivecino++) {
			for (int jvecino = j-1; jvecino <= j+1; jvecino++ ) {
				if (fronterasValidas(ivecino, jvecino) && !yoMismo(i, j, ivecino, jvecino)) {
					vecinos.add(celdas[ivecino][jvecino]);
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
	
	public void imprime() {
		System.out.println(this.toString());
	}
	
	public String toString() {
		StringBuffer sb = new StringBuffer();
		
		for (int i = 0; i<filas; i++) {
			for (int j=0; j<columnas; j++) {
				Celda celda = celdas[i][j];
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
