package telran.goat.model;

public class Goat {
    public int count;
    public final int max;
    public static final int COUNT_MAX = 20;

    public Goat(int count, int max) {
        count = 5;
        this.max = max;
    }

    public int getCount() {
        return count;
    }
}
