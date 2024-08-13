package net.shawnklein.tic_tac_toe;

import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class AppController {
  
  @GetMapping("/")
  public String app() {
    return "app.html";
  }


  @PostMapping("/")
  @ResponseBody
  public String playerTurn(@RequestParam char[] board) {
    JSONObject jo = new JSONObject();

    Board gameBoard = new Board(board, 'O', 'X');
    Opponent pc = new Opponent();
    Game game = new Game(gameBoard, pc);

    // check if player won game, pc turn if still active
    if (game.isActive()) {
      int position = game.playTurn();
      game.updateTurn(position);

      jo.put("position", position);
    }

    // check if pc or player won game and assign to JSON object
    jo.put("isActive", game.isActive());
    jo.put("winner", game.winner());
    
    return jo.toString(); 
  }

}
