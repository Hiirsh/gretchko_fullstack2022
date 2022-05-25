package telran.quadratic_function.model;

public class QuadraticFunction {
    private int a;
    private int b;
    private int c;

    public QuadraticFunction(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }

    public int getC() {
        return c;
    }

    public void setC(int c) {
        this.c = c;
    }

    public void display() {
        String res = "";
        String displA;
        String displB;
        String displC;
        switch (a) {
            case 1:
                displA = "x^2";
                break;
            case -1:
                displA = "-x^2";
                break;
            case 0:
                displA = "";
                break;
            default:
                displA = a + "x^2";
        }
        switch (b) {
            case 1:
            case -1:
                displB = "x";
                break;
            case 0:
                displB = "";
                break;
            default:
                displB = Math.abs(b) + "x";
        }
        switch (c) {
            case 0:
                displC = "";
                break;
            default:
                displC = "" + Math.abs(c);
        }
        res = displA + (b != 0 ? (b > 0 ? "+" : " - ") : "") + displB + (c != 0 ? (c > 0 ? " + " : " - ") : "") + displC
                + " = 0";
        System.out.println(res);
    }

    public double getDiscriminant() {
        return b * b - 4 * a * c;
    }

    public int getNumberOfSolutions() {
        double discriminant = getDiscriminant();
        if (discriminant > 0) {
            return 2;
        }
        if (discriminant == 0) {
            return 1;
        }
        return -1;
    }

    public double[] getSolutions() {
        double discriminant = getDiscriminant();
        double[] res = new double[2];
        if (discriminant > 0) {
            res[0] = (-b + Math.sqrt(discriminant)) / 2 / a;
            res[1] = (-b - Math.sqrt(discriminant)) / 2 / a;
        }
        if (discriminant == 0) {
            res[0] = -b / 2 / a;
        }
        return res;
    }

    public void showSolutions() {
        double[] solutions = getSolutions();
        int numSolutions = solutions.length;
        if (getDiscriminant() < 0) {
            System.out.println("No solutions");
            return;
        }
        switch (numSolutions) {
            case 2:
                System.out.println("x1 = " + Math.round(solutions[0] * 100) / 100. + ", x2 = "
                        + Math.round(solutions[1] * 100) / 100.);
                return;
            case 1:
                System.out.println("x = " + Math.round(solutions[0] * 100) / 100.);
                return;
        }
    }
}
