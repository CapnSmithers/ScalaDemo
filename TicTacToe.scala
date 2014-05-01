/* 
* Main program file for tic tac toe
* The game is run from the TicTacToe object
* The game class contains all necessary info to display
* a board, make a move, and call player or computer moves
*/

import ComputerPlayers

class Game () {

    private var board = "012345678"
    private val player1 = "Human"
    private val player2 = "Computer"

    // Might need to update to reflect accurate names
    private val computer = ComputerPlayers.SmartComputer()

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
    def playerMove(move: Int, player: String) {
        // Move player onto position on board
    }

    def computerMove() {
        //Run computer player functions here
    }

    // Return 1 if player won, 0 if game is still going, or -1 for draw
    def winner(player: String) {

    }

    def run() {
        println("Let's Play!\n")
        displayBoard
        var gameOn =
            if (!winner(player1)) True
            else False

        while (gameOn) {
            //Play game
            println("Please make a move (0-8): ")
            val move = readInt
            playerMove(move)
            if (winner(player1) == 1) {
                gameOn = False
                println("Congrats! You won!")
            }
            else if (winner(player1) == -1) {
                gameOn = False
                println("It's a draw!")
            }
            else {
                displayBoard
                println("\nComputer's Turn!")
                computerMove
                if (winner(player2)) {
                    gameOn = False
                    println("Oh no! You lose.")
                } else if (winner(player2) == -1) {
                    gameOn = False
                    println("It's a draw!")
                } else {
                    gameOn = True
                }
            }

        }
    }
}

object TicTacToe {
    //Run game from here
    def main(args: Array[String]) {
        //Shouldn't need command line args
    }
}