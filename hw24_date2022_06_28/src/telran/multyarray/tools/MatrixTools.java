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
    int l = matr1.length;
    if (l != matr2[0].length) {
      return null;
    }

    int[][] res = new int[l][l];
    for (int i = 0; i < l; i++) {
      for (int j = 0; j < l; j++) {
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
