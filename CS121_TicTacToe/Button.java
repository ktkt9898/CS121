import javax.swing.JButton;

/**
 * This Button class will provide functionality for the Tic Tac Toe GUI. Essentially stores and retrieves coordinates
 * on the tic tac toe board.
 * 
 * @author kyletruschel
 */

public class Button extends JButton {
    // Instance variables
    private int row;
    private int col;

    // Constructor
    public Button(int row, int col) {
        this.row = row;
        this.col = col;
    }

    // Methods
    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }
}