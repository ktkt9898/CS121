package Arrays;

public class Arrays_Ex {
    public static void main(String[] args) {
    int[] newArray = new int[15];
    int i;

    for (i = 0; i < newArray.length; i++) {
        newArray[i] = i + 1;
        // System.out.println(newArray[i]);
    }

    // for (int values : newArray) {
    //     System.out.println(values);
    // }

    // Print an array backwards

    for (i = (newArray.length - 1); i >= 0; i--) {
        System.out.println(newArray[i]);
        }
    }
}
