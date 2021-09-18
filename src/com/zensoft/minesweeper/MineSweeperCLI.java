package com.zensoft.minesweeper;

import java.nio.file.Files;
import java.nio.file.Paths;

public class MineSweeperCLI {

	public static void main(String[] args) throws Exception {
		MineSweeper game = fromFile(args[0]);
		game.completeBoard();
		game.print();
	}

	private static MineSweeper fromFile(String filePath) throws Exception {
		String text = new String(Files.readAllBytes(Paths.get(filePath)));
		return Parser.parse(text);
	}
}
