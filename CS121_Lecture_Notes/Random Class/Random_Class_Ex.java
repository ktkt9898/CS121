import java.util.Random;

public class Random_Class_Ex {
    public static void main(String[] args) {
        // // Create random object - no seed
        // Random rand = new Random();
        
        // // print 3 values
        // int num = rand.nextInt();
        // System.out.println(num);

        // // Create a random object w/seed
        // // overwrite old rand variable
        // //rand = new Random(12);

        // // print values
        // // bound by 16
        // num = rand.nextInt(16);
        // System.out.println(num);
        final float G = 6.67e-11f;
        final float M = 5.972e24f;
        final float r = 6371;

        double numerator = 2 * G * M;
        double escapeVelocity = Math.sqrt(numerator/r);
        System.out.println(escapeVelocity);
    }
    
}
