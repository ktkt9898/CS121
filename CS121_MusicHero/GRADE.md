# Project 1 - MusicHero

## Rubric
```
Planning                                        /15
Subject Proficiency - Requirements                   
   Selection Menu loop                          5/10
   Load Catalog                                 8/10
   Search Catalog                               10/10
   Analyze Catalog                              0/10
   Find nearest playTime                        10/10
   Print Catalog                                10/10
   Quit                                         5/ 5
Documentation (including sources)               5/ 5
Coding Conventions                              5/ 5
Reflection                                      10/10

Total                         68/85
-----------------------------------

Planning
0 - All of the following sections missing or sparse
8 - half of the sections missing or sparse
15 - Appropriate high level tasks identified, detailed breakdown of each task into smaller steps, helpful and thorough testing plan identified

Subject Proficiency - Requirements

(-5) Should not have static instance variables - all variables should
be declared in a method

(-1) Should not use wrapper classes for primatives (e.g. you should
use int, not Integer; should use boolean, not Boolean; should use
char, not Character; etc)

(-1) Should use Track's methods (like toString, getters, etc) instead
of reimplementing the class' functionality

(-10)Analysis output does not match the expected output nor provide 
the expected information.  It shouldn't search for a keyword.



Documentation
5 - Complete JavaDoc, meaningful inline comments, all sources cited appropriately

Coding Conventions
5 - Consistent use of coding conventions

Reflection
10 - Two to three paragraphs, good use of writing conventions, reflection addresses all prompts. 
```
---------------------------------------
Compiling MusicHero.java using javac
---------------------------------------
MusicHero.java compiled successfully
------------------
------------------
Checking for @author tag
 * @author kyletruschel
------------------
============== Test Results ==============
 

-------------------------------------------
----------  Program Input (1)   ----------
-------------------------------------------
M
q
----------  Expected Output (1) ----------
********************************
***       Program Menu       ***
********************************
(L)oad catalog
(S)earch catalog
(F)ind song closest to playdime
(P)rint catalog
(Q)uit

Please enter a command (press M for Menu): M
********************************
***       Program Menu       ***
********************************
(L)oad catalog
(S)earch catalog
(F)ind song closest to playdime
(P)rint catalog
(Q)uit

Please enter a command (press M for Menu): q
Goodbye!
----------  Your Output (1)     ----------
********************************
***       Program Menu       ***
********************************
(L)oad catalog
(S)earch catalog
(A)nalyze catalog
(F)ind song closest to playtime
(P)rint catalog
(Q)uit
---------------------------------
********************************
***       Program Menu       ***
********************************
(L)oad catalog
(S)earch catalog
(A)nalyze catalog
(F)ind song closest to playtime
(P)rint catalog
(Q)uit
---------------------------------
Exiting program.

-------------------------------------------
----------  Program Input (2)   ----------
-------------------------------------------
l
collection-jb.csv
q
----------  Expected Output (2) ----------
********************************
***       Program Menu       ***
********************************
(L)oad catalog
(S)earch catalog
(F)ind song closest to playdime
(P)rint catalog
(Q)uit

Please enter a command (press M for Menu): l
Please enter filename: collection-jb.csv
Successfully loaded 23 songs!

Please enter a command (press M for Menu): q
Goodbye!
----------  Your Output (2)     ----------
********************************
***       Program Menu       ***
********************************
(L)oad catalog
(S)earch catalog
(A)nalyze catalog
(F)ind song closest to playtime
(P)rint catalog
(Q)uit
---------------------------------
Load catalog selected.
Enter exact file name: 
---------------------------------
Track contains 23 songs.
---------------------------------
Exiting program.

-------------------------------------------
----------  Program Input (3)   ----------
-------------------------------------------
l
collection-large.csv
S
cheese
q
----------  Expected Output (3) ----------
********************************
***       Program Menu       ***
********************************
(L)oad catalog
(S)earch catalog
(F)ind song closest to playdime
(P)rint catalog
(Q)uit

Please enter a command (press M for Menu): l
Please enter filename: collection-large.csv
Successfully loaded 1125 songs!

Please enter a command (press M for Menu): S
Please enter the search query: cheese
Found 2 matches
-------------------------------------------------------------- 
Cheese Cake                    Aerosmith            Night In The Ruts                255
Cheeseburger in Paradise       Jimmy Buffett        Songs You Know by Heart          172

Please enter a command (press M for Menu): q
Goodbye!
----------  Your Output (3)     ----------
********************************
***       Program Menu       ***
********************************
(L)oad catalog
(S)earch catalog
(A)nalyze catalog
(F)ind song closest to playtime
(P)rint catalog
(Q)uit
---------------------------------
Load catalog selected.
Enter exact file name: 
---------------------------------
Track contains 1125 songs.
---------------------------------
Search catalog selected.
---------------------------------
Enter song title to search for: 
---------------------------------
Search results found 2 instances of keyword cheese.
---------------------------------
Cheese Cake                    Aerosmith            Night In The Ruts                255
Cheeseburger in Paradise       Jimmy Buffett        Songs You Know by Heart          172
Exiting program.

