public class App {
    public static void main(String[] args) throws Exception {
        double min = Double.NaN;
        double max = Double.NaN;
        int i;
        for (i = 0; i < args.length; i++) {
            try {
                double temp = Double.parseDouble(args[i]);
                min = temp;
                max = temp;
                break;
            } catch (Exception e) {
                System.out.println(args[i] + " Wrong type");
            }
        }
        for (int j = i + 1; j < args.length; j++) {
            try {
                double temp = Double.parseDouble(args[j]);
                if (temp < min) {
                    min = temp;
                }
                if (temp > max) {
                    max = temp;
                }
            } catch (Exception e) {
                System.out.println(args[j] + " Wrong type");
            }
        }
        System.out.println("Min = " + min + ", Max = " + max);
    }
}
