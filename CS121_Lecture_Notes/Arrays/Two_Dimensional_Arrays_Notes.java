/**
 * 2d Array can be thought of as a grid.
 * Each cell in the array has an index.
 * 
 * For Computers, an array of an array is how a 2d array is made.
 * Each row contains its array. (for conceptual purposes)
 * 
 * To create a 2d array two array types are instanstiated
 * int[][] grid = new int[3][5];
 * 3 rows 5 columns
 * 
 * int value = grid[1][2];
 * Row 1 Column 2.
 * 
 * To retrieve the number of rows and columns.
 * int NumRows = grid.length;
 * Retrieves the rows
 * 
 * int numColumns = grid[n].length
 * Retrieveves the columns in the row
 * 
 * Nested For loop with arrays:
 * int[][] grid = new int[3][5];
 * 
 * To find the last value:
 * lastValue = [numRows - 1][numColumns - 1];
 * 
 * for (int row = 0; row < grid.length: row++) {
 *  for (int col = 0; col < grid[row].length; col++) {
 *  grid[row][col] = row;
 *  }
 * }
 * 
 * How to find the sum of the third row?
 * int sum = 0;
 * 
 * for (int i = 0; i < grid.length - 1; i++) {
 *  sum = sum + grid[i];
 * }
 */