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
    assertArrayEquals(expected, result);
    int [][] arr1 = {{1,2,3},{4,5,6}};
    int [][] arr2 = {{1,2},{3,4},{5,6}};
    int [][]arrExpected = {{22,28},{49,64}};
    assertArrayEquals(arrExpected, MatrixTools.multyply(arr1, arr2));
    int [][] arr3 = {{1,4},{2,5},{3,6}};
    int [][]arrExpected2 = {{14,32},{32,77}};
    assertArrayEquals(arrExpected2, MatrixTools.multyply(arr1, arr3));
  }
}
