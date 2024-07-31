package net.shawnklein.tic_tac_toe;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class BoardTests {

  @Test
	void classInstantiates() {
    String[] a = {" ", "X", "X", "X", "X", "X", "X", "X", "X"};
		Board b = new Board(a);

		assertEquals(net.shawnklein.tic_tac_toe.Board.class, b.getClass());
	}

  @Test
	void noEmptySpaces() {
    String[] a = {"O", "X", "X", "X", "X", "O", "X", "X", "O"};
		Board b = new Board(a);

		assertEquals(0, b.availableSpaces());
	}

  @Test
	void singleEmptySpace() {
    String[] a = {" ", "X", "X", "X", "X", "X", "X", "X", "X"};
		Board b = new Board(a);

		assertEquals(1, b.availableSpaces());
	}

  @Test
	void multipleEmptySpaces() {
    String[] a = {"X", "X", " ", " ", "X", "X", "X", " ", "X"};
		Board b = new Board(a);

		assertEquals(3, b.availableSpaces());
	}

  @Test
	void allEmptySpaces() {
    String[] a = {" ", " ", " ", " ", " ", " ", " ", " ", " "};
		Board b = new Board(a);

		assertEquals(9, b.availableSpaces());
	}

  @Test
	void gameIsActiveEmptyBoard() {
    String[] a = {" ", " ", " ", " ", " ", " ", " ", " ", " "};
		Board b = new Board(a);

		assertTrue( b.isActive());
	}

  @Test
	void gameIsActiveSingleOpening() {
    String[] a = {"X", "O", "X", "O", " ", "O", "X", "O", "X"};
		Board b = new Board(a);

		assertTrue(b.isActive());
	}

  @Test
	void gameIsActiveFullBoard() {
    String[] a = {"X", "X", "X", "X", "X", "X", "X", "X", "X"};
		Board b = new Board(a);

		assertFalse(b.isActive());
	}

  @Test 
	void getWinnerNone() {
    String[] a = {" ", " ", " ", " ", " ", " ", " ", " ", " "};
		Board b = new Board(a);

		assertEquals("n", b.getWinner());
	}

  @Test
	void getWinnerTop() {
    String[] a = {"X", "X", "X", " ", " ", " ", " ", " ", " "};
		Board b = new Board(a);

		assertEquals("X", b.getWinner());
	}

  @Test
	void getWinnerMid() {
    String[] a = {" ", " ", " ", "X", "X", "X", " ", " ", " "};
		Board b = new Board(a);

		assertEquals("X", b.getWinner());
	}

  @Test
	void getWinnerBot() {
    String[] a = {" ", " ", " ", " ", " ", " ", "X", "X", "X"};
		Board b = new Board(a);

		assertEquals("X", b.getWinner());
	}

  @Test
	void getWinnerLeft() {
    String[] a = {"X", " ", " ", "X", " ", " ", "X", " ", " "};
		Board b = new Board(a);

		assertEquals("X", b.getWinner());
	}
  
  @Test
	void getWinnerCentr() {
    String[] a = {" ", "X", " ", " ", "X", " ", " ", "X", " "};
		Board b = new Board(a);

		assertEquals("X", b.getWinner());
	}
  
  @Test
	void getWinnerRight() {
    String[] a = {" ", " ", "X", " ", " ", "X", " ", " ", "X"};
		Board b = new Board(a);

		assertEquals("X", b.getWinner());
	}

  @Test
	void getWinnerRCross() {
    String[] a = {"X", " ", " ", " ", "X", " ", " ", " ", "X"};
		Board b = new Board(a);

		assertEquals("X", b.getWinner());
	}

  @Test
	void getWinnerLCross() {
    String[] a = {" ", " ", "X", " ", "X", " ", "X", " ", " "};
		Board b = new Board(a);

		assertEquals("X", b.getWinner());
	}
}










// // returns boolean based on playable positions in board
// public boolean isFullBoard() {
//   for (String s : board) {
//     if (" ".equals(s)) { return false; }
//   }

//   return true;
// }





// public boolean isBlank(int i) {
//   return board[i].equals(" ");
// }

// public boolean pcWins() {
//   // TODO Auto-generated method stub
//   throw new UnsupportedOperationException("Unimplemented method 'pcWins'");
// }

// public void assign(int i, String string) {
//   // TODO Auto-generated method stub
//   throw new UnsupportedOperationException("Unimplemented method 'assign'");
// }