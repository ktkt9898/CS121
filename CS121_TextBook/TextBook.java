import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * TextBook Class. Inherits the Post class constructors and methods to utilize for constructors and methods
 * within.
 * 
 * @author kyletruschel
 * @author BSU CS 121 Instructors
 */

public class TextBook implements TextBookInterface {

    // Create an empty ArrayList of type Post
    private ArrayList<Post> postsLists;

    // Assing lastID to be empty, it will later be updated.
    private int lastID;

    // Constructors
    public TextBook() {
        // Set lastID to be 0 the first time a TextBook object is created
        lastID = 0;

        // Create a new ArrayList of type Post. This will store the actual Posts
        // to the TextBook object
        postsLists = new ArrayList<Post>();

        // Direct the file path to open the same file, postIDs.txt, in the TextBookInterface
        // File
        File openInterface = new File(TextBookInterface.POST_LIST_FILENAME);

        try {
            // Attempt to open the postIDs.txt
            Scanner fileScanner = new Scanner(openInterface);
            while (fileScanner.hasNextLine()) {
                // Open the current existing postIDs.txt and grab its ID values
                int currentID = Integer.parseInt(fileScanner.nextLine());

                // Map/match the current ID value grabbed to the overloaded constructor in Post
                // This will then format the ID to the Post class' ArrayList
                Post textBookAddCurrentPost = new Post(currentID);

                // Add the previous Post ArrayList element to the TextBook postsLists ArrayList
                postsLists.add(textBookAddCurrentPost);
                if (currentID > lastID) {
                    lastID = currentID;
                }
            }
            fileScanner.close();
        } catch (FileNotFoundException e) {
        }
    }

    // Methods
    /**
     * @param getLastID will return the TextBook object's last updated, current ID.
     */
    @Override
    public int getLastID() {
        return this.lastID;
    }

    /**
     * @param getPostCount will return the TextBook object's current post count
     *                     based on the ArrayList size.
     */
    @Override
    public int getPostCount() {
        int postCount = postsLists.size();
        return postCount;
    }

    /**
     * @param getPostString will return and format the TextBook object's post, based
     *                      on ArrayList index, and format it
     *                      accordingly to the toString method.
     */
    @Override
    public String getPostString(int index) {
        return postsLists.get(index).toString();
    }

    /**
     * @param addPost will add a new Post to the TextBook object. This will take in
     *                an author and text and incremently
     *                update lastID. Then adds the Post to the ArrayList,
     *                postsLists. Finally, it will append the index value/postID to
     *                the
     *                postIDs.txt.
     */
    @Override
    public void addPost(String author, String text) {
        // Increment the lastID
        lastID++;

        // Use the first Post constructor which also creates a new Post file under the Project2 folder
        Post addNewPost = new Post(lastID, author, text);

        // Add the Post to the TextBook ArrayList
        postsLists.add(addNewPost);
        try {
            // Add the incremented value to the postIDs.txt for use later
            PrintWriter printWriter = new PrintWriter(new FileOutputStream(TextBookInterface.POST_LIST_FILENAME, true));
            printWriter.println(lastID);
            printWriter.close();
        } catch (FileNotFoundException e) {
            System.out.println("Add post failed.");
            e.printStackTrace();
        }
    }

    /**
     * @param removePost will take a user given index value and remove the
     *                   index/element value of the
     *                   ArrayList of postsLists. Then, it will update the current
     *                   status of postIDs.txt and the postsLists
     *                   to reflect the changes.
     */
    @Override
    public Post removePost(int index) {
        // if ((index >= 0) && (index < postsLists.size())) {
        Post deletedPost = postsLists.remove(index);
        try {
            PrintWriter printWriter = new PrintWriter(TextBookInterface.POST_LIST_FILENAME);
            for (Post values : postsLists) {
                printWriter.println(values.getPostID());
            }
            File removedFileUpdate = new File(deletedPost.getFilename());
            removedFileUpdate.delete();
            printWriter.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
        }
        return deletedPost;
    }

    /**
     * @param addComment will take on a index value, author, and text and utilize
     *                   the addComment
     *                   method in the Post class.
     */
    @Override
    public void addComment(int postIndex, String newAuthor, String newText) {
        if ((postIndex >= 0) && (postIndex < postsLists.size())) {
            Post newPost = postsLists.get(postIndex);
            newPost.addComment(newAuthor, newText);
        } else {
            throw new IndexOutOfBoundsException();
        }
    }

    /**
     * @param toString will recieve the size of the TextBook object's postsLists to
     *                 inform the
     *                 user through the terminal.
     */
    @Override
    public String toString() {
        int postCount = postsLists.size();
        int indexCount = 0;
        String returnMessage = ("TextBook contains " + postCount + " posts:" + "\n");
        for (Post values : postsLists) {
            returnMessage += (indexCount + " - " + values.toStringPostOnly() + "\n");
            indexCount++;
        }
        return returnMessage;
    }

    /**
     * @param getPosts will return a copy of the postsLists as to not break
     *                 encapsulation.
     */
    @Override
    public ArrayList<Post> getPosts() {
        ArrayList<Post> copyOfPosts = new ArrayList<Post>();
        for (int i = 0; i < postsLists.size(); i++) {
            copyOfPosts.add(postsLists.get(i));
        }
        return copyOfPosts;
    }
}
