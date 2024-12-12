/**
 * Represents a cup of tea
 * 
 * @author kyletruschel
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.FileOutputStream;
import java.util.Scanner;

public class Tea {
    // Instance variables
    private int size;
    private String flavor;
    private String type;

    // Constructors
    public Tea() {
        size = 8;
        flavor = "tea";
        type = "black";
    }

    public Tea(int newSize, String newFlavor, String newType) {
        this.size = newSize;
        this.flavor = newFlavor;
        this.type = newType;
    }

    // Getters/Setters
    // In the file format: size;type;flavor
    // @return true if file written successfully
    public boolean saveFavorite() {
        try {
            PrintWriter pw = new PrintWriter(new File("favoriteTea.txt"));
            pw.println(size + ";" + type + ";" + flavor);
            pw.close();
        }
        catch (FileNotFoundException e) {
            return false;
        }
        return true;
    }

    // @return true if file returned
    public boolean loadFavorite() {
        try {
            // tokenize the line
            // Create scanner on string

            Scanner fileScanner = new Scanner(new File("faboriteTea.txt"));
            String line = fileScanner.nextLine();
            Scanner lineScanner = new Scanner(line);

            // Set delimeter
            lineScanner.useDelimiter(";");

            // Parse the variables
            size = Integer.parseInt(lineScanner.next());
            type = lineScanner.next();
            flavor = lineScanner.next();
        }
        catch (FileNotFoundException e) {

        }
        return true;
    }

    // toString
    @Override
    public String toString() {
        return "Tea (" + size + ")" + type + " " + flavor;
    }
}
