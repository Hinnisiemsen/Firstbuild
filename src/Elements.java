import java.util.ArrayList;

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
}
