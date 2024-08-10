package net.shawnklein.tic_tac_toe;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class GameTests {

  @Test
	void classInstantiates() {
    String[] a = {" ", "X", "X", "X", "X", "X", "X", "X", "X"};
		Board board = new Board(a, "O", "X");
		Opponent pc = new Opponent();
		Game g = new Game(board, pc);

		assertEquals(net.shawnklein.tic_tac_toe.Game.class, g.getClass());
	}

  @Test
	void isActiveBlankBoard() {
    String[] a = {" ", " ", " ", " ", " ", " ", " ", " ", " "};
		Board board = new Board(a, "O", "X");
		Opponent pc = new Opponent();
		Game g = new Game(board, pc);

		assertTrue(g.isActive());
	}

	@Test
	void isActiveFullBoard() {
		String[] a = {"X", "X", "O", "O", "O", "X", "X", "X", "O"};
		Board board = new Board(a, "O", "X");
		Opponent pc = new Opponent();
		Game g = new Game(board, pc);

		assertFalse( g.isActive());
	}

	@Test
	void isActiveXWinsBoard() {
		String[] a = {"X", " ", "O", "O", "X", " ", "O", " ", "X"};
		Board board = new Board(a, "O", "X");
		Opponent pc = new Opponent();
		Game g = new Game(board, pc);

		assertFalse(g.isActive());
	}
  
	@Test
	void isActiveOWinsBoard() {
		String[] a = {"X", " ", "O", "O", "X", "O", " ", " ", "O"};
		Board board = new Board(a, "O", "X");
		Opponent pc = new Opponent();
		Game g = new Game(board, pc);

		assertFalse(g.isActive());
	}

	@Test
	void getWinnerXWinsBoard() {
		String[] a = {"X", " ", "O", "O", "X", " ", "O", " ", "X"};
		Board board = new Board(a, "O", "X");
		Opponent pc = new Opponent();
		Game g = new Game(board, pc);

		assertEquals("X", g.winner());
	}
  
	@Test
	void getWinnerOWinsBoard() {
		String[] a = {"X", " ", "O", "O", "X", "O", " ", " ", "O"};
		Board board = new Board(a, "O", "X");
		Opponent pc = new Opponent();
		Game g = new Game(board, pc);

		assertEquals("O", g.winner());
	}

	@Test
	void playTurnDefFrontBoard() {
		String[] a = {" ", " ", " ", " ", "X", "O", " ", "X", " "};
		Board board = new Board(a, "O", "X");
		Opponent pc = new Opponent();
		Game g = new Game(board, pc);

		assertEquals(1, g.playTurn());
	}

	@Test
	void playTurnDefMidBoard() {
		String[] a = {" ", " ", "X", " ", " ", " ", " ", " ", "X"};
		Board board = new Board(a, "O", "X");
		Opponent pc = new Opponent();
		Game g = new Game(board, pc);

		assertEquals(5, g.playTurn());
	}

	@Test
	void playTurnDefEndBoard() {
		String[] a = {"X", " ", " ", " ", "X", "O", " ", " ", " "};
		Board board = new Board(a, "O", "X");
		Opponent pc = new Opponent();
		Game g = new Game(board, pc);

		assertEquals(8, g.playTurn());
	}

	@Test
	void playTurnWinFrontBoard() {
		String[] a = {"X", " ", " ", " ", "O", "O", " ", "O", " "};
		Board board = new Board(a, "O", "X");
		Opponent pc = new Opponent();
		Game g = new Game(board, pc);

		assertEquals(1, g.playTurn());
	}

	@Test
	void playTurnWinMidBoard() {
		String[] a = {"O", " ", " ", " ", "X", " ", "O", " ", " "};
		Board board = new Board(a, "O", "X");
		Opponent pc = new Opponent();
		Game g = new Game(board, pc);

		assertEquals(3, g.playTurn());
	}

	@Test
	void updateTurnBoard() {
		String[] a = {"O", " ", " ", " ", "X", " ", "O", " ", " "};
		Board board = new Board(a, "O", "X");
		Opponent pc = new Opponent();
		Game g = new Game(board, pc);

		assertTrue(g.isActive());
		g.updateTurn(3);
		assertFalse(g.isActive());
	}


}
