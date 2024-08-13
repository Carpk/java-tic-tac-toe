package net.shawnklein.tic_tac_toe;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class OpponentTests {

  @Test
	void classInstantiates() {
		Opponent opp = new Opponent();

		assertEquals(net.shawnklein.tic_tac_toe.Opponent.class, opp.getClass());
	}


  @Test
	void playOneOpenSpotBoard() {
		Opponent opp = new Opponent();
    char[] a = {'X', 'O', ' ', 'X', 'X', 'O', 'O', 'X', 'O'};
    Board b = new Board(a, 'O', 'X');

		assertEquals(2, opp.play(b));
	}


	@Test
	void minmaxTwoOpenEasyTwoSpotWin() {
		Opponent opp = new Opponent();
    char[] a = {'X', 'O', ' ', 'X', 'O', 'X', ' ', 'X', 'O'};  // test isAnyMatch
    Board b = new Board(a, 'O', 'X');

		assertEquals(6, opp.play(b));
	}

	@Test
	void minmaxTwoOpenEasyFourSpotWin() {
		Opponent opp = new Opponent();
    char[] a = {'O', ' ', ' ', 'X', ' ', 'X', ' ', 'O', 'O'};
    Board b = new Board(a, 'O', 'X');

		assertEquals(4, opp.play(b));
	}


	@Test
	void minmaxTopDefAssignment() {
		Opponent opp = new Opponent();
    char[] a = {'X', 'X', ' ', 'O', ' ', 'X', ' ', 'O', ' '};
    Board b = new Board(a, 'O', 'X');

		assertEquals(2, opp.play(b));
	}

	@Test
	void minmaxMidDefAssignment() {
		Opponent opp = new Opponent();
    char[] a = {'O', ' ', ' ', ' ', ' ', 'X', 'X', ' ', 'O'};
    Board b = new Board(a, 'O', 'X');

		assertEquals(4, opp.play(b));
	}

	@Test
	void minmaxBotDefAssignment() {
		Opponent opp = new Opponent();
    char[] a = {'O', ' ', ' ', ' ', ' ', 'O', 'X', ' ', 'X'};
    Board b = new Board(a, 'O', 'X');

		assertEquals(7, opp.play(b));
	}

	@Test
	void minmaxPlay() {
		Opponent opp = new Opponent();
    char[] a = {'O', ' ', ' ', 'X', 'X', ' ', ' ', ' ', ' '};
    Board b = new Board(a, 'O', 'X');

		assertEquals(5, opp.play(b));
	}

	@Test
	void boardValueTie() {
		Opponent opp = new Opponent();
    char[] a = {'O', 'O', 'X', 'X', 'X', 'O', 'O', 'O', 'X'};
    Board b = new Board(a, 'O', 'X');

		assertEquals(0, opp.boardValue(b));
	}

	@Test
	void boardValueXWin() {
		Opponent opp = new Opponent();
    char[] a = {'X', 'O', 'X', 'X', 'X', 'O', 'O', 'O', 'X'};
    Board b = new Board(a, 'O', 'X');

		assertEquals(-128, opp.boardValue(b));
	}

	@Test
	void boardValueOWin() {
		Opponent opp = new Opponent();
    char[] a = {'O', 'O', 'X', 'O', 'X', 'O', 'O', 'O', 'X'};
    Board b = new Board(a, 'O', 'X');

		assertEquals(128, opp.boardValue(b));
	}

	@Test
	void minimaxBlank() {
		Opponent opp = new Opponent();
    char[] a = {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '};
    Board b = new Board(a, 'O', 'X');

		assertEquals(0, opp.minimax(b, 0, true));
	}

	@Test
	void minimaxPcWinnerBoard() {
		Opponent opp = new Opponent();
    char[] a = {'O', 'O', 'O', ' ', ' ', ' ', ' ', ' ', ' '};
    Board b = new Board(a, 'O', 'X');

		assertEquals(128, opp.minimax(b, 0, true));
	}

	@Test
	void minimaxHuWinnerBoard() {
		Opponent opp = new Opponent();
    char[] a = {'X', ' ', ' ', ' ', 'X', ' ', ' ', ' ', 'X'};
    Board b = new Board(a, 'O', 'X');

		assertEquals(-128, opp.minimax(b, 0, false));
	}

	@Test
	void minimaxOneSpaceWin() {
		Opponent opp = new Opponent();
    char[] a = {'O', 'O', ' ', ' ', ' ', ' ', ' ', ' ', ' '};
    Board b = new Board(a, 'O', 'X');

		assertEquals(64, opp.minimax(b, 0, true));
	}

	// @Test
	// void minimaxTwoSpaceWin() {
	// 	Opponent opp = new Opponent();
  //   String[] a = {"O", " ", " ", " ", " ", "X", " ", "X", " "};
  //   Board b = new Board(a);

	// 	assertEquals(32, opp.minimax(b, 0, true));
	// }
}
