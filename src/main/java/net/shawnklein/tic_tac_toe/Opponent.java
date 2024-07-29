package net.shawnklein.tic_tac_toe;

public class Opponent {



  public Opponent() {

  }



  // manages the ai algorithm
  // returns suggsted position
  public int play(Board board) {
    int pos = 0;
    int max = -9;

    for (int i = 0; i < 9; i++) {
        if (board.isBlank(i)) {
            int nextplay = 0; //opp play
            if (max < nextplay) {
              pos = i; 
            }
        }
    }

    return pos;
  }

  public void takeTurn() {

  }
  


}
