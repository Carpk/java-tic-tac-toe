package net.shawnklein.tic_tac_toe;

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

    Game gameState = new Game(board);
    
    // did player win?
    boolean playTurn = gameState.isActive();

    if (playTurn) {
      int position = gameState.playTurn();
    } else {
      String winner = "X"; 
    }
     
    


    // did pc win?

    return ResponseEntity.ok("3");
  }

}
