/*
 * Floats and doubles compare (==) every single bit of data
 * A tolerance is used to compare floats without accidently
 * returning false.
 * Use absolute value
 * 
 * final double TOLERANCE = 0.001;
 * if (Math.abs(x - y) < TOLERANCE){
 * }
 * 
 * Characters are essentially represented as integers.
 * Capital letters are worth less than lowercase letters
 * Characters and primitives use operators (unlike strings with
 * methods)
 * char a = 'a'
 * char A = 'A'
 * int caseDelta = 'A' - 'a';
 * 
 * if (a < A){
 *  System.out.println(a);
 * }
 * else if (a > capA) {
 *  System.out.println(capA);
 * }
 * else if (capA - caseDelta == a){
 *  System.out.println("equal");
 * }
 * 
 * Strings are compared character by character based on the ASCII 
 * value. However strings are objects which are stored in memory
 * address (where the object lives)
 * "Object animal == Object food" compares the memory address.
 * Use the .equals() method to compare the integer values of the
 * objects, not their references.
 * .equalsIgnoreCase() will essentially lowercase both the Strings,
 * making them the same integer values (if the same word)
 * 
 * .compareTo works as returning negative or positive, not true
 * or false. If 0 returns, the objecst are equal.
 * Ex:
 * thingOne.compareTo(thingTwo) < 0
 *  thingOne comes first
 * thingOne.compareTo(thingTwo) > 0
 *  thingTwo comes first
 */