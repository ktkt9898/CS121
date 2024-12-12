/**
 * Arrays vs ArrayList
 * Recall an ArrayList keeps track of a collection of a type
 * like string
 * 
 * ArrayLists automatically grow. ArrayLists are objects
 * 
 * An Array does not automatically grow. Cannot add more elements
 * than space allows. Arrays can hold primitive types, whereas
 * ArrayLists hold objects.
 * 
 * An Array is simply a memory address.
 * 
 * Arrays are created as:
 * int[] nums = new int[6];
 *  This informs an integer array that has a size of 6.
 *  This array is empty.
 * 
 * double[] costs {3.14, 17.04, 4.04};
 *  This is a size 3 array.
 * 
 * Arrays do not take on methods, since they are not objects.
 * To set a value:
 * nums[0] = 4;
 * nums[3] = 6;
 * 
 * To access value
 * int value = nums[0]
 * 
 * To both set and access value use brackets to index the array
 * 
 * To get the size of the array pass on .length
 * This is not a method, but a field that java keeps track off.
 * 
 * Array are susceptible to off by 1 errors. For a size 15 array, its elements
 * are from 0 to 14.
 * Arrays can be of any type but must contain the same type.
 * 
 * Arrays are typically more efficient with memory.
 * If the collection does not need to grow or shrink, an array is fine.
 * If the collection may increase, use an ArrayList.
 * 
 * Typically an Array is declared bigger than it needs to contain.
 * 
 * To swap array elements, a value must temporarily be stored to avoid overwriting.
 * char[] letters = new char[4]
 * letters[0] = 'a'
 * letters[1] = 'b'
 * letters[2] = 'c'
 * Swap 'b' with 'c'
 * char temp = letters[1]
 * letters[1] = letters[2]
 * letters[2] = temp;
 * 
 * Dynamic Sizing is applied to ArrayLists NOT Arrays.
 */