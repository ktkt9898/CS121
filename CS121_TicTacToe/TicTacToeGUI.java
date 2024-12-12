import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import java.util.Random;
import java.awt.Font;

/**
 * This class contains all variables, constructors, and methods for the purpose of creating an interactive GUI
 * for a Tic Tac Toe game. Depends on the TicTacToeGame class for game logic.
 * Also functions as the driver class.
 * 
 * @author kyletruschel
 */

public class TicTacToeGUI extends JPanel {
    // Instance variables
    private Button[][] arrayTicTacToe = new Button[3][3];
    private TicTacToeGame gameTicTacToe;
    private TicTacToe.BoardChoice currentPlayer;
    private Random randomChoice = new Random();
    private Color colorDarkGreen = new Color(0, 100, 0);

    // Instance variables for buttons and text
    private JPanel panelButtonGrid;
    private JPanel panelEast; // East control panel, holds move history
    private JPanel panelWest; // West control panel, holds the player choice buttons
    private JPanel panelSouth; // South control panel, holds reset game
    private JPanel panelNorth; // North control panel, indicates player turn
    private Button buttonPlacePiece;
    private JButton selectChoiceX = new JButton("Choose X");
    private JButton selectChoiceO = new JButton("Choose O");
    private JButton buttonReset = new JButton("New Game");
    private JLabel labelMoves = new JLabel("Move History");
    private JLabel labelPlayerMove = new JLabel(" ");

    // Constructors
    public TicTacToeGUI() {
        // Create a new TicTacToeGame object to inherit the TicTacToeGame
        // instance variables, constructors, and methods
        gameTicTacToe = new TicTacToeGame();

        // When game starts, the current player choice is open, similar to null
        currentPlayer = TicTacToe.BoardChoice.OPEN;

        // Add action listeners to buttons to allow functionality
        buttonReset.addActionListener(new ButtonListener());
        buttonReset.setName("Reset"); // Set "New Game" to Reset for action listener later on
        selectChoiceX.addActionListener(new ButtonListener());
        selectChoiceO.addActionListener(new ButtonListener());

        // Set up initial 3x3 grid as a pnael
        panelButtonGrid = new JPanel();
        panelButtonGrid.setLayout(new GridLayout(3, 3));

        // Populate the 3x3 panel grid with buttons
        for (int i = 0; i < arrayTicTacToe.length; i++) {
            for (int j = 0; j < arrayTicTacToe[i].length; j++) {
                buttonPlacePiece = new Button(i, j);
                buttonPlacePiece.setPreferredSize(new Dimension(100, 100));

                // Add functionality to the buttons to be an action
                // listener
                buttonPlacePiece.addActionListener(new ButtonListener());

                // Buttons will appear as invisible by setting name to
                // be " "
                buttonPlacePiece.setName(" ");
                buttonPlacePiece.setFont(new Font("Arial", 2, 25));
                buttonPlacePiece.setBackground(colorDarkGreen);
                // buttonPlacePiece.setColor(Color.GREEN);
                arrayTicTacToe[i][j] = buttonPlacePiece;

                // Now add this populated 3x3 grid to the panel...
                panelButtonGrid.add(arrayTicTacToe[i][j]);
            }
        }

        // North, South, East, West, Center Layout
        this.setLayout(new BorderLayout());

        // North panel
        panelNorth = new JPanel();
        panelNorth.setBackground(Color.RED);
        panelNorth.add(labelPlayerMove);
        this.add(panelNorth, BorderLayout.NORTH);

        // Center panel, adds the populated 3x3 grid to the GUI
        this.add(panelButtonGrid, BorderLayout.CENTER);

        // East panel, contains move history
        panelEast = new JPanel();
        panelEast.setBackground(Color.RED);
        labelMoves.setBorder(new EmptyBorder(0, 50, 0 ,50));
        panelEast.setLayout(new BoxLayout(panelEast, BoxLayout.Y_AXIS));
        panelEast.add(labelMoves);
        this.add(panelEast, BorderLayout.EAST);

        // West panel, contains player selection choice
        panelWest = new JPanel();
        panelWest.setBackground(Color.RED);
        panelWest.add(selectChoiceX);
        panelWest.add(selectChoiceO);
        this.add(panelWest, BorderLayout.WEST);

        // South panel, contains reset button
        panelSouth = new JPanel();
        panelSouth.setBackground(Color.RED);
        panelSouth.add(buttonReset);
        this.add(panelSouth, BorderLayout.SOUTH);
    }

