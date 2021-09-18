package com.zensoft.minesweeper;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class ParserTest {

	@Test
	public void parseRowWithoutMines() {
		Cell[] row = Parser.parseRow("....");
		
		assertEquals(4, row.length);
		
		for (Cell cell : row) {
			assertFalse(cell.isMine());
		}
	}
	
	@Test
	public void parseRowWithAllMines() {
		Cell[] row = Parser.parseRow("****");
		
		assertEquals(4, row.length);
		
		for (Cell cell : row) {
			assertTrue(cell.isMine());
		}
	}
	
	@Test
	public void parseRowWithInterleavedMines() {
		Cell[] row = Parser.parseRow("*.*.");
		
		assertEquals(4, row.length);
		
		assertTrue(row[0].isMine());
		assertFalse(row[1].isMine());
		assertTrue(row[2].isMine());
		assertFalse(row[3].isMine());
	}
	
	@Test
	public void parseHeaders() {
		Parser.Dimensions dim = Parser.parseHeaders("10 20");
	
		assertEquals(10, dim.rows);
		assertEquals(20, dim.cols);
	}
}
