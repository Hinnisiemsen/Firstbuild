import java.util.ArrayList;
import java.util.Random;

public class DiffieHellmann {
    private int p;
    private int q;
    public boolean millerRabinTest(int n) {
        // Wähle zufällige Zahl 1 < a < n
        Random random = new Random();
        int a = random.nextInt(n - 1) + 2;

        // ggT muss 1 sein, ansonsten definitiv keine Primzahl
        if (ggT(a, n) != 1) {
            return false;
        }

        // Zerlege n-1 in eine Zweierpotenz und einen ungeraden Faktor
        int s = (ggT(n-1,2)); // Ungerader Faktor
        int r = (n-1)/(ggT(n-1,2)); // Zweierpotenz

        ArrayList<Integer> ergebnisse = new ArrayList<>();

        for (int i = 0; i <= r; i++) {
            ergebnisse.add((int) (Math.pow(a,(Math.pow(2,i)*s)))%n);
            if (ergebnisse.get(i) == 1) {
                return true;
            }
        }
        return false;
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
