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
    String[] a = {"X", "O", " ", "X", "X", "O", "O", "X", "O"};
    Board b = new Board(a);

		assertEquals(2, opp.play(b));
	}


	@Test
	void minmaxTwoOpenEasyWin() {
		Opponent opp = new Opponent();
    String[] a = {"X", "O", " ", "X", "X", "O", " ", "X", "O"};
    Board b = new Board(a);

		assertEquals(6, opp.play(b));
	}
}
