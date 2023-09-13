public class Zahlen {
    private int zahl1;
    private int zahl3;
    public Zahlen(int zahl1, int zahl3) {
        this.zahl1 = zahl1;
        this.zahl3 = zahl3;
    }

    public int getZahl3() {
        return zahl3;
    }

    public int getZahl1() {
        return zahl1;
    }

    public void setZahl1(int zahl1) {
        this.zahl1 = zahl1;
    }

    public void setZahl3(int zahl3) {
        this.zahl3 = zahl3;
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

    public int[][] chessBoard(){
        int[][] hurensohn = new int[8][8];
        for (int zeile = 0; zeile < hurensohn.length; zeile++) {
            for (int spalte = 0; spalte < hurensohn.length; spalte++) {
                hurensohn[zeile][spalte] = (zeile+spalte)%2;
            }
        }
        return hurensohn;
    }
    public int[] fill(int n) {
        int[] ergebnis = new int[n];
        for (int i = 0; i < n; i++) {
            ergebnis[i] = i*i;
        }
        return ergebnis;
    }








}
