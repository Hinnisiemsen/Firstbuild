import java.net.URI;
import java.util.*;

public class Elements {
    private boolean dead ;
    public boolean isAlive ( ) {
        return !dead;
    }

    public ArrayList<Elements> removeDeads (ArrayList<Elements> input) {
        for (int i = 0; i < input.size(); i++) {
            if (!input.get(i).isAlive()) {
                input.remove(i);
                i--;
            }
        }
        return input;
    }
    public static int doSomething ( int a , int b ) {
        if (a-b >= 0) {
            return 1 + doSomething(a-b, b);
        }
        return 0;
    }

    public boolean checkListSorting (List<Long> listeInput) {
        for (int i = 0; i < listeInput.size()-1; i++) {
            if (listeInput.get(i) >= listeInput.get(i+1)) {
                return false;
            }
        }
        return true;
    }

    public static int[] fill (int n) {
        int[] result = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            if (i == 0 || i == 1) {
                result[i] = i;
            } else {
                result[i] = fib(i);
            }
        }
        return result;
    }
    public static int fib(int n) {
        if (n == 0 || n == 1) {
            return n;
        } else {
            return fib(n-2) + fib(n -1);
        }
    }

    // Schreiben Sie eine Methode isPrime, die für eine übergebene ganzzahlige Zahl
    //(ganzzahliger primitiver Datentyp) ermittelt, ob diese eine Primzahl ist. Das Ergebnis (wahr /
    //falsch) soll an den Aufrufer zurückgegeben werden.

    public static boolean fermatTest (int p) {
        return 1 == Math.pow((int) (Math.random() * (p - 1)) + 1, p-1)%p;
    }


    public interface IPost {
        void display();
    }
    public class Date {
        int tag;
        int monat;
        int jahr;
        public Date(int tag, int monat, int jahr) {
            this.tag = tag;
            this.monat = monat;
            this.jahr = jahr;
        }
        public String getDate() {
            return tag + "." + monat + "." + jahr;
        }
    }
    public interface ICalenderPost extends IPost {
        boolean isBefore(Date date);
        void display();
    }
    public class EventPost implements ICalenderPost {
        @Override
        public void display() {}
        @Override
        public boolean isBefore(Date date) {
            return false;
        }
    }
    public abstract class Post implements IPost {
        public abstract void display();
        private void update() {}
    }
    public class MessagePost extends Post {
        String message;
        @Override
        public void display() {}
    }
    public class PhotoPost extends Post {
        URI photo;
        @Override
        public void display() {}
    }





}
