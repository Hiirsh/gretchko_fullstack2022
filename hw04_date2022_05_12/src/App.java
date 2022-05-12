public class App {
    public static void main(String[] args) {
        System.out.println(leumi(3));
        System.out.println(leumi(2));
        System.out.println(leumi(1));
        System.out.println(scheduler(1));
        System.out.println(scheduler(2));
        System.out.println(scheduler(3));
        System.out.println(scheduler(8));
    }

    public static String leumi(int day) {
        switch (day) {
            case 1:
            case 3:
            case 5:
                return "8:30-13:30";
            case 2:
            case 4:
                return "8:30-13:00, 16:00-18:00";
            case 6:
            case 7:
                return "Closed";
            default:
                return "Wrong day";
        }
    }

    public static String scheduler(int week) {
        int scheduler = week % 4;
        switch (scheduler) {
            case 1:
                return "John";
            case 2:
                return "Peter";
            case 3:
                return "Tigran";
            default:
                return "Mary";
        }
    }

}
