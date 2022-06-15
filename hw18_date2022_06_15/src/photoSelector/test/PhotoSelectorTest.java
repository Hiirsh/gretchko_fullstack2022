package photoSelector.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Test;

import photoSelector.model.PhotoSelector;

public class PhotoSelectorTest {
    private static final String[] pictures = {
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

    @Test
    public void testAllEuropePictures() {
        String[] actual = PhotoSelector.selectPictures(pictures, "(Paris|London)");
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
        };
        assertArrayEquals(expected, actual);
    }

    @Test
    public void testAllAutumnPictures() {
        String[] actual = PhotoSelector.selectPictures(pictures, "\\d{4}(09|10|11)\\d{2}");
        String[] expected = {
                "London\\20151001_110023.jpg",
                "London\\20151001_121705.jpg",
                "London\\20151001_231035.jpg",
                "Chicago\\20151111_232000.png"
        };
        assertArrayEquals(expected, actual);
    }

    @Test
    public void testAll2015Pictures() {
        String[] actual = PhotoSelector.selectPictures(pictures, "2015\\d{4}");
        String[] expected = {
                "Paris\\20150301_211035.jpg",
                "Paris\\20150401_110023.gif",
                "Paris\\20150401_181705.jpg",
                "Paris\\20150501_231035.gif",
                "London\\20151001_110023.jpg",
                "London\\20151001_121705.jpg",
                "London\\20151001_231035.jpg",
                "Chicago\\20150301_120001.png",
                "Chicago\\20151111_232000.png"
        };
        assertArrayEquals(expected, actual);
    }

    @Test
    public void testAllNightPictures() {
        String[] actual = PhotoSelector.selectPictures(pictures, "_(18|19|2+)");
        String[] expected = {
                "Paris\\20150301_211035.jpg",
                "Paris\\20150401_181705.jpg",
                "Paris\\20150501_231035.gif",
                "London\\20140601_211035.gif",
                "London\\20151001_231035.jpg",
                "Chicago\\20151111_232000.png"
        };
        assertArrayEquals(expected, actual);
    }

    @Test
    public void testAllChicagoPictures() {
        String[] actual = PhotoSelector.selectPictures(pictures, "^Chicago");
        String[] expected = {
                "Chicago\\20150301_120001.png",
                "Chicago\\20151111_232000.png"
        };
        assertArrayEquals(expected, actual);
    }

    @Test
    public void testAllJpgPngPictures() {
        String[] actual = PhotoSelector.selectPictures(pictures, "\\.(jpg|png)");
        String[] expected = {
                "Paris\\20140101_090000.jpg",
                "Paris\\20140201_121005.jpg",
                "Paris\\20150301_211035.jpg",
                "Paris\\20150401_181705.jpg",
                "London\\20140205_090000.jpg",
                "London\\20140205_121005.jpg",
                "London\\20151001_110023.jpg",
                "London\\20151001_121705.jpg",
                "London\\20151001_231035.jpg",
                "Chicago\\20150301_120001.png",
                "Chicago\\20151111_232000.png"
        };
        assertArrayEquals(expected, actual);
    }
}
