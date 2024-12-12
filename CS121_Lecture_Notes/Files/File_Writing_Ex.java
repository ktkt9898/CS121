/**
 * Driver class demonstrating file writing
 * @author kyletruschel
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.FileOutputStream;

public class File_Writing_Ex {
    public static void main(String[] args) {
        
        try {
            // Create a file
            File outFile = new File("test.txt");
            FileOutputStream outStream = new FileOutputStream(outFile, true);
            // true specifies to append instead of overwrite
            PrintWriter pw = new PrintWriter(outStream);
        
            // Write to the file
            pw.println("Third Line");
            pw.println("Second line");

            // Close the file
            pw.close();
        }
        catch (FileNotFoundException e) {
            System.out.println("Could not create file");
        }
    }
}
