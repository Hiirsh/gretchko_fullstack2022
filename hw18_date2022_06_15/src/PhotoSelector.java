
// import java.lang.reflect.Array;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PhotoSelector {
    public static void main(String[] args) {
        String[] expected = {
                "Paris\\20140101_090000.jpg",
                "Paris\\20140201_121005.jpg",
                "Paris\\20150301_211035.jpg",
                "Paris\\20150401_110023.gif",
                "Paris\\20150401_181705.jpg",
                "Paris\\20150501_231035.gif",
                "London\\20140205_090000.jpg",
                "London\\20140205_121005.jpg",
                "London\\20140601_211035.gif",
                "London\\20151001_110023.jpg",
                "London\\20151001_121705.jpg",
                "London\\20151001_231035.jpg",
                "Chicago\\20150301_120001.png",
                "Chicago\\20151111_232000.png"
        };
        String regex = "(\\d){4}(09|10|11)";
        String[] arr = selectPictures(expected, regex);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(i + "" + arr[i]);
        }
    }

    public static String[] selectPictures(String[] pictures, String regex) {
        int newLength = 0;
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(pictures[0]);
        newLength = matcher.find() ? 1 : 0;
        for (int i = 1; i < pictures.length; i++) {
            matcher = pattern.matcher(pictures[i]);
            newLength = matcher.find() ? newLength + 1 : newLength;
            matcher.reset();
        }
        String[] arr = new String[newLength];
        for (int i = 0, j = 0; i < pictures.length; i++) {
            matcher = pattern.matcher(pictures[i]);
            if (matcher.find()) {
                arr[j] = pictures[i];
                j++;
                matcher.reset();
            }
        }
        return arr;
    }
}
