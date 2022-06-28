package telran.multyarray.tools;

public class MatrixTools {
  public static int sum(int[][] m) {
    int res = 0;
    for (int i = 0; i < m.length; i++) {
      for (int j = 0; j < m[i].length; j++) {
        res += m[i][j];
      }
    }
    return res;
  }

  public static int[][] transp(int[][] m) {
    int[][] res = new int[m[0].length][m.length];
    for (int i = 0; i < m.length; i++) {
      for (int j = 0; j < m[i].length; j++) {
        res[j][i] = m[i][j];
      }
    }
    return res;
  }

  public static int[][] multyply(int[][] matr1, int[][] matr2) {
    int n = matr1.length;
    int n2 = matr2[0].length;
    if (n != n2) {
      return null;
    }
    int m = matr1[0].length;
    int k = matr2.length;

    int[][] res = new int[n][n];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        res[i][j] = getCellValue(matr1, matr2, i, j);
      }
    }

    return res;

  }

  private static int getCellValue(int[][] m1, int[][] m2, int m, int k) {
    int res = 0;
    for (int i = 0; i < m2.length; i++) {
      res += m1[m][i] * m2[i][k];
    }
    return res;
  }
}
