import java.util.ArrayList;
import java.util.Random;

public class DiffieHellmann {
    private int p;
    private int q;
    public void generateP() {
        Random random = new Random();
        int nextP = random.nextInt();
        if (millerRabinTest(nextP)) {
            p = nextP;
        } else {
            generateP();
        }
    }
    public boolean millerRabinTest(int n) {
        // Wähle zufällige Zahl 1 < a < n
        Random random = new Random();
        int a = random.nextInt(n - 1) + 2;

        // ggT muss 1 sein, ansonsten definitiv keine Primzahl
        if (ggT(a, n) != 1) {
            return false;
        }

        // Zerlege n-1 in eine Zweierpotenz und einen ungeraden Faktor
        int s = ungeraderFaktor(n-1); // Ungerader Faktor
        int r = zweierPotenzExponent(n-1); // Zweierpotenz

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


    public int ungeraderFaktor(int n) {
        ArrayList<Integer> primFaktoren = primeFactors(n);
        int ungeraderFaktor = primFaktoren.get(0);

        for (int i = 1; i < primFaktoren.size(); i++) {
            if (primFaktoren.get(i) > ungeraderFaktor && (primFaktoren.get(i) % 2) != 0) {
                ungeraderFaktor = primFaktoren.get(i);
            }
        }
        return ungeraderFaktor;
    }
    public int zweierPotenzExponent(int n) {
        ArrayList<Integer> primFaktoren = primeFactors(n);
        int zweierPotenz = 1;

        for (int primfaktor: primFaktoren) {
            if (primfaktor == 2) {
                zweierPotenz *= 2;
            }
        }
        int zweierPotenzExponent = (int) (Math.log(zweierPotenz)/Math.log(2));
        return zweierPotenzExponent;
    }
    public ArrayList<Integer> primeFactors(int zahl) {
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 2; i <= zahl; i++) {
            while (zahl % i == 0) {
                result.add(i);
                zahl /= i;
            }
        }
        return result;
    }

}
