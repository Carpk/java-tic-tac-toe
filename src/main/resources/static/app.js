

// Shorthand for $( document ).ready()
$(function() {
  playerTurn = true;
  boardArray = [ " ", " ", " ", " ", " ", " ", " ", " ", " "];

  $( ".box" ).on( "click", function() {
    if (playerTurn & boardArray[this.id] == " "){
      playerTurn = false;
      boardArray[this.id] = "X";
      $("#"+ this.id ).text( "X").css("color", "blue");

      $.post( "/", { 'board[]': boardArray })
        .done(function( response ) {
          var data = JSON.parse(response);
          console.log( data );

          // { winner: "O", position: "0", isActive: "f" }
          if (data.winner == "X") {
            $("#x-win").show();
            $("#reset").show();
            console.log( "X is WINNER!");

          } else if (data.winner == 'O') {
            $("#o-win").show();
            $("#reset").show();
            $("#" + data.position ).text( "O").css("color", "red");          
            boardArray[data.position] = "O"; 

            console.log( "O is WINNER!");
          } else if( !data.isActive ) {
            $("#tie-game").show();
            $("#reset").show();
            console.log( "TIE GAME!");
          } else {
            $("#" + data.position ).text( "O").css("color", "red");
            boardArray[data.position] = "O"; 

            playerTurn = true;
          }

        });
    }



  } );


  $( "#reset" ).on( "click", function() {
    window.location.reload();
  });


});






