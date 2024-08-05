package net.shawnklein.tic_tac_toe;


public class Game {
  Board board;
  Opponent pc;

  public Game(Board gameboard, Opponent opp) {
    board = gameboard;
    pc = opp;
  }


  // returns boolen if game is in playable state
  public String isActive() {
    // need to check for winning positions
    if (board.isActive()) {
      return "t";
    }

    return "f";
  }

  // return winner of game
  public String winner() {
    return board.getWinner();
  }


  // returns computer choosen position
  public int playTurn() {    
    return pc.play(board);
  }














}
