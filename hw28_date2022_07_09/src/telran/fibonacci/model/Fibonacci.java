package telran.fibonacci.model;

import java.util.Iterator;

public class Fibonacci implements Iterable<Integer> {
	private int quantity;

	public Fibonacci(int quantity) {
		this.quantity = quantity;

	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public Iterator<Integer> iterator() {
		return new Iterator<Integer>() {
			private	int[] arr = new int[quantity];
			private int currPos;

			@Override
			public boolean hasNext() {
				return currPos < quantity;
			}

			@Override
			public Integer next() {
				if (currPos == 0 || currPos == 1) {
					arr[currPos++] = 1;
					return 1;
				}
				arr[currPos] = arr[currPos - 1] + arr[currPos - 2];
				return arr[currPos++];
			}
		};
	}
}
