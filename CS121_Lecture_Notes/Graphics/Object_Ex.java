/**
 * Demonstrate how to use objects
 * 
 * @kyletruschel
 */

import java.awt.Point;
//Import the class where the objects can be created

public class ObjectDemo {
    public static void main(String[] args){
        //Create a Point object with integer precision
        //x and y will have an int as its state
        //Also known as instantiation to call the
        //constructor

        Point p = new Point(2, 7);
        Point origin = new Point();
        //constructor is always the same name as the cass

        System.out.println(p);
        System.out.println(origin);
        //When printing an object, the toString() method is also
        //displayed
        
        //Move p to (3, 12)
        p.move(3, 12);
        System.out.println(p);

        //Translate p by dx = -4 and dy = 6
        p.translate(-4, 6);
        System.out.println(p);

        //Equals method
        boolean areEqual = p.equals(origin);
        // p is the method calling object that compares it to origin
        System.out.println(areEqual);

        //make the points equal
        p.setLocation(origin);
        areEqual = p.equals(origin);
        //areEqual is already declared as a boolean, no need
        //declare again
        System.out.println(areEqual);
    }
    
}
