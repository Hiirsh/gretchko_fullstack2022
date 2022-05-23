public class App {
    public static void main(String[] args) throws Exception {
        int[] arr = new int[10];
        fillArray(arr, 10, 99);
        printArray(arr);
        select_sort(arr);
        printArray(arr);
    }

    public static void select_sort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int min = arr[i];
            int min_i = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < min) {
                    min = arr[j];
                    min_i = j;
                }
            }
            if (i != min_i) {
                int temp = arr[i];
                arr[i] = arr[min_i];
                arr[min_i] = temp;
            }
        }
    }

    public static void fillArray(int[] arr, int max, int min) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (min + (max - min + 1) * Math.random());
        }
    }

    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("%d\t", arr[i]);
        }
        System.out.println("");
    }
}
