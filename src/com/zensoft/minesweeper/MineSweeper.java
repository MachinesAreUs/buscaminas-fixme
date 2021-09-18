package com.zensoft.minesweeper;

import java.util.ArrayList;
import java.util.List;

public class MineSweeper {

	public int rows;
	public int cols;
	
	Cell cells[][];

	public MineSweeper(Cell[][] cells) {
		this.cells = cells;
		this.rows = cells.length;
		this.cols = cells[0].length;
	}

	public void completeBoard() {
		for (int i = 0; i < rows; i++) {			
			for (int j = 0; j < cols; j++) {
				Cell cell = cells[i][j];
				if (!cell.isMine()) {
					assignNeighboringMines(i, j);
				}
			}
		}
	}

	private void assignNeighboringMines(int i, int j) {		
		List<Cell> neighbors = getNeighbours(i, j);
		int mines = countMines(neighbors);
		cells[i][j].setNeighboringMines(mines);					
	}

	private int countMines(List<Cell> cells) {
		int count = 0;
		for (Cell cell : cells) {
			if (cell.isMine())
				count++;
		}
		return count;
	}

	private List<Cell> getNeighbours(int i, int j) {
		List<Cell> neighbors = new ArrayList<Cell>();
		for (int iNeighbor = i-1; iNeighbor <= i+1; iNeighbor++) {
			for (int jNeighbor = j-1; jNeighbor <= j+1; jNeighbor++ ) {
				if (isWithinLimits(iNeighbor, jNeighbor) && !sameCell(i, j, iNeighbor, jNeighbor)) {
					neighbors.add(cells[iNeighbor][jNeighbor]);
				}
			}
		}
		return neighbors;
	}
	
	private boolean sameCell(int i, int j, int iNeighbor, int jNeighbor) {
		return iNeighbor == i && jNeighbor == j;
	}
	
	private boolean isWithinLimits(int i, int j) {
		return isValidRow(i) && isValidColumn(j); 
	}

	private boolean isValidRow(int i) {
		return i >= 0 && i < rows;
	}
	
	private boolean isValidColumn(int j) {
		return j >= 0 && j < cols;
	}
	
	public void print() {
		System.out.println(this.toString());
	}
	
	public String toString() {
		StringBuffer sb = new StringBuffer();
		
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				Cell celda = cells[i][j];
				if (celda.isMine()) {
					sb.append('*');
				} else {
					sb.append(celda.getNeighboringMines());
				}
			}
			sb.append('\n');
		}
		return sb.toString();
	}
}
