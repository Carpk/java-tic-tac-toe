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
  public ResponseEntity<String> playerTurn(@RequestParam String[] board) {
    // public Map<Integer, String, Boolean> playerTurn(@RequestParam String[] board) {
    Map<String, Character> map = new HashMap<>();
    Game gameState = new Game(board);
    
    // did player win?
    boolean playTurn = gameState.isActive();

    if (playTurn) {
      int position = gameState.playTurn();
      // did pc win?
    } else {
      String winner = "X"; 
    }
     
  

    // did pc win?

     // front end needs pc position, know if game is over, and who is winner
   
    map.put("position", '3');
    map.put("winner", 'n');
    map.put("isActive", 't');
    // return map; 

    return ResponseEntity.ok("3");
  }

}