    // Action Listener for all buttons
    private class ButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            JButton button = (JButton) e.getSource();

            // Action Listener for the new game button
            if (button.getName() == "Reset") {
                // Call the newGame method from TicTacToeGame
                gameTicTacToe.newGame();

                // Also ensure a reset of the current 3x3 grid
                for (int i = 0; i < arrayTicTacToe.length; i++) {
                    for (int j = 0; j < arrayTicTacToe[i].length; j++) {
                        arrayTicTacToe[i][j].setText(" ");
                        arrayTicTacToe[i][j].setEnabled(true);
                    }
                }

                // Also ensure a reset of the moves
                panelEast.removeAll();
                panelEast.revalidate();
                panelEast.repaint();
                panelEast.add(labelMoves);

                panelNorth.removeAll();
                panelNorth.revalidate();
                panelNorth.repaint();
                labelPlayerMove = new JLabel(" ");
                panelNorth.add(labelPlayerMove);

                selectChoiceX.setEnabled(true);
                selectChoiceO.setEnabled(true);
            }

            // Action Listener for the tic tac toe game board
            if (button.getName() == " ") {
                if (currentPlayer == TicTacToe.BoardChoice.X) {
                    Button buttonChoice = (Button) e.getSource();
                    buttonChoice.getRow();
                    buttonChoice.getCol();

                    // Testing Purpose
                    // System.out.println("Row " + buttonChoice.getRow());

                    // Testing Purpose
                    // System.out.println("Col " + buttonChoice.getCol());

                    // Pass in the choose method from TicTacToeGame and take in the currentPlayer,
                    // row, and col
                    // Current player is inherited/borrowed from TicTacToeGame which itself is type
                    // BoardChoice.X initially
                    // Row and Col are inherited variables from the Button class that retrieves the
                    // x and y coordinates of the array position
                    if (gameTicTacToe.choose(currentPlayer, buttonChoice.getRow(), buttonChoice.getCol()) == false) {
                        return; // Prevents infinite loop, if player chooses an already occupied spot return without invoking choose method
                    }

                    // If conditional statement does not return, allow choice to be made
                    arrayTicTacToe[buttonChoice.getRow()][buttonChoice.getCol()].setText(String.valueOf(currentPlayer));

                    // Update moves panel to show what move was made
                    JLabel playerMove = new JLabel("Row: " + buttonChoice.getRow() + " " + "Column: " + buttonChoice.getCol());
                    panelEast.add(playerMove);

                    // Computer opponent choice as O
                    if (!gameTicTacToe.gameOver()) {
                        while (true) {
                            // Select random position
                            int row = randomChoice.nextInt(3);
                            int col = randomChoice.nextInt(3);

                            // Pass in random value from 0-2, choose method checks if valid move, if not grab another random value
                            if (gameTicTacToe.choose(TicTacToe.BoardChoice.O, row, col) == true) {
                                arrayTicTacToe[row][col].setText("O");

                                // Update moves panel to show what move was made
                                JLabel computerMove = new JLabel("Row: " + row + " " + "Column: "  + col);
                                panelEast.add(computerMove);
                                break;
                            }
                        }
                    }
                }

                if (currentPlayer == TicTacToe.BoardChoice.O) {
                    // X choice was made later in the code, so now let player choose
                    Button buttonChoice = (Button) e.getSource();
                    buttonChoice.getRow();
                    buttonChoice.getCol();

                    if (gameTicTacToe.choose(currentPlayer, buttonChoice.getRow(), buttonChoice.getCol()) == false) {
                        return; // Prevents infinite loop, if player chooses an already occupied spot return without invoking choose method
                    }

                    // Update moves panel to show what move was made
                    JLabel playerMove = new JLabel("Row: " + buttonChoice.getRow() + " " + "Column: " + buttonChoice.getCol());
                    panelEast.add(playerMove);

                    arrayTicTacToe[buttonChoice.getRow()][buttonChoice.getCol()].setText(String.valueOf(currentPlayer));
                    // Computer opponent choice now as X, since O goes last
                    if (!gameTicTacToe.gameOver()) {
                        while (true) {
                            int row = randomChoice.nextInt(3);
                            int col = randomChoice.nextInt(3);

                            // Pass in random value from 0-2, choose method checks if valid move, if not grab another random value
                            if (gameTicTacToe.choose(TicTacToe.BoardChoice.X, row, col) == true) {
                                arrayTicTacToe[row][col].setText("X");

                                // Update moves panel to show what move was made
                                JLabel computerMove = new JLabel("Row: " + row + " " + "Column: " + col);
                                panelEast.add(computerMove);
                                break;
                            }
                        }
                    }

                    // Testing Purpose
                    // System.out.println("Row " + buttonChoice.getRow());

                    // Testing Purpose
                    // System.out.println("Col " + buttonChoice.getCol());

                    // Pass in the choose method from TicTacToeGame and take in the currentPlayer,
                    // row, and col
                    // Current player is inherited/borrowed from TicTacToeGame which itself is type
                    // BoardChoice.X
                    // initially
                    // Row and Col are inherited variables from the Button class that retrieves the
                    // x and y coordinates
                    // of the array position
                }

                if (gameTicTacToe.gameOver()) {
                    for (int i = 0; i < arrayTicTacToe.length; i++) {
                        for (int j = 0; j < arrayTicTacToe[i].length; j++) {
                            arrayTicTacToe[i][j].setEnabled(false); 
                        }
                    }
                    if (gameTicTacToe.getGameState() == TicTacToe.GameState.TIE) {
                        JLabel labelTie = new JLabel("Game is a tie!");
                        panelEast.add(labelTie);
                    }
                    if (gameTicTacToe.getGameState() == TicTacToe.GameState.X_WON) {
                        JLabel labelWinnerX = new JLabel("X Wins!");
                        panelEast.add(labelWinnerX);
                    }
                    if (gameTicTacToe.getGameState() == TicTacToe.GameState.O_WON) {
                        JLabel labelWinnerO = new JLabel("O Wins!");
                        panelEast.add(labelWinnerO);
                    }
                }
            }

