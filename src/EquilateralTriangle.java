public class EquilateralTriangle {
    // Exemplarvariablen
    private int sideLength;
    // Konstruktor
    public EquilateralTriangle(int sideLength) {
        this.sideLength = sideLength;
    }
    // Getter
    public int getSideLength() {
        return sideLength;
    }
    // Setter
    public void setSideLength(int sideLength) {
        this.sideLength = sideLength;
    }
    // Businessmethode
    public int circumference() {
        return 3*sideLength;
    }
    public void printArrayElements(String[] wörterbruder) {
        for (String wort: wörterbruder) {
            if (wort != null) {
                System.out.println(wort);
            }
        }
    }
    public int länge (String wort) {
        int länge = wort.length();
        return länge;
    }
    // Implement the RSA Algorithm
    public int[] rsa(int p, int q, int e) {
        int n = p * q;
        int phi = (p - 1) * (q - 1);
        int d = 0;
        int[] result = new int[3];
        for (int i = 1; i < phi; i++) {
            if ((i * e) % phi == 1) {
                d = i;
                break;
            }
        }
        result[0] = n;
        result[1] = e;
        result[2] = d;
        return result;
    }

    // Implement the Advanced encryption standard
    public String aes(String text, String key) {
        String result = "";
        int[] textArray = new int[text.length()];
        int[] keyArray = new int[key.length()];
        int[] resultArray = new int[text.length()];
        for (int i = 0; i < text.length(); i++) {
            textArray[i] = text.charAt(i);
        }
        for (int i = 0; i < key.length(); i++) {
            keyArray[i] = key.charAt(i);
        }
        for (int i = 0; i < text.length(); i++) {
            resultArray[i] = textArray[i] ^ keyArray[i];
        }
        for (int i = 0; i < text.length(); i++) {
            result += (char) resultArray[i];
        }
        return result;
    }

    // Implement the advanced euclidean algorithm
    public int[] advancedEuclideanAlgorithm(int a, int b) {
        int[] result = new int[3];
        int[] r = new int[100];
        int[] q = new int[100];
        int[] x = new int[100];
        int[] y = new int[100];
        int i = 0;
        r[0] = a;
        r[1] = b;
        q[0] = 0;
        q[1] = 0;
        x[0] = 1;
        x[1] = 0;
        y[0] = 0;
        y[1] = 1;
        while (r[i + 1] != 0) {
            i++;
            r[i + 1] = r[i - 1] % r[i];
            q[i] = (r[i - 1] - r[i + 1]) / r[i];
            x[i] = x[i - 1] - q[i] * x[i];
            y[i] = y[i - 1] - q[i] * y[i];
        }
        result[0] = r[i];
        result[1] = x[i];
        result[2] = y[i];
        return result;
    }

    // Write tests for the advanced euclidean algorithm
    public boolean testAdvancedEuclideanAlgorithm(int a, int b) {
        int[] result = advancedEuclideanAlgorithm(a, b);
        if (result[0] == a * result[1] + b * result[2]) {
            return true;
        } else {
            return false;
        }
    }
    // Method to calculate the greatest common divisor
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

    // Method to calculate the least common multiple
    public int kgV(int zahl1, int zahl2) {
        int kgV = (zahl1 * zahl2) / ggT(zahl1, zahl2);
        return kgV;
    }
    // Method to calculate the least common multiple of an array of numbers
    public int kgV(int[] zahlen) {
        int kgV = zahlen[0];
        for (int i = 1; i < zahlen.length; i++) {
            kgV = kgV * zahlen[i] / ggT(kgV, zahlen[i]);
        }
        return kgV;
    }

}
