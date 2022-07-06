package telran.array.tools;

public class MemoryService {

	public static int getMaxArrayMemory() {
		Integer[] arr = null;
		int i = 0;
		int left = 0;
		int right = Integer.MAX_VALUE;
		int middle = (left + right) / 2;
		while (i != 31) {
			middle = (right - left) / 2;
			try {
				arr = new Integer[middle];
				left = middle;
			} catch (OutOfMemoryError e) {
				right = middle;
				System.out.println(e.getMessage());
			}
			i++;
		}
		return middle;
	}
}
