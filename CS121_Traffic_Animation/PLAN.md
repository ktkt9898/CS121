# PLAN.md Project 0 - Traffic Animation

## Overview
I want to make a train that moves from left to right on a train track with some desert scenery.
![Plan](images/plan)

## What are the tasks?
1. Instanstiate Color objects, such as road, sand, and paint for the train on the track.
2. Have grass, sky, and traffic line boundaries appear on screen.
3. Have vehicles moving from left to right on the screen
4. Add some background scenery, like stop cactus in the desert
5. Ensure all objects drawn on screen scale with window resizing
6. Lastly, I will need to ensure text appears on screen.

## How can those tasks be broken into smaller steps?
1. Create Color objects using the java.awt.Color class, such as Class blackRoad = new Color (94, 94, 94)
2. I can use the fillRect() method from the Graphics class. It will require four arguments of an initial x and y point and a width and height. I need to ensure that they scale with window resizing, so I will avoid using exact numbers, but divide/multiply by the width and height
3. I can use the already made green square as a base for the main engine of the train. I will attempt to make more parts of the train, like the smoke stack, by having new variables that can scale and change the x and y values so it appear mors left/right on the train body.
4. I can use the drawOval() method to create signs or import a png as a stop sign/railroad crossing.
5. I will ensure that all measurements are not exact numbers, but scale with width and height thru dividng or multiplying their values.
6. I can use the Graphics class with the drawText() method for step 6.

## Testing Plan
I will test periodically, so that the objects are drawn on screen. First I want to make the toughest portion, the moving train, and then add the scenery later. I need to make sure it scales as well. I will mostly use the Graphics class for this project. I will start first by creating a base unit that scales from the screen and then have units that scale off that. This will ensure everything scales properly when resizing.

## Requirements Check
The train moves with respect to the xOffest "anchor".
The train is composed of multiple parts, including borders around the wheel, a window cab, and a smoke stack.
Everything scales in proportion, including left right and up down.
The train returns after "leaving" the screen, as does the tumbleweed.
The bandit acts as the avatar observer.
Two train tracks are present as the lane.
5 methods are used to draw images: fillRect(), fillOval(), fillPolygon(), drawArc(), fillImage()
Text is seen above the train.
Multiple colors are used.
I separated my code with comments to avoid messy strewn about code.

## Compiling
This section should tell the user how to compile your code from the command line.  It is also appropriate to instruct the user how to use your code. Does your program require user input? If so, what does your user need to know about it to use it as quickly as possible?

The user can run this code by access the file path directory on their computer and within that directory, type "javac TrafficAnimation.java" to first compile and then "java TrafficAnimation.java" to run the program.

Or the user can download the files from github and run through VisualStudio.

## Sources Used
If you used any sources outside of the lecture slides, activity files, or text book you need to list them here. If you looked something up on stackoverflow.com and fail to cite it in this section it will be considered plagiarism and be dealt with accordingly. So be safe CITE!

Also, while not strictly necessary, you may also want to use this space to document for yourself where you found especially helpful resources within the lecture slides, example repository, or zybooks. This can be a valuable resource for you to remind you what you found especially helpful in figuring out different aspects of the project.

Professor Kathryn Rodgers
https://docs.oracle.com/javase/8/docs/api/java/awt/Graphics.html - Graphics Class
https://docs.oracle.com/javase/8/docs/api/javax/swing/ImageIcon.html - ImageIcon Class for Cactus and Rock
Adobe Photoshop - Cactus and Rock
Beginner Java - Drawing Text - Lesson 21, Cyan Code, https://www.youtube.com/watch?v=IkDeUW1yFLk
Moduel 4 - Ternary Operator

## Reflection
Write a 2-3 paragraph reflection describing your experience with this project. Answer the following questions (but feel free to add other insights): 
- What worked well and what was a struggle? (Think about all phases of the project including planning, coding, and testing)
- What concepts still aren't quite clear?
- What techniques did you use to make your code easy to debug and modify?
- What would you change about your design process?
- If you could go back in time, what would you tell yourself about doing this project?

The most challenging aspect of this project was defnitely getting the drawn shapes and images to scale with screen resizing. 

I found that I was unable to use any direct numbers but had to use multiplication and division operators, with respect to the screen width and height, in order to get the images to scale. 

I am somewhat unsure why using a width modifier on my units, like unitTrain, would cause the image to "fly" off the screen when scaling... I only have the height to be modified.

I was able to establish my shapes and used a lot of trial and error to get them in their right places. I also "drew" over certain shapes that I wanted to hide, such as the smoke stack... it is not exactly matching the body of the train, but its color blends in.

To make my code easy, from my understanding, I made each individual shape have its own x, y, width, and height variables in order to avoid any potential confusion with scaling. I also made certain shapes scale off one another, such as the train smoke stack scales off the train engine. I could have made my code more efficient with scaling, but I used comments to separate and make it easier to read.

Overall, I like how my animation turned out. If I had more time I would like to add a smoke trail coming from the smoke top of the train.

I started this project early so I was not rushed. I would probably tell myself to visit the LA more often to avoid any early mistakes, like the body of the train "flying" off when the height of the screen was adjusted.

