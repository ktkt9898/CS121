/**
 * For loops syntax:
 * for (initialize; when condition <; update) {
 * }
 * for (int i = 0; i < 10; i++){
 * }
 * ++i is a pre-update increment
 * i++ is a post-update increment
 * 
 * To incremenet more than 1, use +=number
 * for (int i = 30; i <=90; i+=3){
 *  System.out.println(i);
 * }
 * 
 * For Loop vs While Loop
 * Both can be used to accomplish the same.
 * While is better for user input or when a condition turns false
 * For loops are better to search through every element or to count
 * 
 * Running Sum or Accumulation
 * int low = 20;
 * int high = 70;
 * int sum = 0; //accumulator variable
 * for (int i = low; i <= high; i++) {
 *  sum +=i;
 * }
 * System.out.println("sum: " + sum);
 * 
 * Print even integers from 10 to 100
 * int low = 10;
 * int high = 100;
 * int sum = 0;
 * 
 * for (int i = low; i <= high; i+=2) {
 *  System.out.println(i);
 * }
 * 
 * Nested Loops
 * 
 * for (int = 0; i < 10; i++) {
 *  for (int j = 0; j < 10; j++) {
 *      print "Im here"
 *  }
 * }
 * 
 * Multiply the bounds to get the total amount
 * 10 iterations in the inner loop for 1 iteration of the outer
 * loop
 * 
 * Generally better the declare the iteration variable in the
 * loop
 */
