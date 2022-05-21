public class App {
    public static void main(String[] args) {
        int[] arr = new int[10];
        fillArray(arr, 10, 99);
        printArray(arr);
        System.out.println("Min = " + findIndexMin(arr));
        reverseArray(arr);
        printArray(arr);
        System.out.println(calcTaxIsrael(12000, 2.25));
    }

    public static double calcTaxIsrael(double salary, double taxAllowance) {
        double res = -taxAllowance * 223;
        int[] sallarySteps = { 0, 6450, 9240, 14840, 20620, 42910 };
        double[] taxesSteps = { 0.1, 0.14, 0.2, 0.31, 0.35, 0.47 };
        for (int i = 1; i < sallarySteps.length; i++) {
            if (salary >= sallarySteps[i - 1] && salary < sallarySteps[i]) {
                res += (salary - sallarySteps[i - 1]) * .1;
                return res >= 0 ? res : 0;
            } else {
                res += (sallarySteps[i] - sallarySteps[i - 1]) * taxesSteps[i - 1];
            }
        }
        res += (salary - sallarySteps[sallarySteps.length - 1]) * taxesSteps[taxesSteps.length - 1];
        return res >= 0 ? res : 0;
    }

    private static void reverseArray(int[] arr) {
        for (int i = 0; i < arr.length / 2; i++) {
            int temp = arr[i];
            arr[i] = arr[arr.length - i - 1];
            arr[arr.length - i - 1] = temp;
        }
        printArray(arr);
    }

    private static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("%d\t", arr[i]);
        }
        System.out.println("");
    }

    private static int findIndexMin(int[] arr) {
        int res = arr[0];
        for (int i = 1; i < arr.length; i++) {
            res = arr[i] < res ? arr[i] : res;
        }
        return res;
    }

    private static void fillArray(int[] arr, int max, int min) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (min + (max - min + 1) * Math.random());
        }
    }
}