            // X choice goes first
            if (button.getText() == "Choose X") {
                currentPlayer = TicTacToe.BoardChoice.X;
                labelPlayerMove.setText("Player X's turn");
                panelNorth.add(labelPlayerMove);
                selectChoiceX.setEnabled(false);
                selectChoiceO.setEnabled(false);
            }

            // O choice goes second, computer goes first as X
            if (button.getText() == "Choose O") {
                currentPlayer = TicTacToe.BoardChoice.O;
                labelPlayerMove.setText("Player O's turn");
                panelNorth.add(labelPlayerMove);
                selectChoiceX.setEnabled(false);
                selectChoiceO.setEnabled(false);

                int row = randomChoice.nextInt(3);
                int col = randomChoice.nextInt(3);
                gameTicTacToe.choose(TicTacToe.BoardChoice.X, row, col);
                arrayTicTacToe[row][col].setText("X");
                JLabel computerMove = new JLabel("Row: " + row + " " + "Column: " + col);
                panelEast.add(computerMove);
            }
        }
    }

    public static void main(String[] args) {
        // Construct the JFrame object
        JFrame gameBoardFrame = new JFrame("Tic Tac Toe");

        // Instanstiate a new TicTacToeGUI object
        TicTacToeGUI guiTicTacToe = new TicTacToeGUI();

        // Create the base GUI
        gameBoardFrame.getContentPane().add(guiTicTacToe);
        gameBoardFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gameBoardFrame.pack();
        gameBoardFrame.setVisible(true);
    }
}
