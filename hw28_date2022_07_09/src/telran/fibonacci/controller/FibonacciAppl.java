package telran.fibonacci.controller;

import telran.fibonacci.model.Fibonacci;

public class FibonacciAppl {

	public static void main(String[] args) {
		Fibonacci fibonacci = new Fibonacci(8);
		int sum = 0;
		int counter = 0;
		for (Integer num : fibonacci) {
			System.out.print(num);
			if (1 + counter++ < fibonacci.getQuantity()) {// другого способа не придумал, через hasNext не работает
				System.out.print(",");
			} else {
				System.out.println();
			}
		}
		counter = 0;
		for (Integer num : fibonacci) {
			sum += num;
			System.out.print(num);
			if (1 + counter++ < fibonacci.getQuantity()) {
				System.out.print(",");
			} else {
				System.out.print("=" + sum + "\n");
			}
		}

	}

}
