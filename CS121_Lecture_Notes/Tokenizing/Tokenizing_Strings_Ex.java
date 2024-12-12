import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Tokenizing_Strings_Ex {
    public static void main(String[] args) {
        // create file object
        final String DELIM = ";";
        double total = 0.0;
        int count = 0;
        try {
            File inFile = new File("data.dat");

            // Open the file
            Scanner fileScan = new Scanner(inFile);

            // find average age
            while (fileScan.hasNextLine()) {
                //get the line
                String line = fileScan.nextLine();

                //tokenize
                Scanner lineScan = new Scanner(line);
                lineScan.useDelimiter(DELIM);

                // age is the second field
                lineScan.next();
                int age = Integer.parseInt(lineScan.next());

                //store the age
                total += age;
                count++;

                lineScan.close();
            }
            fileScan.close();
            // print avg age
            System.out.print("Avg: " + (total/count));
        }
        // close the file

        catch (FileNotFoundException e) {
            System.out.println("Not found");
        }
    }
}
