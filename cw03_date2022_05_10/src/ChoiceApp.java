public class ChoiceApp {
    public static void main(String[] args) {
        System.out.println(sing(-42.33));
    }

    private static int sing(double x) {
        if (x > 0) {
            return 1;
        }
        if (x < 0) {
            return -1;
        }
        return 0;
    }

}