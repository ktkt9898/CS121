# PLAN.md Project 1 - MusicHero

## Overview
Create a terminal based music library that takes user input and allows the user to recieve the artist, album, song title, duration. The user will also be able to find songs to the closest user input playtime.

## What are the tasks?
1. Prompt user input using the Scanner class for various topics, like load catalog, search throughout the catalog, and quit.
2. Since the terminal will ask for a quit command, I will likely need to start with conditional statements.
3. Allow a user search for a specific value that is passd thru/analyze the track to see if any matches are found with relation to album, artist
4. Allow a user to search for songs closest to a specific time
5. Allow a user to searc
5. Ensure the prompt closes cleanly, such as when "q" is entered in the terminal.

## How can those tasks be broken into smaller steps?
The first step will be to instantiate a Scanner object that will serve as the main way a user can input topics. I will also likely need to ensure only valid topics are entered, and will need to user the lowercase method to ensure that the entered values are not reliant on case sensitivity.

I will also need the program to read the .csv file in the program, which is where all of the albums and songs will be located.

I believe I will need to utilize if/else statements, which prompts the user for the main topics, and the exit condition will be if the user prompts the terminal with "q".

Once the conditional statements are executed, such as search for album, I will need to use for loops to iterate throughout the opened .csv file for a keyword match. I will also likely need to take the user input and convert it to lowercase to avoid capitalization issues.

I plan on using for-each loops since I do not want to risk modifying my arraylists, since I just want to parse through them. If I need to "modify" I can just duplicate one/add values to a new arraylist.

I will first work on getting the actual .csv file loaded into an arraylist than I can use methods to parse thru the arraylist for the later methods.

The print track list should be easy, and I will just need to format it properly when printing the arraylist that the .csv file created from.

I can solve the find closest time feature by allowing the user's input to be exactly a song's time, or plus/minus the time to try and get a close match.

## Testing Plan
Since this topic will need to ensure the previous code works, I will need to ensure I start out with a good foundation to build off. I think the best way is to ensure the menu prompt works, then try doing one topic search, like album, and ensuring that feature works. If all is good, I can continue adding more of the required features.
I think I will need to use both while and for loops, but the for loops will be the most useful for iterating throughout the opened file.

I think using the collection-jb.csv to test will be the most effective since I can quickly verify if the methods are working as intended without going through a thousand song titles.

## Requirements Check
When the program is ran, a menu prompts for user input. If the user does not enter a correct option, the menu will inform the user of the appropriate choices until a switch statement is input. 
If "q" is input, the program will end and inform the user. If a correct input (switch statement choice) is chosen but a track is NOT loaded, the program will inform the user that they need to load their track list first. The input choices are also case insensitive, so the user may enter uppercase or lowercase.

Selection Menu Loop: If the user inputs "M" or "m', the terminal menu will prompt.

Load Catalog: If the user inputs "L" or "l", the program will start working on importing the .csv into a master ArrayList, musicCollection, with the loadCatalog() method.

Search Catalog: If the user inputs "S" or "s", the program will utilize the searchCatalog() method to parse thru the master ArrayList, musicCollection, for matches with the contains() method. The method will also work for sentence-length searches as well. The result will also be formatted just like the print feature.

Analyze Catalog: If the user inputs "A" or "a", the program will utilize the analyzeCatalog() method and ask the user for their desired search value. The method will then parse thru the master ArrayList, musicCollection, and for each unique artist found, from the user input value, will be added to a new arraylist, along with each unique album from that artist. The total song time will also be counted. Then, the results will be displayed in the terminal.

Find the song closest to playtime: If the user inputs "F" or "f", the program will utilize the searchSongTime() method, and take the user input time value in seconds, and parse thru the master ArrayList, musicCollection, to see if any matches with a +/- 1 second tolerance are found, and add the result to a new ArrayList, called searchSongTimeResults.

Print Catalog: If the user inputs "P" or "p", the program will format neatly the entire music catalog using the printCatalog() method, cutting off any longer than normal length words to correctly format the terminal window.

## Compiling
The user will need their music library in a .csv file format with Artist first, Album second, Title third, and Time last.
The user should ensure ALL files (Track.java, MusicHero.java, and their .csv files) are within the same folder before proceeding. The user can utilize the "javac" command to compile the code from a terminal window.
Alternatively the user can download VSCode and click the run button to run it directly thru VSCode. The user should still ensure all files are within the same folder.

## Sources Used
How to format print statements
https://stackoverflow.com/questions/4418308/java-output-formatting-for-strings

How to create switch statements
Module 4 - Boolean Expressions, Conditionals, Loops, Page 45

How to create ArrayLists
Module 5 - Methods, ArrayLists, File Parsing, and Exceptions, Page 5

How to use for-each loops
Professor Kathryn Rodgers

## Reflection
Write a 2-3 paragraph reflection describing your experience with this project. Answer the following questions (but feel free to add other insights): 
- What worked well and what was a struggle? (Think about all phases of the project including planning, coding, and testing)
- What concepts still aren't quite clear?
- What techniques did you use to make your code easy to debug and modify?
- What would you change about your design process?
- If you could go back in time, what would you tell yourself about doing this project?

I found this project to be enjoyable overall. 

I found that having multiple arraylists for a specific feature was most useful to avoid modifying my master arraylist, the one that is created from the .csv file, just in case that arraylist could be accessed or changed.

My biggest issue was dealing with the search function. I initially had it only search for a single keyterm, but I was having trouble getting keyterms that included a sentence (like "Day Tripper" instead of just "Day"). I found that the issue with the nextLine() method was it would recieving whitespace as a valid input, so it would immediately skip my conditional statements. I thought of adding a redudant scanner line that would be "skipped" in order to proceed to the actually needed scanner for user input, and it turns out this was a workable solution.

I suppose the search function concept is somewhat unclear, I am unsure of a more efficient way to deal with the whitespace issue other than having two scanners operate, where one is skipped so the actual scanner can be used for user input.

I found that using print statements for each step of my features was a useful technique to ensure the correct variable/arraylist/terminal message prompt was properly being displayed.

I can't think of anything to change my design process. I added a border for each terminal prompt so the user can easily follow what errors are present or what results were properly computed. I also made the switch statements call my user defined methods to avoid clutter in the actual switch statement.

I started the project early and got it done early. I made sure to get the foundational features (like loading the .csv) were working first before handling any other features. I suppose a feature I could have added was making the print statements properly display plurality like "songs" or "song" instead of "song(s)".
