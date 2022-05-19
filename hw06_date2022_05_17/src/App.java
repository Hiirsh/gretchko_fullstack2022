public class App {
    public static void main(String[] args) throws Exception {
        printrectangle(8);
        System.out.println("");
        printSmallRectangle(9);
    }

    private static void printSmallRectangle(int size) {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (i == j || i + j == size - 1 || i == 0 || j == 0 || i == size - 1 || j == size - 1
                        || (i < j && i + j < size - 1)) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println("");
        }
    }

    public static void printrectangle(int size) {
        for (int j = 0; j < size; j++) {
            for (int i = 0; i <= size; i++) {
                if (i <= j || i == 0 || j == 0 || i == size || j == size) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}
