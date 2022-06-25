package telran.datasort.test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import java.util.Arrays;
import java.util.Comparator;

import org.junit.jupiter.api.Test;

public class DateSortTest {
  @Test
  void test() {
    String[] dates = {
        "07.05.2010",
        "10.03.2003",
        "14.07.1998",
        "21.07.1998",
        "15/01/1990",
        "13.04.1990",
    };
    String[] expected = {
        "15/01/1990",
        "13.04.1990",
        "14.07.1998",
        "21.07.1998",
        "10.03.2003",
        "07.05.2010",
    };
    Comparator<String> comp = (d1, d2) -> {
      int y1 = Integer.parseInt(d1.substring(6));
      int y2 = Integer.parseInt(d2.substring(6));
      if (y1 - y2 != 0) {
        return y1 - y2;
      }
      int m1 = Integer.parseInt(d1.substring(3, 5));
      int m2 = Integer.parseInt(d2.substring(3, 5));
      if (m1 - m2 != 0) {
        return m1 - m2;
      }
      int day1 = Integer.parseInt(d1.substring(0, 2));
      int day2 = Integer.parseInt(d2.substring(0, 2));
      return day1 - day2;

    };
    Arrays.sort(dates, comp);
    assertArrayEquals(expected, dates);
  }
}
