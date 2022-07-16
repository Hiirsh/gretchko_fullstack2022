package telran.list.tests;

import org.junit.jupiter.api.Test;

import telran.list.interfaces.IList;
import telran.list.model.MyLinkedList;

class ListTest {

	@Test
	void test() {
		IList<Integer> list = new MyLinkedList<>();
		// // System.out.println(list.size());
		list.add(0);
		list.add(1);
		list.add(2);
		// list.add(2);
		// list.add(7);
		// list.add(3);
		// list.add(5);
		// list.add(null);
		// list.add(7);
		// // System.out.println(list.size());
		// // System.out.println(list.get(1));
		// // System.out.println(list.get(4));
		// // System.out.println(list.indexOf(7));
		// // System.out.println(list.lastIndexOf(7));
		// // System.out.println(list.indexOf(null));
		// // System.out.println(list.contains(11));
		// // System.out.println(list.isEmpty());
		// // list.remove((Integer)3);
		// // System.out.println(list.contains(3));
		// // System.out.println(list.contains(5));
		// // Integer x = list.set(3, 11);
		// // System.out.println(x);
		// // System.out.println(list.get(3));
		System.out.println("===== Homework =====");
		System.out.println(list.size());
		list.add(3, 10);
		System.out.println(list.size());
		System.out.println("--- Array ---");
		for (Integer n : list) {
			System.out.println(n);
		}
		System.out.println(list.size());
		System.out.println("--- Clear ---");
		list.clear();
		System.out.println(list.size());

		System.out.println("======== List of String ==========");
		IList<String> myList = new MyLinkedList<>();
		myList.add("Boston");
		myList.add("Atlanta");
		myList.add("Chicago");
		myList.add("Boston");
		myList.add("New York");
		// System.out.println("myList.size()\t" + myList.size());
		// System.out.println("myList.get(3)\t" + myList.get(3));
		// System.out.println("myList.indexOf(\"Boston\")\t" +	myList.indexOf("Boston"));
		// System.out.println("myList.remove(0)\t" + myList.remove(0));
		// System.out.println("myList.size()\t" + myList.size());
		// System.out.println("myList.remove(\"Boston\")\t" +	myList.remove("Boston"));
		// System.out.println("myList.contains(\"Boston\")\t" +	myList.contains("Boston"));
		// System.out.println("myList.add(2, \"Boston\")\t" + myList.add(2,	"Boston"));
		// System.out.println("myList.size()\t" + myList.size());
		// System.out.println("myList.get(2)\t" + myList.get(2));
		myList.add(2, null);
		for (String str : myList) {
		System.out.println(str);
		}
		myList.clear();
	}

}
