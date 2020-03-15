package com.coppel.buscaminas;

public class Celda {
	
	public boolean isMina;
	public int minasVecinas = 0;
	
	/**
	 * @return the isMina
	 */
	public boolean isMina() {
		return isMina;
	}
	/**
	 * @param isMina the isMina to set
	 */
	public void setMina(boolean isMina) {
		this.isMina = isMina;
	}
	/**
	 * @return the valor
	 */
	public int getVecinos() {
		return minasVecinas;
	}
	/**
	 * @param valor the valor to set
	 */
	public void setMinasVecinos(int valor) {
		this.minasVecinas = valor;
	}
}
