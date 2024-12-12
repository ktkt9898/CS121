/**
 * TextBook Driver class. This allows a user to start the TextBook program which
 * allows a user to view the current forum posts in the TextBook, add a post
 * comment on a post, read a post and its comments, and delete a post entirely.
 * Posts are saved on each program startup, so history is saved as well.
 * 
 * @author kyletruschel
 * @author BSU CS 121 Instructors
 */

import java.util.Scanner;

public class TextBookDriver {
    public static void main(String[] args) {
        // Test Area

        // Post newPost = new Post(42);
        // System.out.println(newPost.toString());
        // if (true) {
        // return;
        // }
        // Post postTest1 = new Post(1, "me", "helloworld");
        // // System.out.println(postTest1.getFilename());
        // // System.out.println(postTest1.toStringPostOnly());
        // TextBook tesTextBook = new TextBook();

        // tesTextBook.addPost(postTest1);

        // Post toStringPostTest = new Post(42);
        // System.out.println(toStringPostTest.toString());

        // End of Test Area

        // Instantiate an empty overloaded Post constructor that will be used later.
        Post recoverPost;

        // Instantiate a new TextBook object that will be used to store Posts in.
        TextBook recoverTextBook = new TextBook();

        String dashedBorder = "----------------------";

        // Main scanner that will take user input
        Scanner scnr = new Scanner(System.in);

        // Ask user for username
        // If user enters spaces, they will simply be ignored.
        System.out.println("Welcome to TextBook. Please enter username with no spaces.");
        String userName = scnr.next();

        // Welcome message
        System.out.println(userName + ", welcome to TextBook. Please select a menu choice.");

        // Main Menu Variables
        String menuTitle = "TextBook Site Menu";
        String menuPromptReminder = "Input \"M\" to prompt the menu again.";
        String menuPrintPost = "(P)rint TextBook posts";
        String menuAddPost = "(A)dd a new post";
        String menuDeletePost = "(D)elete a post";
        String menuComment = "(C)omment on a post";
        String menuReadPost = "(R)ead a post and comments";
        String menuQuit = "(Q)uit TextBook";

        System.out.println(dashedBorder);
        System.out.println(menuTitle);
        System.out.println(dashedBorder);
        System.out.println(menuPromptReminder);
        System.out.println(menuPrintPost);
        System.out.println(menuAddPost);
        System.out.println(menuDeletePost);
        System.out.println(menuComment);
        System.out.println(menuReadPost);
        System.out.println(menuQuit);
        System.out.println(dashedBorder);

        // Primer for while loop
        String userChoice = " ";

        // Switch statements will continue to be allowed until the user enters "Q".
        while (userChoice != "Q") {
            // Adjust for user entering lowercase "q"
            userChoice = scnr.next().toUpperCase();
            switch (userChoice) {
                case "P":
                    // Print the TextBook and its Posts.
                    System.out.println(recoverTextBook.toString());

                    System.out.println("Input \"M\" to return to menu.");
                    break;
                case "A":
                    // Add a new Post to the TextBook
                    System.out.println("Add post selected.");
                    System.out.println(dashedBorder);
                    System.out.println("Enter text to be displayed:");

                    // Workaround, skips whitespace
                    String addPostSkip = scnr.nextLine();
                    String newText = scnr.nextLine();

                    recoverTextBook.addPost(userName, newText);

                    System.out.println(dashedBorder);

                    System.out.println("Input \"M\" to return to menu.");
                    break;
                case "D":
                    // Delete a Post from the TextBook
                    System.out.println("Please select a known post element ID to delete.");
                    try {
                        int postToDelete = scnr.nextInt();
                        recoverTextBook.removePost(postToDelete);
    
                        System.out.println("Input \"M\" to return to menu.");
                    }
                    catch (IndexOutOfBoundsException e) {
                        System.out.println("Invalid ID, please print TextBook for reference by inputting \"P\".");
                    }
                    break;
                case "C":
                    // Comment on a Post in the TextBook
                    System.out.println("Add comment to post selected.");
                    System.out.println("Enter known post ID:");

                    int commentPostID = Integer.valueOf(scnr.next());
                    recoverPost = new Post(commentPostID);

                    System.out.println("Enter text to be displayed:");

                    // Workaround, skips whitespace
                    String commentPostSkip = scnr.nextLine();
                    String commentText = scnr.nextLine();

                    recoverPost.addComment(userName, commentText);

                    System.out.println("Input \"M\" to return to menu.");
                    break;
                case "R":
                    // Read a Post and its comments in the TextBook
                    System.out.println("Read post and post's comments selected.");
                    System.out.println("Enter known post ID:");

                    int readPostID = Integer.valueOf(scnr.next());

                    // Takes the user input ID and passes it to the overloaded, recover
                    // Post constructor to read the Post itself, and the comments, if any
                    // exist.
                    recoverPost = new Post(readPostID);

                    System.out.println("Displaying post: " + readPostID);

                    System.out.println(recoverPost.toString());

                    System.out.println("Input \"M\" to return to menu.");
                    break;
                case "Q":
                    // Quit TextBook
                    userChoice = "Q";
                    break;
                case "M":
                    // Prompt the TextBook menu again
                    System.out.println("Menu Prompt Selected");
                    String menuTitleAgain = "TextBook Site Menu";
                    String menuPromptReminderAgain = "Input \"M\" to prompt the menu again.";
                    String menuPrintPostPromptAgain = "(P)rint TextBook posts";
                    String menuAddPostPromptAgain = "(A)dd a new post";
                    String menuDeletePostPromptAgain = "(D)elete a post";
                    String menuCommentPromptAgain = "(C)omment on a post";
                    String menuReadPostPromptAgain = "(R)ead a post and comments";
                    String menuQuitPromptAgain = "(Q)uit TextBook";

                    System.out.println(dashedBorder);
                    System.out.println(menuTitleAgain);
                    System.out.println(menuPromptReminderAgain);
                    System.out.println(menuPrintPostPromptAgain);
                    System.out.println(menuAddPostPromptAgain);
                    System.out.println(menuDeletePostPromptAgain);
                    System.out.println(menuCommentPromptAgain);
                    System.out.println(menuReadPostPromptAgain);
                    System.out.println(menuQuitPromptAgain);
                    System.out.println(dashedBorder);
                    break;
                default:
                    // Failsafe if user enters an invalid choice
                    System.out.println("Invalid choice. Please try again or input \"M\" to prompt menu.");
                    System.out.println(dashedBorder);
            }
        }
        scnr.close();
        System.out.print("Exiting TextBook.");
    }
}