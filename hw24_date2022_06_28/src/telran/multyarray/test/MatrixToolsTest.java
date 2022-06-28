package telran.multyarray.test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import telran.multyarray.tools.MatrixTools;

public class MatrixToolsTest {
  int[][] m1 = { { 1, 2, 3 } };
  int[][] m2 = { { 1 }, { 2 }, { 3 } };
  
  @Test
  void testSum() {
    assertEquals(6, MatrixTools.sum(m1));
  }
  
  @Test
  void testTransp() {
    assertArrayEquals(m2, MatrixTools.transp(m1));
  }
  
  @Test
  void testMultyply() {
    int [][] expected = {{14}};
    int [][] result = MatrixTools.multyply(m1, m2);
    printArray(result);
    assertArrayEquals(expected, result);
    int [][] arr1 = {{1,2,3},{4,5,6}};
    int [][] arr2 = {{1,2},{3,4},{5,6}};
    int [][]arrExpected = {{22,28},{49,64}};
    assertArrayEquals(arrExpected, MatrixTools.multyply(arr1, arr2));
  }

  private static void printArray(int[][] arr) {
    for (int i = 0; i < arr.length; i++) {
      for (int j = 0; j < arr[i].length; j++) {
        System.out.print(arr[i][j]+"\t");
      }
      System.out.print("\n");
    }
  }


}
