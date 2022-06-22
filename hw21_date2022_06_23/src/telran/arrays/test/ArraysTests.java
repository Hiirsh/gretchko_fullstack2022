package telran.arrays.test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import telran.arrays.tools.ArrayTools;

public class ArraysTests {
    Integer[] arrNum;
    String[] arrStr;

    @BeforeEach
    void setUp() throws Exception {
        arrNum = new Integer[] { 9, 4, 5, 1, 2, 3, 7, 6, 10 };
        arrStr = new String[] { "one", "two", "three" };
    }

    @Test
    void testPrintArray() {
        System.out.println("Test printArray");
        ArrayTools.printArray(arrNum);
        ArrayTools.printArray(arrStr);
    }

    @Test
    void testFindFirst() {
        System.out.println("Test findFirst");
        Integer[] arrNum = { 1, 2, 3, 4, 5 };
        int res = ArrayTools.findFirst(arrNum, n -> n % 2 == 0);
        System.out.println(res);
    }

    @Test
    void testBubleSortInteger() {
        System.out.println("Test BubleSortInteger");
        ArrayTools.bubbleSort(arrNum);
        ArrayTools.printArray(arrNum);
    }

    @Test
    void testBubleSortComparator() {
        System.out.println("Test BubleSortInteger");
        ArrayTools.bubbleSort(arrStr, (s1, s2) -> s1.length() - s2.length());
        ArrayTools.printArray(arrStr);
    }

    @Test
    void testBubleSortEvenOdd() {
        System.out.println("Test BubleSortInteger");
        ArrayTools.bubbleSort(arrNum,
                (s1, s2) -> s1 % 2 != 0 ? (s2 % 2 == 0 ? 1 : s2 - s1) : (s2 % 2 != 0 ? -1 : s1 - s2));
        ArrayTools.printArray(arrNum);
    }
}
