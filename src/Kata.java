import java.util.HashMap;
import java.util.Map;
import java.util.*;

public class Kata {
    public Kata() {

    }
    public static Map<Character, Integer> count(String str) {
        // Happy coding!
        Map<Character, Integer> result = new HashMap<>();
        char[] characters = str.toCharArray();

        for (int i = 0; i < characters.length; i++) {
            if (!result.containsKey(characters[i])) {
                result.put(characters[i], 1);
            } else {
                result.replace(characters[i], result.get(characters[i])+1);
            }
        }
        return result;
    }
    public static String maskify(String str) {
        char[] characters = str.toCharArray();
        String result = new String();

        if (characters.length > 4) {
            for (int i = characters.length - 4; i > 0; i--) {
                characters[i] = '#';
            }
            return characters.toString();
        } else {
            return str;
        }
    }
    public static String rgb(int r, int g, int b) {
        String result = new String();
        int[] rgb = {r,g,b};

        for (int einzel: rgb) {
            if (einzel <= 0) {
                result = result.concat("00");
            } else if (einzel >= 255) {
                result = result.concat("FF");
            } else {
                int ersteStelle = 0;
                int zwischenstand = einzel;

                while (zwischenstand > 16) {
                    zwischenstand -= 16;
                    ersteStelle++;
                }
                String zweiteStelleHex = Integer.toHexString(zwischenstand);
                String ersteStelleHex = Integer.toHexString(ersteStelle);

                result = result.concat(ersteStelleHex).concat(zweiteStelleHex);
            }
        }
        return result.toUpperCase();
    }
    public static int bouncingBall(double h, double bounce, double window) {
        if (window > h || h < 0 || bounce < 0 || bounce > 1) {return -1;}

        int bounces = 1;
        do {
            h *= bounce;
            bounces += 2;
        } while (h > window);

        return bounces;
    }
    public static int ConvertBinaryArrayToInt(List<Integer> binary) {
        int result = 0;
        for (int i = 0; i < binary.size(); i++) {
            result = binary.get(i)* (int) Math.pow(2, i);
        }
        return result;
    }
    public static String factors(int n) {
        String result = new String();
        ArrayList<Integer> primeFactors = new ArrayList<>();
        for (int i = 2; i <= n; i++) {
            while (n % i == 0) {
                primeFactors.add(i);
                n /= i;
            }
        }

        for (int primeFactor: primeFactors) {
            int exponent = 0;
            for (int j = 0; j < primeFactors.size(); j++) {
                if (primeFactor == primeFactors.get(j)) {
                    exponent++;
                }
            }
            if ((exponent > 1) && !result.contains("(" + primeFactor + "**" + exponent + ")")) {
                result = result.concat("(" + primeFactor + "**" + exponent + ")");
            } else if (exponent <= 1) {
                result = result.concat("(" + primeFactor + ")");
            }
        }
        return result;
    }
    public static String expandedForm(int num)
    {
        String result = "";
        for (int i = 0; i < Integer.toString(num).length(); i++) {
            int v = Integer.parseInt(Character.toString(Integer.toString(num).charAt(i))) * (int) Math.pow(10, Integer.toString(num).length()-1-i);
            if (v != 0) {
                result = result.concat(Integer.toString(v)).concat(" + ");
            }
        }
        return result.substring(0,result.length()-3);
    }
    public static List<String> top3(String s) {
        List<String> result = new ArrayList<>();
        HashMap<String, Integer> zwischenstand = new HashMap<>();
        String[] words = s.replaceAll("[^A-Za-z']", " ").split("\\s");


        // Leere Strings entfernen
        words = Arrays.stream(words).filter(str -> !str.isEmpty()).toArray(String[]::new);
        if (words.length != 0) {
        // wörter ablegen und zählen
        for (String word: words) {
            if (!zwischenstand.containsKey(word)) {
                zwischenstand.put(word, 1);
            } else {
            int counter = zwischenstand.get(word);
            zwischenstand.remove(word);
            zwischenstand.put(word, counter+1);
            }
        }
        // maximum value rausfinden und zu result hinzufügen
            while (result.size() < 3 && !zwischenstand.isEmpty()) {
                String maxWord = words[0];
                int maxCount = Integer.MIN_VALUE;

                for (Map.Entry<String, Integer> entry : zwischenstand.entrySet()) {
                    String word = entry.getKey();
                    int count = entry.getValue();
                    if (count > maxCount) {
                        maxCount = count;
                        maxWord = word;
                    }
                }
                zwischenstand.remove(maxWord);
                if (maxWord != null & (!maxWord.replaceAll("'", "").isEmpty())) {
                    result.add(maxWord.toLowerCase());
                }
            }

        }
        return result;
    }
    public static String[] dirReduc(String[] arr) {
        HashMap<String, String> contra = new HashMap<>();
        contra.put("NORTH", "SOUTH");
        contra.put("SOUTH", "NORTH");
        contra.put("WEST", "EAST");
        contra.put("EAST", "WEST");
        List<String> directions = Arrays.stream(arr).toList();

        for (int i = 0; i < directions.size()-1; i++) {
            if (directions.get(i) == null) {
                directions.remove(i);
            } else if (Objects.equals(directions.get(i + 1), contra.get(directions.get(i)))) {
                directions.remove(i);
                directions.remove(i+1);
            }


        }
        return new String[] {};
    }

