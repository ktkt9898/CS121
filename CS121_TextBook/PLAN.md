# PLAN.md Project 2 - TextBook
This program will demonstrate my ability to create custom classes that are able to communicate with eachother (thru dependencies, inheritance, and aggregation).

## Overview
This project will have me create a terminal based forum that allows a user to write a post, comment on a post, and delete the post all while saving their posts to a text file to be accessed in the future.

## What are the tasks?
1. Create a Post class so that a structure can be used for writing posts, a TextBook class that will use the Post class, and a TextBookDriver class that will use the TextBook class and where main will reside
2. For the Post class, I will need to set up my instance variables, constructors, and setter and getter methods so that a user can type into the terminal and create their forum post
3. For the TextBook class, I will similarly need to set up instance variables, constructors, and setter and getter methods to add the Posts to a list and possibly in this class be able to retrieve text fils where users can save their posts to be accessed later.
4. For the driver class, TextBookDriver, I will need to ensure it uses the TextBook class as a dependency and that the user is prompted with a menu of options to choose
5. Overall, the TextBook application should allow users to add a new post, display/print the post, delete the post, comment on a post, and allow the user to read the post along with its comments, and quit the application.

## How can those tasks be broken into smaller steps?
1. I will need to ensure that the Post class has the implements suffix in order to more efficiently use the already provided PostInterface class. The TextBook class that I create will similarly also need the implements suffix in order to more efficiently use the TextBookInterface class provided. The TextBookDriver will need to able to create TextBook objects and be able to use the methods within TextBook in order to properly display, create, and delete forum posts

2. The Post class should use mostly Strings and ArrayList types in order to store a user's forum post, so I will use those two types as my instance variables
- The constructor in the Post class will be public and should take a String parameter and store it to the Post object's name and arraylist. Upon further reading the readme, I will need two create two constructors in this class. One will need to create the actual post and takes paramters of a post ID, name of the author, and the actual text. The other constructor will need to retrieve the post based on the post ID parameter.
- The methods in the Post class should be a way to create a post, createPost(), retrieve the post, getPost(). I think I will use the delete method in the TextBook, since it should be stored as an element, and I think I can delete whatever the element/post of the TextBook that the user wants to remove.

3. The TextBook class will have the Post class as an aggregate since it has posts that will make up its arraylist of Post type.
- The constructor in the TextBook will be public and should take Post as its type of paramater, which itself is a String type, and store it to an arraylist. Upon further reading the readme, the Constructor here will be initalized as empty until the program later adds posts to the object.
- The methods in the TextBook class should be: getPost() and a way to save the actual TextBook arraylists to a file. I will need a way to delete a post from the TextBook, from direction of element position. I think it will also need a method to add comments to the user's post and store it within the textbook as a sort of forum log.

4. The TextBookDriver is where main will reside and where all previous methods will be called. This is also where the menu will prompt for the user to choose their selection of to make a new post, view the entire forum log, delete a post. The user should not have to save their post manually, so I will probably need to have this method within the driver class as well or atleast call it from the driver class.

5. The main features will be to Print posts, Add a new post, Delete a post, Comment on the post, and read those comments on the post.
- For printing posts, I think I will first work on getting individual posts to print, then I can move on to the larger task of getting its designated TextBook to print. I'm thinking it will likely display a file's contents as the data strucutre.
- For adding posts, I need to ensure the constructors in the Post class work for creating based on a post ID, author, and text. I then need to add the post to an empty TextBook ArrayList to be utilized later.
- For deleting Posts, I think I will utilize the TextBook ArrayList and simply remove whatever element corresponds to the post ID. I want to avoid removing the entire TextBook of course.
- For commenting, I will need to allow the user to append to an individual post within an ArrayList. As of now, I'm unsure on how to accomplish this, but I think I can start small by first allowing a user to comment on an individual post NOT within an ArrayList.
- For reading a post and its comments, I think this should be simply, since it should just be a print statement of an ArrayList that is formatted neatly.

