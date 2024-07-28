

// Shorthand for $( document ).ready()
$(function() {
  playerTurn = true;
  boardArray = [ " ", " ", " ", " ", " ", " ", " ", " ", " "];

  $( ".box" ).on( "click", function() {


    if (playerTurn & boardArray[this.id] == " "){
      boardArray[this.id] = "X";
      $("#"+this.id ).text( "X");

      $.post( "/", { 'board[]': boardArray })
        .done(function( data ) {
          console.log( data );
          $("#"+data ).text( "O");
          boardArray[data] = "O";
        });





    }



  } );

  



  // function displayPlayerTurn(id) {
  //   var txt = $( this ).html();
  //   $("#"+id ).text = txt;
  // }














});






