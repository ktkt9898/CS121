/*
 * Allows a value to return based on a boolean expression in a SINGLE
 * line of code
 * An alternative to the if-else syntax
 * 
 * Consider the if-else statement:
 * String input = scan.nextline();
 * if (input.length()) > 10) {
 *  input = input.substr(0, 10);
 * }
 * else {
 *  input = input.substr(0, 3);
 * }
 * 
 * A ternary operator can do this in one statement.
 * String input = scan.nextline();
 * input = input.length() > 10 ? substr(0, 10) : substr(0, 3);
 * To the left of : is the true statement, right is the false
 * return statement
 * "Ternary" takes "three" operands
 */