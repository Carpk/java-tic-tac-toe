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
    char[] a = {' ', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X'};
		Board b = new Board(a, 'O', 'X');

		assertEquals(net.shawnklein.tic_tac_toe.Board.class, b.getClass());
	}

	@Test
	void cloneBoard() {
    char[] a = {'O', 'X', 'X', 'X', 'X', 'O', 'X', 'X', 'O'};
		Board b = new Board(a, 'O', 'X');
		Board c = b.clone();

		assertTrue( b != c);
	}


  @Test
	void noEmptySpaces() {
    char[] a = {'O', 'X', 'X', 'X', 'X', 'O', 'X', 'X', 'O'};
		Board b = new Board(a, 'O', 'X');

		assertEquals(0, b.availableSpaces());
	}

  @Test
	void singleEmptySpace() {
    char[] a = {'O', 'X', 'X', 'X', 'X', 'X', ' ', 'X', 'X'};
		Board b = new Board(a, 'O', 'X');

		assertEquals(1, b.availableSpaces());
	}

  @Test
	void multipleEmptySpaces() {
    char[] a = {'X', 'X', ' ', ' ', 'X', 'X', 'X', ' ', 'X'};
		Board b = new Board(a, 'O', 'X');

		assertEquals(3, b.availableSpaces());
	}

  @Test
	void allEmptySpaces() {
    char[] a = {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '};
		Board b = new Board(a, 'O', 'X');

		assertEquals(9, b.availableSpaces());
	}

  @Test
	void gameIsActiveEmptyBoard() {
    char[] a = {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '};
		Board b = new Board(a, 'O', 'X');

		assertTrue( b.isActive());
	}

  @Test
	void gameIsActiveSingleOpening() {
    char[] a = {'X', 'O', 'X', 'O', ' ', 'O', 'X', 'O', 'X'};
		Board b = new Board(a, 'O', 'X');

		assertTrue(b.isActive());
	}

  @Test
	void gameIsActiveFullTiedBoard() {
    char[] a = {'X', 'X', 'O', 'O', 'O', 'X', 'X', 'X', 'O'};
		Board b = new Board(a, 'O', 'X');

		assertFalse(b.isActive());
	}

	@Test
	void gameIsActiveDiagWon() {
    char[] a = {'X', ' ', ' ', ' ', 'X', ' ', ' ', ' ', 'X'};
		Board b = new Board(a, 'O', 'X');

		assertFalse(b.isActive());
	}

	@Test
	void gameIsActiveBottomWon() {
    char[] a = {' ', ' ', ' ', ' ', ' ', ' ', 'O', 'O', 'O'};
		Board b = new Board(a, 'O', 'X');

		assertFalse(b.isActive());
	}

	@Test
	void IsFullBeingFull() {
    char[] a = {'X', 'X', 'O', 'O', 'O', 'X', 'X', 'X', 'O'};
		Board b = new Board(a, 'O', 'X');

		assertTrue(b.isFull());
	}


	@Test
	void IsFullOneOpen() {
    char[] a = {'X', 'X', 'O', 'O', ' ', 'X', 'X', 'X', 'O'};
		Board b = new Board(a, 'O', 'X');

		assertFalse(b.isFull());
	}

	@Test
	void IsFullFrontOpen() {
    char[] a = {' ', 'X', 'O', 'O', 'X', 'X', 'X', 'X', 'O'};
		Board b = new Board(a, 'O', 'X');

		assertFalse(b.isFull());
	}

	@Test
	void IsFullEndOpen() {
    char[] a = {'X', 'X', 'O', 'O', 'O', 'X', 'X', 'X', ' '};
		Board b = new Board(a, 'O', 'X');

		assertFalse(b.isFull());
	}

	@Test
	void IsFullAllOpen() {
    char[] a = {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '};
		Board b = new Board(a, 'O', 'X');

		assertFalse(b.isFull());
	}

	@Test
	void IsFullBottomWin() {
    char[] a = {' ', ' ', ' ', ' ', ' ', ' ', 'O', 'O', 'O'};
		Board b = new Board(a, 'O', 'X');

		assertFalse(b.isFull());
	}

  @Test 
	void getWinnerNone() {
    char[] a = {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '};
		Board b = new Board(a, 'O', 'X');

		assertEquals('n', b.getWinner());
	}

  @Test
	void getWinnerTop() {
    char[] a = {'X', 'X', 'X', ' ', ' ', ' ', ' ', ' ', ' '};
		Board b = new Board(a, 'O', 'X');

		assertEquals('X', b.getWinner());
	}

  @Test
	void getWinnerMid() {
    char[] a = {' ', ' ', ' ', 'X', 'X', 'X', ' ', ' ', ' '};
		Board b = new Board(a, 'O', 'X');

		assertEquals('X', b.getWinner());
	}

  @Test
	void getWinnerBot() {
    char[] a = {' ', ' ', ' ', ' ', ' ', ' ', 'X', 'X', 'X'};
		Board b = new Board(a, 'O', 'X');

		assertEquals('X', b.getWinner());
	}

  @Test
	void getWinnerLeft() {
    char[] a = {'X', ' ', ' ', 'X', ' ', ' ', 'X', ' ', ' '};
		Board b = new Board(a, 'O', 'X');

		assertEquals('X', b.getWinner());
	}
  
  @Test
	void getWinnerCentr() {
    char[] a = {' ', 'X', ' ', ' ', 'X', ' ', ' ', 'X', ' '};
		Board b = new Board(a, 'O', 'X');

		assertEquals('X', b.getWinner());
	}
  
  @Test
	void getWinnerRight() {
    char[] a = {' ', ' ', 'X', ' ', ' ', 'X', ' ', ' ', 'X'};
		Board b = new Board(a, 'O', 'X');

		assertEquals('X', b.getWinner());
	}

  @Test
	void getWinnerRCross() {
    char[] a = {'X', ' ', ' ', ' ', 'X', ' ', ' ', ' ', 'X'};
		Board b = new Board(a, 'O', 'X');

		assertEquals('X', b.getWinner());
	}

  @Test
	void getWinnerLCross() {
    char[] a = {' ', ' ', 'X', ' ', 'X', ' ', 'X', ' ', ' '};
		Board b = new Board(a, 'O', 'X');

		assertEquals('X', b.getWinner());
	}


	@Test
	void isAnyMatchEmpty() {
    char[] a = {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '};
		Board b = new Board(a, 'O', 'X');

		assertFalse( b.isAnyMatch());
	}

	@Test
	void isAnyMatchTie() {
    char[] a = {'X', 'X', 'O', 'O', 'O', 'X', 'X', 'X', 'O'};
		Board b = new Board(a, 'O', 'X');

		assertFalse( b.isAnyMatch());
	}

  @Test
	void isAnyMatchWithWin() {
    char[] a = {' ', ' ', 'X', ' ', 'X', ' ', 'X', ' ', ' '};
		Board b = new Board(a, 'O', 'X');

		assertTrue( b.isAnyMatch());
	}

  @Test
	void isBlankWithBlanks() {
    char[] a = {' ', ' ', 'X', ' ', 'X', ' ', 'X', ' ', ' '};
		Board b = new Board(a, 'O', 'X');

		assertTrue( b.isBlank(1));
	}

  @Test
	void isBlankLastOneBlank() {
    char[] a = {'X', 'X', 'O', 'O', 'O', 'X', 'X', 'X', ' '};
		Board b = new Board(a, 'O', 'X');

		assertTrue( b.isBlank(8));
	}


  @Test
	void isBlankFirstOneBlank() {
    char[] a = {' ', 'X', 'O', 'O', 'O', 'X', 'X', 'X', 'O'};
		Board b = new Board(a, 'O', 'X');

		assertTrue( b.isBlank(0));
	}

  @Test
	void isBlankNotBlank() {
    char[] a = {' ', ' ', ' ', ' ', ' ', ' ', 'X', ' ', ' '};
		Board b = new Board(a, 'O', 'X');

		assertFalse( b.isBlank(6));
	}


  @Test
	void pcWinsDoesWin() {
    char[] a = {' ', ' ', 'X', 'O', 'O', 'O', 'X', ' ', ' '};
		Board b = new Board(a, 'O', 'X');

		assertTrue( b.pcWins());
	}

  @Test
	void pcWinsNoWinner() {
    char[] a = {' ', ' ', 'X', 'O', ' ', 'O', 'X', ' ', ' '};
		Board b = new Board(a, 'O', 'X');

		assertFalse( b.pcWins());
	}

  @Test
	void pcWinsPlayerWins() {
    char[] a = {'O', ' ', 'X', ' ', 'X', ' ', 'X', ' ', 'O'};
		Board b = new Board(a, 'O', 'X');

		assertFalse( b.pcWins());
	}

  @Test
	void huWinsDoesWin() {
    char[] a = {' ', ' ', 'X', 'O', 'X', 'O', 'X', ' ', ' '};
		Board b = new Board(a, 'O', 'X');

		assertTrue( b.huWins());
	}

  @Test
	void huWinsNoWinner() {
    char[] a = {' ', ' ', 'X', 'O', ' ', 'O', 'X', ' ', ' '};
		Board b = new Board(a, 'O', 'X');

		assertFalse( b.huWins());
	}

  @Test
	void huWinsButHuWins() {
    char[] a = {'X', ' ', 'O', ' ', 'O', ' ', 'O', ' ', 'X'};
		Board b = new Board(a, 'O', 'X');

		assertFalse( b.huWins());
	}


  @Test
	void assignMidToken() {
    char[] a = {'X', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X'};
		Board b = new Board(a, 'O', 'X');

		assertFalse( b.huWins() );
		b.assignHu(4);
		assertTrue( b.huWins() );
	}

	@Test
	void assignFrontToken() {
    char[] a = {' ', 'X', 'X', ' ', ' ', ' ', ' ', ' ', ' '};
		Board b = new Board(a, 'O', 'X');

		assertFalse( b.huWins() );
		b.assignHu(0);
		assertTrue( b.huWins() );
	}

	@Test
	void assignEndHuToken() {
    char[] a = {'X', ' ', ' ', ' ', 'X', ' ', ' ', ' ', ' '};
		Board b = new Board(a, 'O', 'X');

		assertFalse( b.huWins() );
		b.assignHu(8);
		assertTrue( b.huWins() );
	}


	@Test
	void assignEndPcToken() {
    char[] a = {'O', ' ', ' ', ' ', 'O', ' ', ' ', ' ', ' '};
		Board b = new Board(a, 'O', 'X');

		assertFalse( b.huWins() );
		b.assignPc(8);
		assertTrue( b.pcWins() );
	}

	@Test
	void assignFrontPcToken() {
    char[] a = {' ', 'O', 'O', ' ', 'O', ' ', ' ', ' ', ' '};
		Board b = new Board(a, 'O', 'X');

		assertFalse( b.huWins() );
		b.assignPc(0);
		assertTrue( b.pcWins() );
	}

	@Test
	void assignMidPcToken() {
    char[] a = {' ', 'O', ' ', ' ', ' ', ' ', ' ', 'O', ' '};
		Board b = new Board(a, 'O', 'X');

		assertFalse( b.huWins() );
		b.assignPc(4);
		assertTrue( b.pcWins() );
	}



  @Test
	void openIndicesAllOpen() {
    char[] a = {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '};
		Board b = new Board(a, 'O', 'X');
		List<Integer> c = Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8);
		List<Integer> d = b.openIndices();

		assertTrue( c.equals(d) );
	}

  @Test
	void openIndicesOneOpen() {
    char[] a = {'X', 'X', 'X', ' ', 'X', 'X', 'X', 'X', 'X'};
		Board b = new Board(a, 'O', 'X');
		List<Integer> c = Arrays.asList( 3);
		List<Integer> d = b.openIndices();

		assertTrue( c.equals(d) );
	}

	@Test
	void openIndicesSomeOpen() {
    char[] a = {'X', ' ', 'X', ' ', 'X', ' ', 'X', 'X', ' '};
		Board b = new Board(a, 'O', 'X');
		List<Integer> c = Arrays.asList(1, 3, 5, 8);
		List<Integer> d = b.openIndices();

		assertTrue( c.equals(d) );
	}

	 

}
