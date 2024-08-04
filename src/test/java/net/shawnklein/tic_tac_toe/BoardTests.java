package net.shawnklein.tic_tac_toe;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.List;

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
	void cloneBoard() {
    String[] a = {"O", "X", "X", "X", "X", "O", "X", "X", "O"};
		Board b = new Board(a);
		Board c = b.clone();

		assertTrue( b != c);
	}


  @Test
	void noEmptySpaces() {
    String[] a = {"O", "X", "X", "X", "X", "O", "X", "X", "O"};
		Board b = new Board(a);

		assertEquals(0, b.availableSpaces());
	}

  @Test
	void singleEmptySpace() {
    String[] a = {"O", "X", "X", "X", "X", "X", " ", "X", "X"};
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
	void gameIsActiveFullTiedBoard() {
    String[] a = {"X", "X", "O", "O", "O", "X", "X", "X", "O"};
		Board b = new Board(a);

		assertFalse(b.isActive());
	}

	@Test
	void gameIsActiveDiagWon() {
    String[] a = {"X", " ", " ", " ", "X", " ", " ", " ", "X"};
		Board b = new Board(a);

		assertFalse(b.isActive());
	}

	@Test
	void gameIsActiveBottomWon() {
    String[] a = {" ", " ", " ", " ", " ", " ", "O", "O", "O"};
		Board b = new Board(a);

		assertFalse(b.isActive());
	}

	@Test
	void IsFullBeingFull() {
    String[] a = {"X", "X", "O", "O", "O", "X", "X", "X", "O"};
		Board b = new Board(a);

		assertTrue(b.isFull());
	}


	@Test
	void IsFullOneOpen() {
    String[] a = {"X", "X", "O", "O", " ", "X", "X", "X", "O"};
		Board b = new Board(a);

		assertFalse(b.isFull());
	}

	@Test
	void IsFullFrontOpen() {
    String[] a = {" ", "X", "O", "O", "X", "X", "X", "X", "O"};
		Board b = new Board(a);

		assertFalse(b.isFull());
	}

	@Test
	void IsFullEndOpen() {
    String[] a = {"X", "X", "O", "O", "O", "X", "X", "X", " "};
		Board b = new Board(a);

		assertFalse(b.isFull());
	}

	@Test
	void IsFullAllOpen() {
    String[] a = {" ", " ", " ", " ", " ", " ", " ", " ", " "};
		Board b = new Board(a);

		assertFalse(b.isFull());
	}

	@Test
	void IsFullBottomWin() {
    String[] a = {" ", " ", " ", " ", " ", " ", "O", "O", "O"};
		Board b = new Board(a);

		assertFalse(b.isFull());
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


	@Test
	void isAnyMatchEmpty() {
    String[] a = {" ", " ", " ", " ", " ", " ", " ", " ", " "};
		Board b = new Board(a);

		assertFalse( b.isAnyMatch());
	}

	@Test
	void isAnyMatchTie() {
    String[] a = {"X", "X", "O", "O", "O", "X", "X", "X", "O"};
		Board b = new Board(a);

		assertFalse( b.isAnyMatch());
	}

  @Test
	void isAnyMatchWithWin() {
    String[] a = {" ", " ", "X", " ", "X", " ", "X", " ", " "};
		Board b = new Board(a);

		assertTrue( b.isAnyMatch());
	}

  @Test
	void isBlankWithBlanks() {
    String[] a = {" ", " ", "X", " ", "X", " ", "X", " ", " "};
		Board b = new Board(a);

		assertTrue( b.isBlank(1));
	}

  @Test
	void isBlankLastOneBlank() {
    String[] a = {"X", "X", "O", "O", "O", "X", "X", "X", " "};
		Board b = new Board(a);

		assertTrue( b.isBlank(8));
	}


  @Test
	void isBlankFirstOneBlank() {
    String[] a = {" ", "X", "O", "O", "O", "X", "X", "X", "O"};
		Board b = new Board(a);

		assertTrue( b.isBlank(0));
	}

  @Test
	void isBlankNotBlank() {
    String[] a = {" ", " ", " ", " ", " ", " ", "X", " ", " "};
		Board b = new Board(a);

		assertFalse( b.isBlank(6));
	}


  @Test
	void pcWinsDoesWin() {
    String[] a = {" ", " ", "X", "O", "O", "O", "X", " ", " "};
		Board b = new Board(a);

		assertTrue( b.pcWins());
	}

  @Test
	void pcWinsNoWinner() {
    String[] a = {" ", " ", "X", "O", " ", "O", "X", " ", " "};
		Board b = new Board(a);

		assertFalse( b.pcWins());
	}

  @Test
	void pcWinsPlayerWins() {
    String[] a = {"O", " ", "X", " ", "X", " ", "X", " ", "O"};
		Board b = new Board(a);

		assertFalse( b.pcWins());
	}

  @Test
	void huWinsDoesWin() {
    String[] a = {" ", " ", "X", "O", "X", "O", "X", " ", " "};
		Board b = new Board(a);

		assertTrue( b.huWins());
	}

  @Test
	void huWinsNoWinner() {
    String[] a = {" ", " ", "X", "O", " ", "O", "X", " ", " "};
		Board b = new Board(a);

		assertFalse( b.huWins());
	}

  @Test
	void huWinsButHuWins() {
    String[] a = {"X", " ", "O", " ", "O", " ", "O", " ", "X"};
		Board b = new Board(a);

		assertFalse( b.huWins());
	}


  @Test
	void assignMidToken() {
    String[] a = {"X", " ", " ", " ", " ", " ", " ", " ", "X"};
		Board b = new Board(a);

		assertFalse( b.huWins() );
		b.assign(4, "X");
		assertTrue( b.huWins() );
	}

  @Test
	void openIndicesWithOne() {
    String[] a = {"X", " ", " ", " ", " ", " ", " ", " ", "X"};
		Board b = new Board(a);
		List<Integer> c = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
		List<Integer> d = b.openIndices();

		assertTrue( c.equals(d) );
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