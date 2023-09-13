import java.util.ArrayList;
import java.util.Random;

public class DiffieHellmann {
    private int p;
    private int q;
    public boolean millerRabinTest(int n) {
        if (n%2 != 1) {
            System.out.println("Das ist keine ungerade Zahl du Nase!");
            break;
        }
        // Wähle zufällige Zahl 1 < a < n
        Random random = new Random();
        int a = random.nextInt(n - 1) + 2;

        if (ggT(a, n) != 1) {
            return false;
        }

        int s = (ggT(n-1,2)); // Ungerader Faktor
        int r = (n-1)/(ggT(n-1,2)); // Zweierpotenz

        ArrayList<Integer> ergebnisse = new ArrayList<>();

    }
    public int ggT(int zahl1, int zahl2) {
        int rest = 1;
        int groeßereZahl;
        int kleinereZahl;
        if (zahl1 < zahl2) {
            groeßereZahl = zahl2;
            kleinereZahl = zahl1;
        } else {
            groeßereZahl = zahl1;
            kleinereZahl = zahl2;
        }
        while (rest > 0) {
            rest = groeßereZahl % kleinereZahl;
            groeßereZahl = kleinereZahl;
            kleinereZahl = rest;
        }
        return groeßereZahl;
    }

}
