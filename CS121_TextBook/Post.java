import java.time.Instant;
import java.util.ArrayList;
import java.io.File;
import java.io.PrintWriter;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;
import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * Post class. Framework for the TextBook class and TextBookDriver. Allows a Post to be created as a file
 * and then convert that Post file object into an ArrayList in order to append comments to it.
 * 
 * @author kyletruschel
 * @author BSU CS 121 Instructors
 */

public class Post implements PostInterface {
    // Instance variables/attributes
    private String author;
    private String text;
    private Instant timestamp;
    private int postID;
    private ArrayList<String> commentsList = new ArrayList<String>();
    private File defaultFile;

    // Constructors
    // New Post Constructor
    /**
     * @param Post this constructor allows a new Post object to be created.
     *             It takes an ID, author, and text as parameters and will
     *             effectively create a
     *             text file formatted as Post-<00000>.txt
     */
    public Post(int newPostID, String newAuthor, String newText) {
        postID = newPostID;
        author = newAuthor;
        text = newText;
        timestamp = Instant.now();

        // Convert timestamp from Instant to String
        String formatTimestamp = String.valueOf(timestamp);

        // Format text file name to shift ID by 5 spaces.
        DecimalFormat decimalFormat = new DecimalFormat("00000");
        String formatPostID = decimalFormat.format(postID);

        try {
            // Creates a new file with relative pathing
            defaultFile = new File("Post-" + formatPostID + ".txt");

            // Instantiate a FileOutputStream that takes on the file path to allow the
            // PrintWriter to communicate
            // Allow append mode so later comments may be added to the file
            FileOutputStream outputStream = new FileOutputStream(defaultFile, true);

            // Instantiate a PrintWriter to be able to write to the file
            // File Format as: PostID + Timestamp + Author + Text
            PrintWriter printWriter = new PrintWriter(outputStream);
            printWriter.println(formatPostID + " " + formatTimestamp + " " + author + " " + text);

            // Inform user the file was created
            System.out.println("Post created.");

            printWriter.close();
        } catch (FileNotFoundException e) {
            System.out.println("File creation error.");
            e.printStackTrace();
        }
    }

    // Post Recovery Constructor
    /**
     * @param Post This is an overloaded constructor that will take in a Post ID and
     *             effectively
     *             convert its file contents into an ArrayList
     */
    // This converts the file created with the other constructor into an ArrayList
    public Post(int recoverPostID) {
        postID = recoverPostID;

        // Takes user input and formats it correctly to be used to match the file ID
        DecimalFormat decimalFormat = new DecimalFormat("00000");
        String formatPostID = decimalFormat.format(postID);

        try {
            // Instantiate a new ArrayList of type String
            commentsList = new ArrayList<String>();

            // Retrieve file path so scanners can parse through it.
            File recoverPostFilePath = new File("Post-" + formatPostID + ".txt");

            Scanner fileScanner = new Scanner(recoverPostFilePath);
            String line = fileScanner.nextLine();
            Scanner lineScanner = new Scanner(line);

            // Stop and retrieve the values anytime whitespace is encountered.
            lineScanner.useDelimiter(" ");

            // This stores the Post object's current postID
            // Convert from int to String
            String recoverID = lineScanner.next();
            postID = Integer.parseInt(recoverID);

            // This stores the Post object's current timestamp
            // Convert from Instant to String
            String recoverTimeStamp = String.valueOf(lineScanner.next());
            timestamp = Instant.parse(recoverTimeStamp);

            // This stores the Post object's current author
            String recoverAuthor = String.valueOf(lineScanner.next());
            author = recoverAuthor;

            // This stores the Post object's current text and trims any unecessary
            // whitespace
            String recoverText = String.valueOf(lineScanner.nextLine().trim());
            text = recoverText;

            lineScanner.close();

            // Parse thru the file
            while (fileScanner.hasNextLine()) {
                // Add all the converted string values to the ArrayList. Does not need ID since
                // the Post constructor already appends
                commentsList.add(fileScanner.nextLine());
            }
            fileScanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("Post not found.");
        }
    }

    // Methods
    /**
     * @param addComment this will allow a user to essentially write to the file
     *                   that the Post is residing in, its .txt file, and
     *                   append the timestamp, author, and text.
     */
    @Override
    public void addComment(String commentAuthor, String commentText) {
        Instant commentTimestamp = Instant.now();

        // Format the ID so the file can be retrieved exactly as it is named
        DecimalFormat decimalFormat = new DecimalFormat("00000");
        String formatPostID = decimalFormat.format(postID);
        String formatTimestamp = String.valueOf(commentTimestamp);

        try {
            // Instantiate a new PrintWriter that takes on the FileOutputStream location of
            // the exact file name
            // Allow append to be true for the FileOutputStream to avoid ovewriting and
            // actually allow comments to be made
            PrintWriter printWriter = new PrintWriter(new FileOutputStream("Post-" + formatPostID + ".txt", true));
            String theActualComment = (formatTimestamp + " " + commentAuthor + " " + commentText);
            printWriter.println(theActualComment);
            commentsList.add(theActualComment);
            printWriter.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
            e.printStackTrace();
        }
    }

    /**
     * @param toStringPostOnly this will return the Post contents, the first line
     *                         only, in the form of its ID, timestamp, author, and
     *                         text as a String type.
     */
    @Override
    public String toStringPostOnly() {
        DecimalFormat decimalFormat = new DecimalFormat("00000");
        String formatPostID = decimalFormat.format(postID);
        String formatTimestamp = String.valueOf(timestamp);

        return String.format(formatPostID + " " + formatTimestamp + " " + author + " " + text);
    }

    /**
     * @param getFileName this will return the Post object's current file name, as
     *                    displayed in the form of "Post-<00000>.txt" as a String
     *                    type
     */
    @Override
    public String getFilename() {
        DecimalFormat decimalFormat = new DecimalFormat("00000");
        String formatPostID = decimalFormat.format(postID);
        String recoverPostFilePath = ("Post-" + formatPostID + ".txt");

        return recoverPostFilePath;
    }

    /**
     * @param getPostID this will return the Post object's current ID as an int
     *                  type.
     */
    @Override
    public int getPostID() {
        return postID;
    }

    /**
     * @param getText this will return the Post object's current text as a String
     *                type.
     */
    @Override
    public String getText() {
        return text;
    }

    /**
     * @param getTimeStamp this will return the Post object's current timestamp as
     *                     an Instant type.
     */
    @Override
    public Instant getTimestamp() {
        return timestamp;
    }

    /**
     * @param getAuthor this will return the Post object's current author as a
     *                  String type.
     */
    @Override
    public String getAuthor() {
        return author;
    }

    /**
     * @param toString this will format the Post object in the form of the Post
     *                 contents, as well as any comments.
     *                 Only the ID will be printed on the first line and the
     *                 comments will follow.
     */
    @Override
    public String toString() {
        String listString = "";
        DecimalFormat decimalFormat = new DecimalFormat("00000");
        String formatPostID = decimalFormat.format(postID);

        listString += ("Post:" + "\n");
        listString += (formatPostID + " " + timestamp + " " + author + " " + text + " " + "\n");
        listString += ("Comments:" + "\n");

        for (String values : commentsList) {
            listString += values + "\n";
        }
        return listString;
    }
}
