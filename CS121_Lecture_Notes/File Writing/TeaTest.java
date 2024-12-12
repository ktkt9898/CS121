/**
 * @author kyletruschel
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.FileOutputStream;

public class TeaTest {
    public static void main(String[] args) {
        Tea green = new Tea(24, "Cherry", "large");

        green.saveFavorite();

        Tea favorite = new Tea();
        System.out.println(favorite);
        favorite.loadFavorite();
        System.out.println(favorite);
    }
}
