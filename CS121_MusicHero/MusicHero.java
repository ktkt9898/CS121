import java.util.Scanner;
import java.util.ArrayList;
import java.io.FileNotFoundException;
import java.io.File;

/*
 * This program creates a terminal based music display that can load a music library from a .csv file, analyze for a specific
 * search value, search for a song title, find a song closest to a time, and print the music library.
 * 
 * @author kyletruschel
 * @version Spring 2024
 */

public class MusicHero {
    static Scanner scnr = new Scanner(System.in);
    // Delimeter is whenever a comma is found
    static final String DELIM = ",";
    
    // The "master" array list that will be used for all following methods
    static ArrayList<Track> musicCollection = new ArrayList<Track>();

    // Array lists for purpose of the analyze track method
    static ArrayList<String> artistNames = new ArrayList<String>();
    static ArrayList<String> albumNames = new ArrayList<String>();

    // New array list to for closest song time to prevent musicCollection list from being modified, ensure encapsulation
    static ArrayList<Track> searchSongTimeResults = new ArrayList<Track>();

    // New array list for song titles to prevent musicCollection list from being modified, ensure encapsulation
    static ArrayList<Track> searchSongTitleResults = new ArrayList<Track>();
    static String dashedBorder = ("---------------------------------");

    /*
     * @param menuPrompt, will display in the terminal the choices that the user can input
     */
    public static void menuPrompt() {
        // Main Menu Variables
        String menuTopBorder = "********************************";
        String menuMiddleBorder = "***       Program Menu       ***";
        String menuBottomBorder = "********************************";
        String menuLoadCatalog = "(L)oad catalog";
        String menuSearchCatalog = "(S)earch catalog";
        String menuAnalyzeCatalog = "(A)nalyze catalog";
        String menuFindPlaytimeSong = "(F)ind song closest to playtime";
        String menuPrintCatalog = "(P)rint catalog";
        String menuQuit = "(Q)uit";
        System.out.println(menuTopBorder);
        System.out.println(menuMiddleBorder);
        System.out.println(menuBottomBorder);
        System.out.println(menuLoadCatalog);
        System.out.println(menuSearchCatalog);
        System.out.println(menuAnalyzeCatalog);
        System.out.println(menuFindPlaytimeSong);
        System.out.println(menuPrintCatalog);
        System.out.println(menuQuit);
        System.out.println(dashedBorder);
    }

    // Simply loads the .csv file to be used for other methods.
    /*
     * @param loadCatalog, will load a .csv file in order of artist, album, song title, and song time
     */
    public static void loadCatalog() {
        int songCount = 0;
        musicCollection.clear();
        String userInput = scnr.next();
        File fileName = new File(userInput);
        try {
            // First Scanner, parses thru file
            Scanner fileScan = new Scanner(fileName);

            while (fileScan.hasNextLine()) {
                // Second Scanner, parses each line up to each comma delimiter (,)
                String fileLine = fileScan.nextLine();

                Scanner lineScan = new Scanner(fileLine);
                lineScan.useDelimiter(DELIM);

                while (lineScan.hasNext()) {
                    String nameArtist = lineScan.next();
                    String nameAlbum = lineScan.next();
                    String nameSong = lineScan.next();
                    int timeSong = Integer.parseInt(lineScan.next());

                    Track musicTrack = new Track(nameSong, nameArtist, nameAlbum, timeSong);

                    musicCollection.add(musicTrack);
                    songCount++;
                }
                lineScan.close();
            }
            System.out.println("Track contains " + songCount + " songs.");
            System.out.println(dashedBorder);
            fileScan.close();
        // Error statement message
        } catch (FileNotFoundException e) {
            System.out.println("No results were found. Returning to menu selection.");
            System.out.println("Input \"M\" to bring up menu choices.");
            System.out.println(dashedBorder);
        }
    }

