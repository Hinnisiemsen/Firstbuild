// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
import java.util.*;
public class Main {
    public static void main(String[] args) {
        // Press Alt+Eingabe with your caret at the highlighted text to see how
        // IntelliJ IDEA suggests fixing it.

        Zahlen zahl = new Zahlen(4402, 395);
        // System.out.println(zahl.ggT(420, 49));
/*
        Point punkt = new Point(5, 0);
        Point punkt2 = new Point(5, 1);
        System.out.println(punkt.isOnXAxis());
        System.out.println(punkt2.isOnXAxis());
*//*
        byte[] scanline = new byte[1];
        scanline[0] = 0;
        for (int i = 0; i < scanline.length-i-2; i += 3) {
            byte red = scanline[i];
        }
       System.out.println(Arrays.toString(zahl.fill(4)));
        String[] wörter = new String[3];
        wörter[0] = "Leandro";
        wörter[2] = "Tjorven";

        */
        // DiffieHellmann test = new DiffieHellmann();

        // System.out.println(test.millerRabinTest(71));
        Kata test = new Kata();

        System.out.println(Arrays.toString(Kata.whoEatsWho("fox,bug,chicken,grass,sheep,bear,giraffe,leaves")));
    }
}