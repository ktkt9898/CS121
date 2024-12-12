# PLAN.md Project 3 - TicTacToe

## Overview
This project will have me make a TicTacToe game that utilizes a GUI. It will demonstrate the ability to utilize arrays and GUIs.

## What are the tasks?
1. Create classes called TicTacToeGame, TicTacToe, and TicTacToeGUI
2. The TicTacToeGame will be the driver class that inherits the attributes, constructors, and methods from the TicTacToe class. It will also utilize the TicTacToeGUI.
3. TicTacToe will be the class that handles all the game logic and will have instance variables, constructors, and methods.
4. TicTacToeGUI will be the class that handles the GUI for the TicTacToeGame

## How can those tasks be broken into smaller steps?
1. TicTacToe is already created, but I will need to create the two other classes for functionality.
- TicTacToeGame will be the driver class that inherits from TicTacToe
- TicTacToe will be the logic class, and will contain attributes/instance variables, constructors, and methods for game functionality
- TicTacToeGUI will be the class that allows a user interface. We are still learning about GUIs so I will work on this portion last.
2. TicTacToeGame will need to inherit from the TicTacToe class
- This will act as the driver and is where all methods will be executed.
- This class will also contain the arrays for use in game logic, but will borrow from the TicTacToe class to create and populate the arrays.
3. TicTacToe will be the logic class and will contain all attributes, constructors, and methods.
- The methods to finish are: newGame, to create a new game and ask the player to start as X's or O's, gameOver, which will need to check if three X's or O's are in a row/diagnol, getGameState, which will support the gameOver method in updating the status/position in the array where an X or O is located, getGameGrid, which will provide a copy as to not break encapsulation of the current array grid, and getMoves, which will get the sequence of moves and make sure the player cannot place an X or O in a spot already occupied.
4. TicTacToeGUI will provide the user interface for the game.
- We are still learning about GUIs so I will work on this step last.

## Testing Plan
This project will definitely use a lot of nested loops in order to regularly update the array status. I will work on the functionality of the logic first before even attempting to work on the GUI.
For the logic portion, I'm thinking of using a 2d array to make a 3x3 grid.

## Requirements Check
The Tic Tac Toe game properly functions.
- Allows the user to player as X first or O second. If X is chosen the player will go first and the computer will move to a random, unoccupied spot. If O is chosen the player will go second and the computer will go first.
- Once the player has chosen X or O, the north quadrant will display if the player is X or O.
- If three X's or O's are in a row the game will display who won. If 9 moves are made, the game GUI will prompt as a tie.
- Once a game is won, the user can restart the game and the GUI will be cleared.
- Move history will be displayed to show what row and column were selected.

## Compiling
The user can run this program directly from visual studio code. When the user runs the program they must select to play X or O first, before the game can start. If the game is won or lost, they can click New Game to restart.

## Sources Used
https://stackoverflow.com/questions/10367722/clearing-my-jframe-jpanel-in-a-new-game
// How to clear the JPanel that containes all moves made

Professor Kathryn Rodgers
// TicTacToeGame class

Learning Assistant Brady Ward
// TicTacToeGame class, TicTacToeGUI class

Learning Assistant Adam Crayton
// TicTacToeGame class

## Reflection
Write a 2-3 paragraph reflection describing your experience with this project. Answer the following questions (but feel free to add other insights): 
- What worked well and what was a struggle? (Think about all phases of the project including planning, coding, and testing)
- What concepts still aren't quite clear?
- What techniques did you use to make your code easy to debug and modify?
- What would you change about your design process?
- If you could go back in time, what would you tell yourself about doing this project?

I found this project somewhat frustrating at first. I knew this project would be out of my league so I went to the learning center in order to get a better understanding on how to accomplish the task. This helped avoid further frustration and possible failure.

The GUI was somewhat confusing on how to connect the game logic to button functionality. It required some clever manipulation, such as the buttons technically being called " ", as to appear invisible but still retain a name so that the action listener could detect the button.

I ran into an issue where whenever I attempted to start a new game, the points, as in possible available moves, was not resetting. I used the run and debug to walkthrough the exact time which the points array was supposed to reset. After pinpointing the issue, I adding the point array to the game logic constructor and ensured it would be set to zero.
I also ensure my code is easy to follow, adding comments on any areas that I would have trouble explaining to learning assistants.

If I could have more time, I would try to add a custom image to the 3x3 gameboard instead of the default white background.

I think I focused appropriately on this project. I knew this project would be difficult so I wasted no time going to the learning center to get a head start on it.