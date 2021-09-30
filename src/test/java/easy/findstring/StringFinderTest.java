package easy.findstring;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class StringFinderTest {

    private final StringFinder stringFinder;

    public StringFinderTest(StringFinder stringFinder) {
        this.stringFinder = stringFinder;
    }

    @Parameterized.Parameters
    public static Collection<Object> data() {
        return Arrays.asList(new Object[][]{
                {new StringFinderSimple()}
        });
    }

    @Test
    public void positiveTest() {
        Assert.assertEquals(
                2,
                stringFinder.strStr("hello", "ll")
        );
    }

    @Test
    public void positiveTest2() {
        Assert.assertEquals(
                7,
                stringFinder.strStr("hell-hello", "llo")
        );
    }

    @Test
    public void positiveTest3() {
        Assert.assertEquals(
                4,
                stringFinder.strStr("hell-hello", "-")
        );
    }

    @Test
    public void positiveTest4() {
        Assert.assertEquals(
                4,
                stringFinder.strStr("mississippi", "issip")
        );
    }

    @Test
    public void negativeTest() {
        Assert.assertEquals(
                -1,
                stringFinder.strStr("aaaa", "ab")
        );
    }

    @Test
    public void blankSearchStringTest() {
        Assert.assertEquals(
                0,
                stringFinder.strStr("test", "")
        );
    }

    @Test
    public void blankStringsTest() {
        Assert.assertEquals(
                0,
                stringFinder.strStr("", "")
        );
    }
}