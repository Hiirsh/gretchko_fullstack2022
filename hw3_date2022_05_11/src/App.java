public class App {
    public static void main(String[] args) {
        System.out.println(min(-4, 9));
        System.out.println(calcTax(900));
        System.out.println(calcTax(1000));
        System.out.println(calcTax(1100));
    }

    private static double min(double x, double y) {
        return -max(-x, -y);
    }

    private static double max(double x, double y) {
        return x > y ? x : y;
    }

    private static int calcTax(double sallary) {
        return sallary <= 1000 ? 0 : 17;
    }

}