    public static String add(String a, String b) {
        int[] numbersA;
        String[] result;
        int[] numbersB;
        int uebertrag = 0;
        int groeßer;

        if (a.length() >= b.length()) {
            groeßer = a.length();
            numbersA = new int[groeßer];
            numbersB = new int[groeßer];
            result = new String[groeßer+1];

            for (int i = 0; i < groeßer-1; i--) {
                numbersB[numbersB.length-1-i] = Character.getNumericValue(b.charAt(b.length()-1-i));
                numbersA[i] = Character.getNumericValue(a.charAt(i));
            }
        } else {
            groeßer = b.length();
            numbersB = new int[groeßer+1];
            numbersA = new int[groeßer+1];
            result = new String[groeßer+2];

            for (int i = groeßer-1; i >= 0; i--) {
                numbersA[i] = Character.getNumericValue(a.charAt(i));
                numbersB[i] = Character.getNumericValue(b.charAt(i));
            }
        }

        for (int i = groeßer-1; i >= 0; i--) {
            result[i+1] = Integer.toString((numbersA[i] + numbersB[i] + uebertrag)%10);
            uebertrag = (numbersA[i] + numbersB[i])/10;
        }
        result[0] = Integer.toString(uebertrag);



        return Arrays.toString(result);
    }
    public static String[] whoEatsWho(final String zoo) {
        HashMap<String, String> fressen = new HashMap<>();
        fressen.put("antelope", "grass");
        fressen.put("big-fish", "little-fish");
        fressen.put("bug", "leaves");
        fressen.put("bear", "big-fish bug chicken cow leaves sheep");
        fressen.put("chicken", "bug");
        fressen.put("cow", "grass");
        fressen.put("fox", "chicken sheep");
        fressen.put("giraffe", "leaves");
        fressen.put("lion", "antelope cow");
        fressen.put("panda", "leaves");
        fressen.put("sheep", "grass");

        String[] tiere = zoo.split(",");
        // Jedes gegessene Tier mit "chomp" ersetzten
        for (int i = 1; i < tiere.length-1; i++) {
            if (fressen.containsKey(tiere[i]) && !Objects.equals(tiere[i], "chomp")) {
                String[] essen = fressen.get(tiere[i]).split(" ");
                for (String s : essen) {
                    if (Objects.equals(tiere[i - 1], s)) {
                        tiere[i - 1] = "chomp";
                        i--;
                    } else if (Objects.equals(tiere[i + 1], s)) {
                        tiere[i + 1] = "chomp";
                        i--;
                    }
                }
            }
        }

        for (int i = 0; i < tiere.length; i++) {

        }

        return new String[]{zoo, zoo};
    }
}
