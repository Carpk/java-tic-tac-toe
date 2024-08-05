

// Shorthand for $( document ).ready()
$(function() {
  playerTurn = true;
  boardArray = [ " ", " ", " ", " ", " ", " ", " ", " ", " "];

  $( ".box" ).on( "click", function() {


    if (playerTurn & boardArray[this.id] == " "){
      playerTurn = false;
      boardArray[this.id] = "X";
      $("#"+this.id ).text( "X").css("color", "blue");

      $.post( "/", { 'board[]': boardArray })
        .done(function( data ) {
          console.log( data );

          if (data.winner == 'O') {

          } else if (data.isActive == 't') {
            $("#"+data.position ).text( "O").css("color", "red");          
            boardArray[data.position] = "O";
          }


        });
        playerTurn = true;
    }



  } );

  


  // function displayPlayerTurn(id) {
  //   var txt = $( this ).html();
  //   $("#"+id ).text = txt;
  // }




});






