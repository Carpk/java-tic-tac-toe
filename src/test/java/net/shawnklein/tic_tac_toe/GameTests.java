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
		Game g = new Game(a);

		assertEquals(net.shawnklein.tic_tac_toe.Game.class, g.getClass());
	}



  
}
