package net.shawnklein.tic_tac_toe;

import static org.junit.jupiter.api.Assertions.assertEquals;
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

		assertEquals("t", g.isActive());
	}

	@Test
	void isActiveFullBoard() {
		String[] a = {"X", "X", "O", "O", "O", "X", "X", "X", "O"};
		Board board = new Board(a, "O", "X");
		Opponent pc = new Opponent();
		Game g = new Game(board, pc);

		assertEquals("f", g.isActive());
	}

	@Test
	void isActiveXWinsBoard() {
		String[] a = {"X", " ", "O", "O", "X", " ", "O", " ", "X"};
		Board board = new Board(a, "O", "X");
		Opponent pc = new Opponent();
		Game g = new Game(board, pc);

		assertEquals("f", g.isActive());
	}
  
}



// // return winner of game
// public String winner() {
// 	return board.getWinner();
// }


// // returns computer choosen position
// public int playTurn() {    
// 	return pc.play(board);
// }

// public void updateTurn(int i) {
// 	board.assignPc(i);
// }
