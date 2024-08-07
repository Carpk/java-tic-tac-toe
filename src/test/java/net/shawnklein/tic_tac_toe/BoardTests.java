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
		Board b = new Board(a, "O", "X");

		assertEquals(net.shawnklein.tic_tac_toe.Board.class, b.getClass());
	}

	@Test
	void cloneBoard() {
    String[] a = {"O", "X", "X", "X", "X", "O", "X", "X", "O"};
		Board b = new Board(a, "O", "X");
		Board c = b.clone();

		assertTrue( b != c);
	}


  @Test
	void noEmptySpaces() {
    String[] a = {"O", "X", "X", "X", "X", "O", "X", "X", "O"};
		Board b = new Board(a, "O", "X");

		assertEquals(0, b.availableSpaces());
	}

  @Test
	void singleEmptySpace() {
    String[] a = {"O", "X", "X", "X", "X", "X", " ", "X", "X"};
		Board b = new Board(a, "O", "X");

		assertEquals(1, b.availableSpaces());
	}

  @Test
	void multipleEmptySpaces() {
    String[] a = {"X", "X", " ", " ", "X", "X", "X", " ", "X"};
		Board b = new Board(a, "O", "X");

		assertEquals(3, b.availableSpaces());
	}

  @Test
	void allEmptySpaces() {
    String[] a = {" ", " ", " ", " ", " ", " ", " ", " ", " "};
		Board b = new Board(a, "O", "X");

		assertEquals(9, b.availableSpaces());
	}

  @Test
	void gameIsActiveEmptyBoard() {
    String[] a = {" ", " ", " ", " ", " ", " ", " ", " ", " "};
		Board b = new Board(a, "O", "X");

		assertTrue( b.isActive());
	}

  @Test
	void gameIsActiveSingleOpening() {
    String[] a = {"X", "O", "X", "O", " ", "O", "X", "O", "X"};
		Board b = new Board(a, "O", "X");

		assertTrue(b.isActive());
	}

  @Test
	void gameIsActiveFullTiedBoard() {
    String[] a = {"X", "X", "O", "O", "O", "X", "X", "X", "O"};
		Board b = new Board(a, "O", "X");

		assertFalse(b.isActive());
	}

	@Test
	void gameIsActiveDiagWon() {
    String[] a = {"X", " ", " ", " ", "X", " ", " ", " ", "X"};
		Board b = new Board(a, "O", "X");

		assertFalse(b.isActive());
	}

	@Test
	void gameIsActiveBottomWon() {
    String[] a = {" ", " ", " ", " ", " ", " ", "O", "O", "O"};
		Board b = new Board(a, "O", "X");

		assertFalse(b.isActive());
	}

	@Test
	void IsFullBeingFull() {
    String[] a = {"X", "X", "O", "O", "O", "X", "X", "X", "O"};
		Board b = new Board(a, "O", "X");

		assertTrue(b.isFull());
	}


	@Test
	void IsFullOneOpen() {
    String[] a = {"X", "X", "O", "O", " ", "X", "X", "X", "O"};
		Board b = new Board(a, "O", "X");

		assertFalse(b.isFull());
	}

	@Test
	void IsFullFrontOpen() {
    String[] a = {" ", "X", "O", "O", "X", "X", "X", "X", "O"};
		Board b = new Board(a, "O", "X");

		assertFalse(b.isFull());
	}

	@Test
	void IsFullEndOpen() {
    String[] a = {"X", "X", "O", "O", "O", "X", "X", "X", " "};
		Board b = new Board(a, "O", "X");

		assertFalse(b.isFull());
	}

	@Test
	void IsFullAllOpen() {
    String[] a = {" ", " ", " ", " ", " ", " ", " ", " ", " "};
		Board b = new Board(a, "O", "X");

		assertFalse(b.isFull());
	}

	@Test
	void IsFullBottomWin() {
    String[] a = {" ", " ", " ", " ", " ", " ", "O", "O", "O"};
		Board b = new Board(a, "O", "X");

		assertFalse(b.isFull());
	}

  @Test 
	void getWinnerNone() {
    String[] a = {" ", " ", " ", " ", " ", " ", " ", " ", " "};
		Board b = new Board(a, "O", "X");

		assertEquals("n", b.getWinner());
	}

  @Test
	void getWinnerTop() {
    String[] a = {"X", "X", "X", " ", " ", " ", " ", " ", " "};
		Board b = new Board(a, "O", "X");

		assertEquals("X", b.getWinner());
	}

  @Test
	void getWinnerMid() {
    String[] a = {" ", " ", " ", "X", "X", "X", " ", " ", " "};
		Board b = new Board(a, "O", "X");

		assertEquals("X", b.getWinner());
	}

  @Test
	void getWinnerBot() {
    String[] a = {" ", " ", " ", " ", " ", " ", "X", "X", "X"};
		Board b = new Board(a, "O", "X");

		assertEquals("X", b.getWinner());
	}

  @Test
	void getWinnerLeft() {
    String[] a = {"X", " ", " ", "X", " ", " ", "X", " ", " "};
		Board b = new Board(a, "O", "X");

		assertEquals("X", b.getWinner());
	}
  
  @Test
	void getWinnerCentr() {
    String[] a = {" ", "X", " ", " ", "X", " ", " ", "X", " "};
		Board b = new Board(a, "O", "X");

		assertEquals("X", b.getWinner());
	}
  
  @Test
	void getWinnerRight() {
    String[] a = {" ", " ", "X", " ", " ", "X", " ", " ", "X"};
		Board b = new Board(a, "O", "X");

		assertEquals("X", b.getWinner());
	}

  @Test
	void getWinnerRCross() {
    String[] a = {"X", " ", " ", " ", "X", " ", " ", " ", "X"};
		Board b = new Board(a, "O", "X");

		assertEquals("X", b.getWinner());
	}

  @Test
	void getWinnerLCross() {
    String[] a = {" ", " ", "X", " ", "X", " ", "X", " ", " "};
		Board b = new Board(a, "O", "X");

		assertEquals("X", b.getWinner());
	}


	@Test
	void isAnyMatchEmpty() {
    String[] a = {" ", " ", " ", " ", " ", " ", " ", " ", " "};
		Board b = new Board(a, "O", "X");

		assertFalse( b.isAnyMatch());
	}

	@Test
	void isAnyMatchTie() {
    String[] a = {"X", "X", "O", "O", "O", "X", "X", "X", "O"};
		Board b = new Board(a, "O", "X");

		assertFalse( b.isAnyMatch());
	}

  @Test
	void isAnyMatchWithWin() {
    String[] a = {" ", " ", "X", " ", "X", " ", "X", " ", " "};
		Board b = new Board(a, "O", "X");

		assertTrue( b.isAnyMatch());
	}

  @Test
	void isBlankWithBlanks() {
    String[] a = {" ", " ", "X", " ", "X", " ", "X", " ", " "};
		Board b = new Board(a, "O", "X");

		assertTrue( b.isBlank(1));
	}

  @Test
	void isBlankLastOneBlank() {
    String[] a = {"X", "X", "O", "O", "O", "X", "X", "X", " "};
		Board b = new Board(a, "O", "X");

		assertTrue( b.isBlank(8));
	}


  @Test
	void isBlankFirstOneBlank() {
    String[] a = {" ", "X", "O", "O", "O", "X", "X", "X", "O"};
		Board b = new Board(a, "O", "X");

		assertTrue( b.isBlank(0));
	}

  @Test
	void isBlankNotBlank() {
    String[] a = {" ", " ", " ", " ", " ", " ", "X", " ", " "};
		Board b = new Board(a, "O", "X");

		assertFalse( b.isBlank(6));
	}


  @Test
	void pcWinsDoesWin() {
    String[] a = {" ", " ", "X", "O", "O", "O", "X", " ", " "};
		Board b = new Board(a, "O", "X");

		assertTrue( b.pcWins());
	}

  @Test
	void pcWinsNoWinner() {
    String[] a = {" ", " ", "X", "O", " ", "O", "X", " ", " "};
		Board b = new Board(a, "O", "X");

		assertFalse( b.pcWins());
	}

  @Test
	void pcWinsPlayerWins() {
    String[] a = {"O", " ", "X", " ", "X", " ", "X", " ", "O"};
		Board b = new Board(a, "O", "X");

		assertFalse( b.pcWins());
	}

  @Test
	void huWinsDoesWin() {
    String[] a = {" ", " ", "X", "O", "X", "O", "X", " ", " "};
		Board b = new Board(a, "O", "X");

		assertTrue( b.huWins());
	}

  @Test
	void huWinsNoWinner() {
    String[] a = {" ", " ", "X", "O", " ", "O", "X", " ", " "};
		Board b = new Board(a, "O", "X");

		assertFalse( b.huWins());
	}

  @Test
	void huWinsButHuWins() {
    String[] a = {"X", " ", "O", " ", "O", " ", "O", " ", "X"};
		Board b = new Board(a, "O", "X");

		assertFalse( b.huWins());
	}


  @Test
	void assignMidToken() {
    String[] a = {"X", " ", " ", " ", " ", " ", " ", " ", "X"};
		Board b = new Board(a, "O", "X");

		assertFalse( b.huWins() );
		b.assign(4, "X");
		assertTrue( b.huWins() );
	}

	@Test
	void assignFrontToken() {
    String[] a = {" ", "X", "X", " ", " ", " ", " ", " ", " "};
		Board b = new Board(a, "O", "X");

		assertFalse( b.huWins() );
		b.assign(0, "X");
		assertTrue( b.huWins() );
	}

	@Test
	void assignEndToken() {
    String[] a = {"X", " ", " ", " ", "X", " ", " ", " ", " "};
		Board b = new Board(a, "O", "X");

		assertFalse( b.huWins() );
		b.assign(8, "X");
		assertTrue( b.huWins() );
	}

  @Test
	void openIndicesAllOpen() {
    String[] a = {" ", " ", " ", " ", " ", " ", " ", " ", " "};
		Board b = new Board(a, "O", "X");
		List<Integer> c = Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8);
		List<Integer> d = b.openIndices();

		System.out.println(d);

		assertTrue( c.equals(d) );
	}

  @Test
	void openIndicesOneOpen() {
    String[] a = {"X", "X", "X", " ", "X", "X", "X", "X", "X"};
		Board b = new Board(a, "O", "X");
		List<Integer> c = Arrays.asList( 3);
		List<Integer> d = b.openIndices();

		assertTrue( c.equals(d) );
	}

	@Test
	void openIndicesSomeOpen() {
    String[] a = {"X", " ", "X", " ", "X", " ", "X", "X", " "};
		Board b = new Board(a, "O", "X");
		List<Integer> c = Arrays.asList(1, 3, 5, 8);
		List<Integer> d = b.openIndices();

		assertTrue( c.equals(d) );
	}

	 

}
