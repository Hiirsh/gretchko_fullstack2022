import telran.quadratic_function.model.QuadraticFunction;

public class App {
    public static void main(String[] args) throws Exception {
        QuadraticFunction func1 = new QuadraticFunction(-1, -2, 1);
        func1.display();
        System.out.println(func1.getDiscriminant());
        System.out.println(func1.getNumberOfSolutions());
        func1.showSolutions();
    }
}
