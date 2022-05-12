public class App {
    public static void main(String[] args) {
        System.out.println(checkArmy(18));
    }

    public static String checkArmy(int age) {
        return age >= 18 && age < 45 ? "Go to army" : "Go to pub";
    }
}