-------------------------------------------
----------  Program Input (4)   ----------
-------------------------------------------
l
collection-large.csv
s
sky
Q
----------  Expected Output (4) ----------
********************************
***       Program Menu       ***
********************************
(L)oad catalog
(S)earch catalog
(F)ind song closest to playdime
(P)rint catalog
(Q)uit

Please enter a command (press M for Menu): l
Please enter filename: collection-large.csv
Successfully loaded 1125 songs!

Please enter a command (press M for Menu): s
Please enter the search query: sky
Found 4 matches
-------------------------------------------------------------- 
Lucy In The Sky With Diamonds  Beatles              Sgt. Pepper's Lonely Hearts...   208
Bullet The Blue Sky (Live)     U2                   Rattle And Hum                   336
Bullet the Blue Sky            U2                   The Joshua Tree                  272
Indian Summer Sky              U2                   The Unforgettable Fire           259

Please enter a command (press M for Menu): Q
Goodbye!
----------  Your Output (4)     ----------
********************************
***       Program Menu       ***
********************************
(L)oad catalog
(S)earch catalog
(A)nalyze catalog
(F)ind song closest to playtime
(P)rint catalog
(Q)uit
---------------------------------
Load catalog selected.
Enter exact file name: 
---------------------------------
Track contains 1125 songs.
---------------------------------
Search catalog selected.
---------------------------------
Enter song title to search for: 
---------------------------------
Search results found 4 instances of keyword sky.
---------------------------------
Lucy In The Sky With Diamonds  Beatles              Sgt. Pepper's Lonely Hearts C... 208
Bullet The Blue Sky (Live)     U2                   Rattle And Hum                   336
Bullet the Blue Sky            U2                   The Joshua Tree                  272
Indian Summer Sky              U2                   The Unforgettable Fire           259
Exiting program.

-------------------------------------------
----------  Program Input (5)   ----------
-------------------------------------------
L
collection-large.csv
A
q
----------  Expected Output (5) ----------
********************************
***       Program Menu       ***
********************************
(L)oad catalog
(S)earch catalog
(F)ind song closest to playdime
(P)rint catalog
(Q)uit

Please enter a command (press M for Menu): L
Please enter filename: collection-large.csv
Successfully loaded 1125 songs!

Please enter a command (press M for Menu): A
Catalog Analysis...
        Number of Artists: 9
        Number of Albums: 109 (112 if case sensitive)
        Number of Songs: 1125
        Catalog Playtime: 284550

Please enter a command (press M for Menu): q
Goodbye!
----------  Your Output (5)     ----------
********************************
***       Program Menu       ***
********************************
(L)oad catalog
(S)earch catalog
(A)nalyze catalog
(F)ind song closest to playtime
(P)rint catalog
(Q)uit
---------------------------------
Load catalog selected.
Enter exact file name: 
---------------------------------
Track contains 1125 songs.
---------------------------------
Analyze catalog selected.
Enter a value to analyze in the music collection: 
---------------------------------
Number of Song(s) containing q: 8.
Album(s) beloning to those songs: 112.
Artist(s) belonging to those songs: 9.
Total playtime of songs containing q: 2054.
---------------------------------
Exception in thread "main" java.util.NoSuchElementException
	at java.base/java.util.Scanner.throwFor(Scanner.java:945)
	at java.base/java.util.Scanner.next(Scanner.java:1486)
	at MusicHero.main(MusicHero.java:321)

-------------------------------------------
----------  Program Input (6)   ----------
-------------------------------------------
L
collection-large.csv
f
200
q
----------  Expected Output (6) ----------
********************************
***       Program Menu       ***
********************************
(L)oad catalog
(S)earch catalog
(F)ind song closest to playdime
(P)rint catalog
(Q)uit

Please enter a command (press M for Menu): L
Please enter filename: collection-large.csv
Successfully loaded 1125 songs!

