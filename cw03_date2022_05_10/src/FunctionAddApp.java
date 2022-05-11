public class FunctionAddApp {
    public static void main(String[] args) {
        double res = pi();
        System.out.println(res);
        printNumber(4.1232141);
        System.out.println(circleLength(4));
        System.out.println(max(2, 5));
        System.out.println(abc(-10));
    }

    private static double pi() {
        return 3.1415926;
    }

    private static void printNumber(double number) {
        System.out.println(number);
    }

    private static double circleLength(double diametr) {
        return diametr * pi();
    }

    private static double max(double x, double y) {
        return x > y ? x : y;
    }

    private static double abc(double x) {
        return x > 0 ? x : -x;
    }
}
