package net.shawnklein.tic_tac_toe;

import java.util.HashMap;
import java.util.Map;

import org.json.JSONObject;
import org.springframework.boot.jackson.JsonObjectSerializer;
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
  public String playerTurn(@RequestParam String[] board) {
    // Map<String, String> map = new HashMap<>();
    JSONObject jo = new JSONObject();

    Board gameBoard = new Board(board, "O", "X");
    Opponent pc = new Opponent();
    Game game = new Game(gameBoard, pc);
    

    if (game.isActive()) {
      int position = game.playTurn();
      game.updateTurn(position);

      jo.put("position", position);
      // map.put("position", String.valueOf(position));
    }

    jo.put("isActive", game.isActive());
    jo.put("winner", game.winner());
    // map.put("isActive", game.isActive());
    // map.put("winner", game.winner());
    
    return jo.toString(); 
  }

}
