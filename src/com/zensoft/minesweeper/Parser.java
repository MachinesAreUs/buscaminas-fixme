package com.zensoft.minesweeper;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Parser {
	
	public static MineSweeper parse(String str) {
		List<String> lines = new LinkedList<String>(Arrays.asList(str.split("\n")));

		Dimensions dims = parseHeaders(lines.get(0).trim());
		Cell[][] cells = new Cell[dims.rows][dims.cols];
		
		lines.remove(0);
		
		for (int numRow = 0; numRow < dims.rows; numRow++) {
			cells[numRow] = parseRow(lines.get(numRow).trim());
		}
		return new MineSweeper(cells);
	}

	public static Cell[] parseRow(String str) {
		Cell[] row = new Cell[str.length()];
		for (int i = 0; i < str.length(); i++) {
			Cell cell = new Cell();
			char c = str.charAt(i);
			if (c == '*') {
				cell.setMine(true);
			}
			row[i] = cell;
		}
		return row;
	}

	public static Dimensions parseHeaders(String str) {
		String[] dims = str.split(" ");
		int rows = Integer.parseInt(dims[0]);
		int cols = Integer.parseInt(dims[1]);
		return new Dimensions(rows, cols);
	}
	
	public static class Dimensions {

		public int rows;
		public int cols;
		
		public Dimensions(int rows, int cols) {
			this.rows = rows;
			this.cols = cols;
		}
	}
}
