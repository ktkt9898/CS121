import java.text.DecimalFormat;

public class DecimalFormat_Ex {
    public static void main(String[] args) {
    // DecimalFormat methods
    
    //Create decimal format object
    DecimalFormat df = new DecimalFormat("#.00");

    double value1 = 1.0 / 3.0;
    double value2 = 12.34567;
    double value3 = 4;

    //Call format method
    System.out.println(df.format(value1));
    }
}
