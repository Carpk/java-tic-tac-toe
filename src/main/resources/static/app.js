

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
        .done(function( data ) {
          console.log( data );

          // { winner: "O", position: "0", isActive: "f" }

          if (data.winner == 'X') {
            console.log( "X is WINNER!");

          } else if (data.winner == 'O') {
            $("#" + data.position ).text( "O").css("color", "red");          
            boardArray[data.position] = "O"; 

            console.log( "O is WINNER!");
          } else if(data.isActive == 'f') {
            console.log( "TIE GAME!");
          } else {
            $("#" + data.position ).text( "O").css("color", "red");
            boardArray[data.position] = "O"; 

            playerTurn = true;
          }


        });
    }



  } );

  


  // function displayPlayerTurn(id) {
  //   var txt = $( this ).html();
  //   $("#"+id ).text = txt;
  // }




});