Please enter a command (press M for Menu): f
Enter the desired playtime in seconds: 200
Finding track(s) closest to 200 seconds...
There are 4 songs equally close to 200 seconds...
-------------------------------------------------------------- 
Simoriah                       Aerosmith            Permanent Vacation               201
Everytime I See Him            Charlie Daniels B... A Decade Of Hits                 201
Workin' for Livin' (The Due... Garth Brooks         Double Live                      201
The Twilight Zone              Rush                 2112                             199

Please enter a command (press M for Menu): q
Goodbye!
----------  Your Output (6)     ----------
********************************
***       Program Menu       ***
********************************
(L)oad catalog
(S)earch catalog
(A)nalyze catalog
(F)ind song closest to playtime
(P)rint catalog
(Q)uit
---------------------------------
Load catalog selected.
Enter exact file name: 
---------------------------------
Track contains 1125 songs.
---------------------------------
Find closest playtime selected.
Enter time to search for in seconds: 
---------------------------------
In the music collection, there are 4 song(s) close to or exactly 200 seconds.
---------------------------------
Simoriah                       Aerosmith            Permanent Vacation               201
Everytime I See Him            Charlie Daniels Band A Decade Of Hits                 201
Workin' for Livin' (The Due... Garth Brooks         Double Live                      201
The Twilight Zone              Rush                 2112                             199
Exiting program.

-------------------------------------------
----------  Program Input (7)   ----------
-------------------------------------------
L
collection-jb.csv
p
q
----------  Expected Output (7) ----------
********************************
***       Program Menu       ***
********************************
(L)oad catalog
(S)earch catalog
(F)ind song closest to playdime
(P)rint catalog
(Q)uit

Please enter a command (press M for Menu): L
Please enter filename: collection-jb.csv
Successfully loaded 23 songs!

Please enter a command (press M for Menu): p
Song list contains 23 songs...
-------------------------------------------------------------- 
Woman Goin' Crazy On Caroli... Jimmy Buffett        Havana Daydreamin'               250
My Head Hurts My Feet Stink... Jimmy Buffett        Havana Daydreamin'               155
The Captain and the Kid        Jimmy Buffett        Havana Daydreamin'               198
Big Rig                        Jimmy Buffett        Havana Daydreamin'               211
Defying Gravity                Jimmy Buffett        Havana Daydreamin'               163
Havana Daydreamin'             Jimmy Buffett        Havana Daydreamin'               219
Cliches                        Jimmy Buffett        Havana Daydreamin'               166
Something So Feminine About... Jimmy Buffett        Havana Daydreamin'               212
Kick It In Second Wind         Jimmy Buffett        Havana Daydreamin'               237
This Hotel Room                Jimmy Buffett        Havana Daydreamin'               190
Cheeseburger in Paradise       Jimmy Buffett        Songs You Know by Heart          172
He Went to Paris               Jimmy Buffett        Songs You Know by Heart          209
Fins                           Jimmy Buffett        Songs You Know by Heart          205
Son of a Son of a Sailor       Jimmy Buffett        Songs You Know by Heart          205
A Pirate Looks at Forty        Jimmy Buffett        Songs You Know by Heart          232
Margaritaville                 Jimmy Buffett        Songs You Know by Heart          251
Come Monday                    Jimmy Buffett        Songs You Know by Heart          189
Changes in Latitudes Change... Jimmy Buffett        Songs You Know by Heart          195
Why Don't We Get Drunk         Jimmy Buffett        Songs You Know by Heart          162
Pencil Thin Mustache           Jimmy Buffett        Songs You Know by Heart          170
Grapefruit-Juicy Fruit         Jimmy Buffett        Songs You Know by Heart          176
Boat Drinks                    Jimmy Buffett        Songs You Know by Heart          157
Volcano                        Jimmy Buffett        Songs You Know by Heart          218

Please enter a command (press M for Menu): q
Goodbye!
----------  Your Output (7)     ----------
********************************
***       Program Menu       ***
********************************
(L)oad catalog
(S)earch catalog
(A)nalyze catalog
(F)ind song closest to playtime
(P)rint catalog
(Q)uit
---------------------------------
Load catalog selected.
Enter exact file name: 
---------------------------------
Track contains 23 songs.
---------------------------------
Printing catalog selected.
---------------------------------
Woman Goin' Crazy On Caroli... Jimmy Buffett        Havana Daydreamin'               250
My Head Hurts My Feet Stink... Jimmy Buffett        Havana Daydreamin'               155
The Captain and the Kid        Jimmy Buffett        Havana Daydreamin'               198
Big Rig                        Jimmy Buffett        Havana Daydreamin'               211
Defying Gravity                Jimmy Buffett        Havana Daydreamin'               163
Havana Daydreamin'             Jimmy Buffett        Havana Daydreamin'               219
Cliches                        Jimmy Buffett        Havana Daydreamin'               166
Something So Feminine About... Jimmy Buffett        Havana Daydreamin'               212
Kick It In Second Wind         Jimmy Buffett        Havana Daydreamin'               237
This Hotel Room                Jimmy Buffett        Havana Daydreamin'               190
Cheeseburger in Paradise       Jimmy Buffett        Songs You Know by Heart          172
He Went to Paris               Jimmy Buffett        Songs You Know by Heart          209
Fins                           Jimmy Buffett        Songs You Know by Heart          205
Son of a Son of a Sailor       Jimmy Buffett        Songs You Know by Heart          205
A Pirate Looks at Forty        Jimmy Buffett        Songs You Know by Heart          232
Margaritaville                 Jimmy Buffett        Songs You Know by Heart          251
Come Monday                    Jimmy Buffett        Songs You Know by Heart          189
Changes in Latitudes Change... Jimmy Buffett        Songs You Know by Heart          195
Why Don't We Get Drunk         Jimmy Buffett        Songs You Know by Heart          162
Pencil Thin Mustache           Jimmy Buffett        Songs You Know by Heart          170
Grapefruit-Juicy Fruit         Jimmy Buffett        Songs You Know by Heart          176
Boat Drinks                    Jimmy Buffett        Songs You Know by Heart          157
Volcano                        Jimmy Buffett        Songs You Know by Heart          218
---------------------------------
Exiting program.


