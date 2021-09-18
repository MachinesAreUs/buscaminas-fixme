package com.zensoft.minesweeper;

public class Cell {
	
	public boolean isMine;
	public int neighboringMines = 0;
	
	/**
	 * @return the isMina
	 */
	public boolean isMine() {
		return isMine;
	}
	
	/**
	 * @param isMine the isMina to set
	 */
	public void setMine(boolean isMine) {
		this.isMine = isMine;
	}
	
	/**
	 * @return the num of neighboring mines
	 */
	public int getNeighboringMines() {
		return neighboringMines;
	}
	
	/**
	 * @param valor The 
	 */
	public void setNeighboringMines(int valor) {
		this.neighboringMines = valor;
	}
}
