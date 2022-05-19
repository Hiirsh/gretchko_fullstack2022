public class NumberManipulationAppl {
    public static void main(String[] args) {
        int res = countDigits(123);
        System.out.println("Count digits = " + res);// 3
        res = countDigits(8);
        System.out.println("Count digits = " + res);// 1
        res = countDigits(0);
        System.out.println("Count digits = " + res);// 1
        res = countDigits2(123);
        System.out.println("Count digits = " + res);// 3
        res = countDigits2(8);
        System.out.println("Count digits = " + res);// 1
        res = countDigits26(0);
        System.out.println("Count digits = " + res);// 1
        luckyNumber(173854);// 1 + 3 + 5 != 7 + 8 + 4 - unlucky
        luckyNumber(1738649);// 1 + 3 + 6 + 9 == 7 + 8 + 4 - lucky
    }

    public static void luckyNumber(int num) {
        int odd = 0;
        int even = 0;
        int counter = 1;
        while (num != 0) {
            if (counter == 1) {
                odd += num % 10;
                counter = 0;
            } else {
                even += num % 10;
                counter = 1;
            }

            num /= 10;
        }
        if (even == odd) {
            System.out.println("lucky");
        } else {
            System.out.println("unlucky");
        }
    }

    public static int countDigits(int num) {
        int res = 0;
        do {
            num /= 10;
            res++;
        } while (num != 0);

        return res;
    }

    public static int countDigits2(int num) {
        if (num == 0) {
            return 1;
        }
        int res = 0;

        while (num != 0) {
            num /= 10;
            res++;
        }
        ;

        return res;
    }
}
