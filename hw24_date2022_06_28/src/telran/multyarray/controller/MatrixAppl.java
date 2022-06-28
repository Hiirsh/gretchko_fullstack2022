package telran.multyarray.controller;

import telran.multyarray.tools.MatrixTools;

public class MatrixAppl {
  public static void main(String[] args) {
    int [][] arr1 = {{1,2,3},{4,5,6}};
    int [][] arr2 = {{1,2},{3,4},{5,6}};
    MatrixTools.multyply(arr1, arr2);
  }
}
