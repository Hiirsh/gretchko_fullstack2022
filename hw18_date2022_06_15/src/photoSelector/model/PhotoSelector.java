package photoSelector.model;

// import java.lang.reflect.Array;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PhotoSelector {

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
