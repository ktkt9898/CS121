import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class File_Ex {
    public static void main(String[] args){
        // Read file and print out length of each line


        // Create the file object
        File inFile = new File("poem.txt");

        // Open the file
        try {
            Scanner fileScan = new Scanner(inFile);
            // Read each line and print the length
                while(fileScan.hasNextLine()) {
                    //get the line
                    String line = fileScan.nextLine();
                    //print the length
                    System.out.println(line.length());
                }
            // Close the file
            fileScan.close();
        }
        catch (FileNotFoundException e) {
            System.out.println("Could not find file");
        }
    }
}
