/*
 * Conditional is an if/then statement
 * if (condition = ) {
 * *do something*
 * }
 * 
 * Booleans can be declared as
 * boolean isBigger = x > y;
 * Logical operators combine clauses
 * (x = something && y = something)
 * (!x = something)
 * Java can short circuit &&, where if the first value does not
 * return true the rest is not executed
 * Boundary case is the greater than/less than condition
 * 
 * Cannot compare strings with double ==, only characters
 * 
 * int nameSize = stringName.length()
 * if (nameSize <= 50) {
 *  System.out.println("Good name")
 * }
 * 
 * if (name > 7 && < 25) {
 *  System.out.println("Good name")
 * }
 * 
 * An else statement is not directly needed.
 * 
 * int nameSize = stringName.length()
 * if (nameSize >=  3 && nameSize < 7) {
 *  a = nameSize
 * }
 * else if (nameSize > 8 && < 25) {
 *  b = nameSize
 * }
 * else if (nameSize > 25) {
 *  c = nameSize
 * }
 * 
 * Nested conditionals can be used to check username and password
 * .equals is used on a String
 * == is used on a char
 * 
 * Activity Hints:
 * Oval is a rectangle (0,0) is the top point.
 * Width is the bottom of the screen. 0 is the beginning
 * Height is the right most of the screen. 0 is the beginning.
 * If x > width, it will move off the screen.
 * Width - ballWidth to keep x position on screen (the diameter
 * of the ball)
 * Height - ballHeight to keep y position on screen.
 * 4 conditionals will be needed. Once the screen is hit, minus
 * and now 0 is the width/height of the screen.
 */