## Testing Plan
I think I will approach this project from a bottom up perspective, starting with ensuring the Post class can properly create and retrieve a user's posts, as well as other parameters like author and the post ID. Then, I will work on the TextBook class to add the previously created posts into an ArrayList. I will work on being able to use methods to remove posts from the ArrayList/TextBook object as well. Finally, I will work on the main features to ensure that a user can enter in the terminal their desired feature, like creating a post.

I plan on using small steps within my Driver class to ensure that a file is created properly for the Post and that I can use all the methods in the Post class properly, then I will move onto the larger task of ensuring the posts get stored to an ArrayList for later use.

## Requirements Check
The Post Unit Tester successfully reports that 9/9 tests passed.
The TextBook Unit Tester successfully reports that 9/9 tests passsed.
For the features:
- If the user inputs "P" The TextBook and its current posts will be printed. It will also prompt the amount of Posts in existence.
- If the user inputs "A" the addPost method will be used to create a new Post. This post will then be added to the TextBook.
- If the user inputs "D" the removePost method will be used to remove the Post file, according to file path, and will update the
postIDs.txt file to reflect the change of where the Post was removed. So if Post-00002.txt is selected to be removed, its "2" string will be removed in postIDs.txt
- If the user inputs "C", the addComment method will be used to take in the user input author and text and append the current timestamp. No ID will be included as per readme instructions.
- If the user inputs "R", it will simply print out the current TextBook, utilizing the toString method to correctly and neatly format the Posts in TextBook.
- If the user inputs "Q", the program will exit the switch statements and end.
- If the user inputs any other values, the program will inform the user of their error and ask for a valid input.

## Compiling
When the user first runs the program, the user will be prompted to enter their username, as one word. If it is longer than one word it will be cut off before the whitespace.
To view the current TextBook, the user should input "P".
To add a post, the user should input "A" and enter their desired text.
To delete a post, the user should input "D" and enter a valid post ID.
To comment on a post, the user should input "D" and enter a valid post ID and then input their desired comment.
To read a post and its comments, the user should input "R" and enter a valid post ID.
To quit TextBook, the user should input "Q".

The user should activate this program in VS Code for the best experience.

## Sources Used
https://www.w3schools.com/java/java_files_create.asp
Referred to this source first to figure out how to create files. I ended up switching to FileOutputStream and PrintWriters to follow in class instruction.

https://www.baeldung.com/java-instant-to-string
Referred to this to find out how to convert from type Instant to type String.

https://www.baeldung.com/java-decimalformat
Referred to this to find out how to format the post IDs as 00000.

Kount Learning Center
Referred to the Kount Learning Center for help with the TextBook class and Post class.
LA Brady Ward helped with a lot of issues related to the TextBook class.

Professor Kathryn Rodgers
Referred to Kathryn Rodgers for help with the TextBook class.

## Reflection
This project was pretty darn complicated. This was the first project where I had to consult the learning center for many issues.

I was able to successfully create most of the Post class on my own, but getting the Post class to communicate with the TextBook class was an issue.

I understand the goal of this project was to demonstrate the concepts of class relationships, since TextBook inherits methods and constructors of the Post class. The TextBookDriver depends on the TextBook class, and some parts of the Post class, to function.

I started pretty early and I still ran into trouble. I suppose I should have gone to the learning center earlier to avoid frustration. The main issue was getting Post and TextBook to communicate, and getting TextBook to inherit the Post methods and constructors.

Some concepts that I'm still unsure of is some of the moving parts. I understand the idea is to create a Post file and then convert it to an ArrayList, but it seems like this project could have been completed without the TextBook class. Is there a more efficient way to make this project?

I suppose another issue with the project is the tester classes, which would keep throwing some errors even though I attempted to make a method more efficient, particularly the removePost method, which is ArrayList index based and NOT numerical based. So if the user wants to remove post "1" they technically have to input "0" for the post to be removed. I kept getting flagged for errors when I tried to adjust this method to be numerical based unfortunately.