    // Search the loaded catalog for a single key terms or multiple terms in a sentence.
    /*
     * @param searchCatalog, searches for a song title by a single value or a sentence value
     */
    public static void searchCatalog() {
        searchSongTitleResults.clear();
        System.out.println("Enter song title to search for: ");
        System.out.println(dashedBorder);

        // Workable solution, method skips skipThisLine input whitespace and goes to inputUserSongTitle
        String skipThisLine = scnr.nextLine().toLowerCase();
        String inputUserSongTitle = scnr.nextLine().toLowerCase();
        int searchSongTitleCount = 0;
        Boolean songTitleFound = false;

        for (Track songTitle : musicCollection) {
            // Retrieves music collection song titles and converts all strings/words
            // to lower case to ignore case sensitivity of user input
            String songTitleMatch = songTitle.getTitle().toLowerCase(); {
                if (songTitleMatch.contains(inputUserSongTitle)) {
                    if (!searchSongTitleResults.contains(songTitle)) {
                        searchSongTitleResults.add(songTitle);
                        searchSongTitleCount++;
                        songTitleFound = true;
                    }
                }
            }
        }

        if (songTitleFound == true) {
            System.out.println("Search results found " + searchSongTitleCount + " instances of keyword " + inputUserSongTitle + ".");
            System.out.println(dashedBorder);
            for (Track printTrack : searchSongTitleResults) {
                if (printTrack.getTitle().length() > 30) {
                    System.out.printf("%-31.30s", printTrack.getTitle().substring(0, 27) + "...");
                }
                else {
                    System.out.printf("%-31.30s", printTrack.getTitle());
                }
                if (printTrack.getArtist().length() > 20) {
                    System.out.printf("%-21.20s", printTrack.getArtist().substring(0, 17) + "...");
                }
                else {
                    System.out.printf("%-21.20s", printTrack.getArtist());
                }
                if (printTrack.getAlbum().length() > 32) {
                    System.out.printf("%-33.32s", printTrack.getAlbum().substring(0, 29) + "...");
                }
                else {
                    System.out.printf("%-33.32s", printTrack.getAlbum());
                }
                System.out.printf("%d%n", printTrack.getPlayTime());
            }  
        }
        // Error statement message
        else {
            System.out.println("No results were found. Returning to menu selection.");
            System.out.println("Input \"M\" to bring up menu choices.");
            System.out.println(dashedBorder);
        }
    }

    // Search for a songtime within range of plus or minus 1 second.
    /*
     * @param searchSongTime, searches for a song time with a plus or minus 1 second tolerance
     */
    public static void searchSongTime() {
        searchSongTimeResults.clear();
        System.out.println("Enter time to search for in seconds: ");
        System.out.println(dashedBorder);
        int userSongTime = scnr.nextInt();
        int searchSongTimeCount = 0;
        Boolean songTimeFound = false;

        for (Track songTime : musicCollection) {
            int songTimeMatch = songTime.getPlayTime();
            if (songTimeMatch == userSongTime) {
                if (!searchSongTimeResults.contains(songTime)) {
                    searchSongTimeResults.add(songTime);
                    searchSongTimeCount++;
                    songTimeFound = true;
                }
            }
            else if (songTimeMatch == (userSongTime - 1)) {
                if (!searchSongTimeResults.contains(songTime)) {
                    searchSongTimeResults.add(songTime);
                    searchSongTimeCount++;
                    songTimeFound = true;
                }
            }
            else if (songTimeMatch == (userSongTime + 1)) {
                if (!searchSongTimeResults.contains(songTime)) {
                    searchSongTimeResults.add(songTime);
                    searchSongTimeCount++;
                    songTimeFound = true;  
                }         
            }
        }
        // Error message prompt
        if (songTimeFound == false) {
            System.out.println("No results were found. Returning to menu selection.");
            System.out.println("Input \"M\" to bring up menu choices.");
            System.out.println(dashedBorder);
        }
        if (songTimeFound == true) {
            System.out.println("In the music collection, there are " + searchSongTimeCount + " song(s) close to or exactly " + userSongTime + " seconds.");
            System.out.println(dashedBorder);
            for (Track printTrack : searchSongTimeResults) {
                if (printTrack.getTitle().length() > 30) {
                    System.out.printf("%-31.30s", printTrack.getTitle().substring(0, 27) + "...");
                }
                else {
                    System.out.printf("%-31.30s", printTrack.getTitle());
                }
                if (printTrack.getArtist().length() > 20) {
                    System.out.printf("%-21.20s", printTrack.getArtist().substring(0, 17) + "...");
                }
                else {
                    System.out.printf("%-21.20s", printTrack.getArtist());
                }
                if (printTrack.getAlbum().length() > 32) {
                    System.out.printf("%-33.32s", printTrack.getAlbum().substring(0, 29) + "...");
                }
                else {
                    System.out.printf("%-33.32s", printTrack.getAlbum());
                }
                System.out.printf("%d%n", printTrack.getPlayTime());
            }
        }
    }

