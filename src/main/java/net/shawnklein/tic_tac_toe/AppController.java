package net.shawnklein.tic_tac_toe;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.ResponseEntity;
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
  public Map<String, String> playerTurn(@RequestParam String[] board) {
    Map<String, String> map = new HashMap<>();
    
    Board gameBoard = new Board(board);
    Opponent pc = new Opponent();
    Game game = new Game(gameBoard, pc);
    

    if (game.isActive() == "t") {
      int position = game.playTurn();
      map.put("position", String.valueOf(position));
    }
    

    // need to update board with new position to verify win
    map.put("isActive", game.isActive());
    map.put("winner", game.winner());
     
  
    return map; 
  }

}
