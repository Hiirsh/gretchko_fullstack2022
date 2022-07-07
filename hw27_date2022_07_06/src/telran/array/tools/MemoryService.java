package telran.array.tools;

public class MemoryService {

	public static int getMaxArrayMemory() {
		int i = 0;
		int left = 0;
		int right = Integer.MAX_VALUE;
		int middle = (left + right) / 2;
		while (right - left != 1) {
			middle = (right + left) / 2;
			try {
				Integer[] arr = new Integer[middle];
				left = middle;
				System.out.println(i + "\t" + middle + "\ttrue" + "\tleft\t" + left + "\tright\t" + right);
			} catch (OutOfMemoryError e) {
				right = middle;
				System.out.println(i + "\t" + middle + "\tfalse" + "\tleft\t" + left + "\tright\t" + right);
			}
			i++;
		}
		return middle;
	}
}
