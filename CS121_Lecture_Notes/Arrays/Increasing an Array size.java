/**
 * A null value will result in a null exception error.
 * 
 * To create an array of an unsual type:
 * 
 * DecimalFormat[] fmts = new DecimalFormat{3};
 * fmts[0] = new DecimalFormat("#.00");
 * 
 * Now in the 0th position, it will point in memory where
 * the DecimalFormat object lives, (objects reference)
 * 
 * Arrays as a Method Parameters:
 * An entire array can be passed as a paramter to a method
 * 
 * An array is an object, so the reference is passed.
 * 
 * Growing an Array:
 * Arrays cannot be increased or downsized when created.
 * To replicate a growing array, it needs to be copied
 * and its length multiplied. And then use a for loop
 * to copy over its elements.
 * The Heuristic strategy is to double the Arrays size
 * when needing to grow.
 * 
 * 
 */
