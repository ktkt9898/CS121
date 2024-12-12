package Arrays;
import java.util.Random;

public class Two_Dimesional_Arrays_Ex {
    public static void main(String[] args) {
        int[][] grid = new int[3][5];

        // Sum third row
        int row = 2;
        // Specifies the third row
        int sum = 0;
        for (int col = 0; col < grid[row].length; col++) {
            sum = sum + grid[row][col];
        }

        // Fill the last column with numbers
        // Iterates over thru the rows first, the last row
        Random rand = new Random();
        int col = grid[0].length - 1;

        for (row = 0; row < grid.length; row++){
            grid[row][col] = row * 10;
            System.out.println(grid[row][col]);
        }
    }
}
