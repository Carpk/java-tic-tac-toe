

// Shorthand for $( document ).ready()
$(function() {
  playerTurn = true;
  boardArray = [ " ", " ", " ", " ", " ", " ", " ", " ", " "];

  $( ".box" ).on( "click", function() {


    if (playerTurn & boardArray[this.id] == " "){
      boardArray[this.id] = "X";
      $("#"+this.id ).text( "X");


      $.post( "/", { 'board[]': boardArray, 'id': 3 });




      // $.post( "ajax/turn", function( data ) {
      //   // $( ".result" ).html( data );
      //   console.log(data);
      // });
    }



  } );

  



  // function displayPlayerTurn(id) {
  //   var txt = $( this ).html();
  //   $("#"+id ).text = txt;
  // }














});






