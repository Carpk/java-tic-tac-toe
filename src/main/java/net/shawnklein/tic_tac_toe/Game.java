package net.shawnklein.tic_tac_toe;


public class Game {
  Board board;

  public Game(String[] gameboard) {
    board = new Board(gameboard);
  }



  public boolean isActive() {
    // need to check for winning positions
    return board.isActive();
  }

  public int playTurn() {
    board.isColMatch();
    
    Opponent pc = new Opponent();




    return 3;
  }














}
