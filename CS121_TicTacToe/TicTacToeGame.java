import java.awt.Point;

/**
 * This TicTacToeGame class provides all functionality for the tic tac toe game logic.
 * Provides functionality for a new game to be created, choosing a board piece, check for win condition state.
 * 
 * @author kyletruschel
 */

public class TicTacToeGame implements TicTacToe{
    // Instance variables
    private BoardChoice[][] arrayTicTacToe;
    private Point[] trackStatus;
    private BoardChoice lastChoice = BoardChoice.OPEN;
    private GameState gameConditionGameState;
    private int pointCounter = 0;

    // Constructor
    public TicTacToeGame() {
        newGame();
    }

    /**
     * @param newGame method will reset current game, such as the moves made,
     * resets player choice back to open, and starts the game as in progress.
     */
    @Override
    public void newGame() {
        arrayTicTacToe = new BoardChoice[3][3];

        // Make an array to keep track of moves made, only 9 are possible in TicTacToe before a tie
        trackStatus = new Point[9];
        pointCounter = 0;

        // Game is officially started
        gameConditionGameState = GameState.IN_PROGRESS;

        for (int row = 0; row < arrayTicTacToe.length; row++) {
            for (int col = 0; col < arrayTicTacToe[row].length; col++) {
                arrayTicTacToe[row][col] = BoardChoice.OPEN;  
            }
        }
        lastChoice = BoardChoice.OPEN;
    }

    /**
     * @param choose method will allow a board choice to be made as long as a legal move is allowed.
     * Checks five scenarios, if the selected board spot is open, if the last choice was the player (so the computer
     * has its turn), if the bounds for the row are between 0-2, if the columns are between 0-2, and if the game has not finished.
     */
    @Override
    public boolean choose(TicTacToe.BoardChoice player, int row, int col) {
        // Checks if the 2d array is occupied, if ok proceed
        if (arrayTicTacToe[row][col] != BoardChoice.OPEN) {
            return false;
        }
        // Checks if the player already made a move, if not proceed
        if (lastChoice == player) {
            return false;
        }
        // Checks bounds of the 2d array, since it is 3 by 3 its legal values
        // of row are 0-2 and col 0-2. If ok proceed
        if (row < 0 || row > 2) {
            return false;
        }
        if (col < 0 || col > 2) {
            return false;
        }
        // Checks the gameOver method, if ok proceed
        if (gameOver()) {
            return false;
        }

        else {
        // Assign the 2d array with the X or O value
        arrayTicTacToe[row][col] = player;

        // Update the trackStatus Point array with the current point/coordinate
        // Keeps in mind that only 9 points should be made for the 9 possible moves
        // So if (0, 1) is made, we can later incremenet the pointCounter for the first
        // Coordinate move.
        trackStatus[pointCounter] = new Point(row, col);

        // Increment point counter. Again, should not exceed 9 for possible moves.
        pointCounter++;

        // Now update the X choice player or O choice player
        lastChoice = player;

        return true;
        }
    }

    /**
     * @param gameOver will check conditions for a win or tie state. Checks if three rows, three columns, or a diagonal row has an X or O.
     * Also checks if points made is 9, which indicates maximum amount of moves in a game of tic tac toe.
     */
    @Override
    public boolean gameOver() {
        // For loop that will check rows
        for (int i = 0; i < arrayTicTacToe.length; i++) {
            if (arrayTicTacToe[i][0] == BoardChoice.O && arrayTicTacToe[i][1] == BoardChoice.O && arrayTicTacToe[i][2] == BoardChoice.O) {
                gameConditionGameState = GameState.O_WON;
                return true;
            }
            if (arrayTicTacToe[i][0] == BoardChoice.X && arrayTicTacToe[i][1] == BoardChoice.X && arrayTicTacToe[i][2] == BoardChoice.X) {
                gameConditionGameState = GameState.X_WON;
                return true;
            }
        }

        // For loop that will check columns
        for (int j = 0; j < arrayTicTacToe.length; j++) {
            if (arrayTicTacToe[0][j] == BoardChoice.O && arrayTicTacToe[1][j] == BoardChoice.O && arrayTicTacToe[2][j] == BoardChoice.O) {
                gameConditionGameState = GameState.O_WON;
                return true;
            }
            if (arrayTicTacToe[0][j] == BoardChoice.X && arrayTicTacToe[1][j] == BoardChoice.X && arrayTicTacToe[2][j] == BoardChoice.X) {
                gameConditionGameState = GameState.X_WON;
                return true;
            }
        }

        // Checks diagonal position for O's and if three in a row, O wins.
        if (arrayTicTacToe[0][0] == BoardChoice.O && arrayTicTacToe[1][1] == BoardChoice.O && arrayTicTacToe[2][2] == BoardChoice.O) {
            gameConditionGameState = GameState.O_WON;
            return true;
        }

        if (arrayTicTacToe[2][0] == BoardChoice.O && arrayTicTacToe[1][1] == BoardChoice.O && arrayTicTacToe[0][2] == BoardChoice.O) {
            gameConditionGameState = GameState.O_WON;
            return true;
        }

        // Checks diagonal position for X's and if three a row, X wins.
        if (arrayTicTacToe[0][0] == BoardChoice.X && arrayTicTacToe[1][1] == BoardChoice.X && arrayTicTacToe[2][2] == BoardChoice.X) {
            gameConditionGameState = GameState.X_WON;
            return true;
        }

        if (arrayTicTacToe[2][0] == BoardChoice.X && arrayTicTacToe[1][1] == BoardChoice.X && arrayTicTacToe[0][2] == BoardChoice.X) {
            gameConditionGameState = GameState.X_WON;
            return true;
        }

        // Check if max amount of moves have been made, then results in a tie.
        if (pointCounter == 9) {
            gameConditionGameState = GameState.TIE;
            return true;
        }

        return false;
    }

    /**
     * @param getGameState will return the game state, which can be in progress or a win.
     */
    @Override
    public TicTacToe.GameState getGameState() {
        gameOver();
        return gameConditionGameState;
    }

    /**
     * @param getGameGrid will return a copy of the current game grid, as a 2 dimensional array, as to not break incapsulation.
     */
    @Override
    public TicTacToe.BoardChoice[][] getGameGrid() {
        BoardChoice[][] copyArrayTicTacToe = new BoardChoice[3][3];

        for (int i = 0; i < arrayTicTacToe.length; i++) {
            for (int j = 0; j < arrayTicTacToe[i].length; j++) {
                copyArrayTicTacToe[i][j] = arrayTicTacToe[i][j];
            }
        }
        
        return copyArrayTicTacToe;
    }

    /**
     * @param getMoves will return a copy of the current moves array as to not break incapsulation.
     */
    @Override
    public Point[] getMoves() {
        Point[] copyTrackStatus = new Point[pointCounter];

        for (int i = 0; i < pointCounter; i++) {
            copyTrackStatus[i] = trackStatus[i];
        }

        return copyTrackStatus;
    }
}
