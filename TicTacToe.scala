/* 
* Main program file for tic tac toe
* The game is run from the TicTacToe object
* The game class contains all necessary info to display
* a board, make a move, and call player or computer moves
*/



/*
* Code for computer players for Tic Tac Toe
* Includes both smart and dumb computers, if we 
* acutally want to implement both.
* I'm just leaving the dumb computer empty for now
*/



    class Game () {

        private var board = "012345678"
        private val player1 = 'X'
        private val player2 = 'O'

        // Might need to update to reflect accurate names

        def displayBoard() {
            println("   |   |   ")
            println(" " + board(0) + " | " + board(1) + " | " + board(2))
            println("   |   |   ")
            println("---|---|---")
            println("   |   |   ")
            println(" " + board(3) + " | " + board(4) + " | " + board(5))
            println("   |   |   ")
            println("---|---|---")
            println("   |   |   ")
            println(" " + board(6) + " | " + board(7) + " | " + board(8))
            println("   |   |   ")
        }

        // Both move functions should directly modify board
        def playerMove(move : Int) {
            // Move player onto position on 
            var myArray = board.split(board.charAt(move))
            //println(myArray.length)

            if(move <1) {
                board = "X" ++ myArray(0)
            }

            if(myArray.length  > 1){
                board = myArray(0) ++ "X" ++ myArray(1)
            } else {
                board = myArray(0) ++ "X"
            }
        }

        def computerMove() {
            //Run computer player functions here
            //println(board)

            var found = false
            for(x <- 0 to 8){
                if(!board.charAt(x).equals('O') && !board.charAt(x).equals('X') && !found){
                    found = true
                    var myArray = board.split(board.charAt(x))
                    
                    //println(myArray(0));
                    board = myArray(0) ++ "O" ++ myArray(1)
                    
                }
            }
            displayBoard();

        }

        def isValid(move: Int) : Boolean = {
            var validity = true

            if(move == 125){
                return false
            }

            if(move > 8){
                println("Invalid move")
                return false
            }

            if(board.charAt(move).equals('X') || board.charAt(move).equals('O') ) {
                println("Invalid move")
                return false
            }

            return validity;

        }

        // Return 1 if player won, 0 if game is still going, or -1 for draw
        def winner(player: Char): Int = {
            var isWinner = 0

            //horizontal lines
            if(board.charAt(0) == board.charAt(1) && board.charAt(1) == board.charAt(2) && board.charAt(2) == player) {isWinner = 1}
            if(board.charAt(3) == board.charAt(4) && board.charAt(4) == board.charAt(5) && board.charAt(5) == player) {isWinner = 1}
            if(board.charAt(6) == board.charAt(7) && board.charAt(7) == board.charAt(8) && board.charAt(8) == player) {isWinner = 1}

            //vertical lines
            if(board.charAt(0) == board.charAt(3) && board.charAt(3) == board.charAt(6) && board.charAt(6) == player) {isWinner = 1}
            if(board.charAt(1) == board.charAt(4) && board.charAt(4) == board.charAt(7) && board.charAt(7) == player) {isWinner = 1}
            if(board.charAt(2) == board.charAt(5) && board.charAt(5) == board.charAt(8) && board.charAt(8) == player) {isWinner = 1}

            //diagonal lines
            if(board.charAt(0) == board.charAt(4) && board.charAt(4) == board.charAt(8) && board.charAt(8) == player) {isWinner = 1}
            if(board.charAt(2) == board.charAt(4) && board.charAt(4) == board.charAt(6) && board.charAt(6) == player) {isWinner = 1}
            

            var isDraw = true;

            for( x <- 0 to 8){
                if(board.charAt(x).equals('0')) { isDraw = false}
                if(board.charAt(x) == '1') { isDraw = false}
                if(board.charAt(x) == '2') { isDraw = false}
                if(board.charAt(x) == '3') { isDraw = false}
                if(board.charAt(x) == '4') { isDraw = false}
                if(board.charAt(x) == '5') { isDraw = false}
                if(board.charAt(x) == '6') { isDraw = false}
                if(board.charAt(x) == '7') { isDraw = false}
                if(board.charAt(x) == '8') { isDraw = false}
            }

            if(isWinner != 1 && isDraw){ isWinner = -1}

            return isWinner
        }


        def run() {
            println("Let's Play!\n")
            displayBoard
            var gameOn = false
            if (winner(player1) != 1)  gameOn = true
            else gameOn = false

            while (gameOn) {
                //Play game
                var move = 125
                while(!isValid(move)){
                    println("Please make a move (0-8): ")
                    move = readInt
                } 
                playerMove(move)
                if (winner(player1) == 1) {
                    gameOn = false
                    println("Congrats! You won!")
                }
                else if (winner(player1) == -1) {
                    gameOn = false
                    println("It's a draw!")
                }
                else {
                    displayBoard
                    println("\nComputer's Turn!")
                    computerMove
                    if (winner(player2) == 1) {
                        gameOn = false
                        println("Oh no! You lose.")
                    } else if (winner(player2) == -1) {
                        gameOn = false
                        println("It's a draw!")
                    } else {
                        gameOn = true
                    }
                }

            }
        }
    }









    object TicTacToe {
        //Run game from here
        def main(args: Array[String]) {
            //Shouldn't need command line args
            println("Welcome to TicTacToe Easy Mode!!!");
            var thisGame = new Game()
            thisGame.run();
        }
    }

