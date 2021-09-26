package easy.commonprefix;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class CommonPrefixFinderTest {
    private final CommonPrefixFinder prefixFinder;

    public CommonPrefixFinderTest(CommonPrefixFinder prefixFinder) {
        this.prefixFinder = prefixFinder;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {new CommonPrefixFinderSimple()}
        });
    }

    @Test
    public void positiveCommonPrefixTest() {
        Assert.assertEquals(
                "fl",
                prefixFinder.longestCommonPrefix(new String[]{"flower", "flow", "flight"})
        );
    }

    @Test
    public void positiveCommonPrefixTest2() {
        Assert.assertEquals(
                "flow",
                prefixFinder.longestCommonPrefix(new String[]{"flower", "flow", "flowed"})
        );
    }

    @Test
    public void positiveCommonPrefixTest3() {
        Assert.assertEquals(
                "f",
                prefixFinder.longestCommonPrefix(new String[]{"flower", "flow", "f"})
        );
    }

    @Test
    public void positiveCommonPrefixTest4() {
        Assert.assertEquals(
                "a",
                prefixFinder.longestCommonPrefix(new String[]{"a"})
        );
    }

    @Test
    public void positiveCommonPrefixTest5() {
        Assert.assertEquals(
                "",
                prefixFinder.longestCommonPrefix(new String[]{})
        );
    }

    @Test
    public void positiveCommonPrefixTest6() {
        Assert.assertEquals(
                "flower",
                prefixFinder.longestCommonPrefix(new String[]{"flower", "flower", "flower", "flower"})
        );
    }

    @Test
    public void positiveNoCommonPrefixTest1() {
        Assert.assertEquals(
                "",
                prefixFinder.longestCommonPrefix(new String[]{"flower", "car", "flight"})
        );
    }

    @Test
    public void positiveNoCommonPrefixTest2() {
        Assert.assertEquals(
                "",
                prefixFinder.longestCommonPrefix(new String[]{"flower", "flow", ""})
        );
    }
}