    // Search catalog
    /*
     * @param analyzeCatalog, analyzes the loaded music catalog for a specific value and displays the number of unique artists with the 
     * search value, the albums belonging to that artist, and the total song time
     * of that album
     */
    public static void analyzeCatalog() {
        int countTitle = 0;
        int trackPlayTime = 0;
        artistNames.clear();
        albumNames.clear();
        System.out.println("Enter a value to analyze in the music collection: ");
        System.out.println(dashedBorder);
        String userSearch = scnr.next();
        
        for (Track analyzeTrack : musicCollection) {
            String uniqueAlbum = analyzeTrack.getAlbum();
            String uniqueArtist = analyzeTrack.getArtist();

            // Keeps track of artists that contain the user value inputted ONCE only
            if (!artistNames.contains(uniqueArtist)) {
                artistNames.add(uniqueArtist);
            }
            // Keeps track of albums that belong to the artist
            if (!albumNames.contains(uniqueAlbum)) {
                albumNames.add(uniqueAlbum);
            }
            // Keeps track of songs contained in the album that belong to the artist
            if (analyzeTrack.getTitle().contains(userSearch)) {
                countTitle++;
                trackPlayTime = trackPlayTime + (analyzeTrack.getPlayTime());
            }
        }
        int totalUniqueAlbums = albumNames.size();
        int totalUniqueArtists = artistNames.size();  

        if (countTitle != 0) {
            System.out.println("Number of Song(s) containing " + userSearch + ": " + countTitle + ".");
            System.out.println("Album(s) beloning to those songs: " + totalUniqueAlbums + ".");
            System.out.println("Artist(s) belonging to those songs: " + totalUniqueArtists + ".");
            System.out.println("Total playtime of songs containing " + userSearch + ": " + trackPlayTime + ".");
            System.out.println(dashedBorder);
        }
        // Error prompt
        else {
            System.out.println("No results were found. Returning to menu selection.");
            System.out.println("Input \"M\" to bring up menu choices.");
            System.out.println(dashedBorder);
        }
    }

    /*
     * @param printCatalog, neatly formats the loaded music catalog and cuts off any long words with three periods
     */
    public static void printCatalog() {
        // Print catalog feature, correctly formats long title names/albums/artists
        for (Track printTrack : musicCollection) {
            if (printTrack.getTitle().length() > 30) {
                System.out.printf("%-31.30s", printTrack.getTitle().substring(0, 27) + "...");
            }
            else {
                System.out.printf("%-31.30s", printTrack.getTitle());
            }
            if (printTrack.getArtist().length() > 20) {
                System.out.printf("%-21.20s", printTrack.getArtist().substring(0, 17) + "...");
            }
            else {
                System.out.printf("%-21.20s", printTrack.getArtist());
            }
            if (printTrack.getAlbum().length() > 32) {
                System.out.printf("%-33.32s", printTrack.getAlbum().substring(0, 29) + "...");
            }
            else {
                System.out.printf("%-33.32s", printTrack.getAlbum());
            }
            System.out.printf("%d%n", printTrack.getPlayTime());
        }
        System.out.println(dashedBorder);
    }

    public static void main(String[] args) {

        // Primer for the while loop
        String userChoice = " ";
        menuPrompt();

        while (userChoice != "q") {
            userChoice = scnr.next().toLowerCase();
            switch (userChoice) {
                case "a":
                    // Analyze playlist
                    if (!musicCollection.isEmpty()) {
                        System.out.println("Analyze catalog selected.");
                        analyzeCatalog();
                    }
                    else {
                    System.out.println("No track is loaded. Input \"L\" to import track.");
                    System.out.println(dashedBorder);
                    }
                    break;
                case "f":
                    // Find closest playtime
                    if (!musicCollection.isEmpty()) {
                        System.out.println("Find closest playtime selected.");
                        searchSongTime();
                    }
                    else {
                    System.out.println("No track is loaded. Input \"L\" to import track.");
                    System.out.println(dashedBorder);
                    }
                    break;  
                case "l":
                    // Load .csv file into the musicCollection array
                    System.out.println("Load catalog selected.");
                    System.out.println("Enter exact file name: ");
                    System.out.println(dashedBorder);
                    loadCatalog();
                    break;
                case "m":
                    menuPrompt();
                    break;
                case "p":
                    // Print catalog
                    if (!musicCollection.isEmpty()) {
                        System.out.println("Printing catalog selected.");
                        System.out.println(dashedBorder);
                        printCatalog();
                    }
                    else {
                        System.out.println("No track is loaded. Input \"L\" to import track.");
                        System.out.println(dashedBorder);
                    }
                    break;   
                case "q":
                    // Stops the while loop and exits the program
                    userChoice = "q";
                    break;
                case "s":
                    // Search playlist
                    if (!musicCollection.isEmpty()) {
                        System.out.println("Search catalog selected.");
                        System.out.println(dashedBorder);
                        searchCatalog();
                    }
                    else {
                    System.out.println("No track is loaded. Input \"L\" to import track.");
                    System.out.println(dashedBorder);
                    }
                    break;    
                default:
                    // Failsafe if the user enters an invalid choice
                    System.out.println("Invalid choice. Please try again or input \"M\" to bring up menu.");
                    System.out.println(dashedBorder);
                    menuPrompt();
            }
        }
        scnr.close();
        System.out.println("Exiting program.");
    }
}
