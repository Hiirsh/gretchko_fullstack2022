//не взлетело
public class Version2 {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("No arguements");
            System.exit(0);

        }
        System.out.println(args.length);
        int i;
        double min = Double.NaN;
        double max = Double.NaN;
        for (i = 0; i < args.length; i++) {
            double temp = Double.parseDouble(args[i]);
            if (!Double.isNaN(temp)) {
                min = temp;
                max = temp;
                System.out.println("OK");
                break;
            } else {
                System.out.println("--------------------------" + args[i] + " Wrong type");
            }
        }

        for (int j = i + 1; i < args.length; i++) {
            double temp = Double.parseDouble(args[i]);
            if (!Double.isNaN(temp)) {
                min = temp < min ? temp : min;
                max = temp > min ? temp : min;
            } else {
                System.out.println("--------------------------" + args[j] + " Wrong type");
            }
        }
        if (Double.isNaN(min) && Double.isNaN(max)) {
            System.out.println("--------------------------" + "Wrong types of all arguments");
        } else {
            System.out.println("--------------------------" + "Min = " + min + ", Max = " + max);
        }
    }

}
