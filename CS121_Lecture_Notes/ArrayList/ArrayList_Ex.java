import java.util.ArrayList;
import java.util.Random;
import java.util.Iterator;

public class ArrayList_Ex {
    public static void main(String[] args){
        ArrayList<Integer> nums = new ArrayList<Integer>();
        // Integer is the wrapper class, which takes an integer
        //and stores it as an object
        //We can pretend that the array holds regular integers
        // because of a process called autoboxing

        Random rand = new Random();

        // use for loop to add even numbers between 2 - 20
        // inclusive to list
        for (int i = 0; i <= 10; i++) {
            nums.add(rand.nextInt(50) + 1);
        }

        // print each element, same as a for-each loop
        // This loop allows modifying the elements, unlike
        //read only
        for (int i = 0; i < nums.size(); i++) {
            Integer current = nums.get(i);
            System.out.println(current);
        }

        System.out.println("------");

        // add 10 to each element and store
        for (int i = 0; i < nums.size(); i++) {
            Integer newValue = (nums.get(i) + 10);
            // now store this value back in the original
            nums.set(i, newValue);
        }

        System.out.println("------");

        // Iterator seeks out elements
        Iterator<Integer> iter = nums.iterator();
        while(iter.hasNext()){
            Integer elem = iter.next();
            System.out.println(elem);
        }

        // // verify 16 was added
        // if (nums.contains(16)) {
        //     System.out.println("16 is included");
        // }
        // else {
        //     System.out.println("Not included");
        // }

        // // clear array list
        // nums.clear();

        // // verify cleared
        // if (nums.isEmpty()) {
        //     System.out.println("Clear");
        // }
        // else {
        //     System.out.println("Not clear!");
        // }

        // nums.add(3);
        // // Initially add to the 0th element
        // nums.add(12);
        // nums.add(16);
        // nums.add(12);

        // // Add to a particular index element, does not remove
        // nums.add(1, 18);

        // //set a value/replace the value
        // nums.set(0, 15);

        // // get method
        // int firstElement = nums.get(0);

        // System.out.println("First element " + firstElement);

        // //Remove the first 12
        // nums.remove(2);
        // // or by value
        // // nums.remove(new Integer(12)); // this removes the first occurence

        // //for-each loop or enhanced for loop
        // // The colon is "in"
        // // Read-access only, cannot add or remove in the array for
        // // loop

        // for(Integer current : nums) {
        //     System.out.println(current);
        // }
    }
}
