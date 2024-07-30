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

}







// // method to return boolean 
// // set instance var if winner available
// public String winner() {
//   return " ";
// }


// // returns boolean based on playable positions in board
// public boolean isFullBoard() {
//   for (String s : board) {
//     if (" ".equals(s)) { return false; }
//   }

//   return true;
// }

// // possibly change these to return common character
// public boolean isColMatch() {
//   boolean a = !board[0].equals(" ") && board[0].equals(board[3]) && board[0].equals(board[6]);
//   boolean b = !board[1].equals(" ") && board[1].equals(board[4]) && board[1].equals(board[7]);
//   boolean c = !board[2].equals(" ") && board[2].equals(board[5]) && board[2].equals(board[8]);

//   return a || b || c;
// }

// public boolean isRowMatch() {
//   String top = board[0];
//   String mid = board[3];
//   String bot = board[6];

//   boolean a = !top.equals(" ") && top.equals(board[1]) && top.equals(board[2]);
//   boolean b = !mid.equals(" ") && mid.equals(board[4]) && mid.equals(board[5]);
//   boolean c = !bot.equals(" ") && bot.equals(board[7]) && bot.equals(board[8]);

//   return a || b || c;
// }

// public boolean isDiagMatch() {
//   boolean a = !board[0].equals(" ") && board[0].equals(board[4]) && board[0].equals(board[8]);
//   boolean b = !board[2].equals(" ") && board[2].equals(board[4]) && board[2].equals(board[6]);

//   return a || b;
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