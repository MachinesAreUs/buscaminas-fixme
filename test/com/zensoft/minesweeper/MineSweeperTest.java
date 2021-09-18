package com.zensoft.minesweeper;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class MineSweeperTest {
	
	@Test
	public void simpleBoard() {
		String boardStr =
				"4 4\n" +
				"*...\n" +
				"....\n" +
				".*..\n" +
				"....\n";
		
		MineSweeper game = Parser.parse(boardStr);
		game.completeBoard();

		String expectedBoardStr = 
				"*100\n" +
				"2210\n" +
				"1*10\n" +
				"1110\n";
		
		assertEquals(expectedBoardStr, game.toString());
	}
	
	@Test
	public void averageBoard() {
		String boardStr =
				"4 5\n" +
				"*....\n" +
				"....*\n" +
				".*..;\n" +
				".....\n";
		
		MineSweeper game = Parser.parse(boardStr);
		game.completeBoard();

		String expectedBoard = 
				"*1011\n" +
				"2211*\n" +
				"1*111\n" +
				"11100\n";
		
		assertEquals(expectedBoard, game.toString());
	}
}
