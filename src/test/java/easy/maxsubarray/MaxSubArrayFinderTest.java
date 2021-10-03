package easy.maxsubarray;

import org.junit.Assert;
import org.junit.Test;

public class MaxSubArrayFinderTest {

    private final MaxSubArrayFinder maxSubArrayFinder = new MaxSubArrayFinderSimple();

    @Test
    public void positiveTest() {
        Assert.assertEquals(
                6,
                maxSubArrayFinder.maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4})
        );
    }

    @Test
    public void positiveTest2() {
        Assert.assertEquals(
                1,
                maxSubArrayFinder.maxSubArray(new int[]{1})
        );
    }

    @Test
    public void positiveTest3() {
        Assert.assertEquals(
                23,
                maxSubArrayFinder.maxSubArray(new int[]{5, 4, -1, 7, 8})
        );
    }

    @Test
    public void positiveTest4() {
        Assert.assertEquals(
                8,
                maxSubArrayFinder.maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4, -1, 2, 1, 1})
        );
    }

    @Test
    public void positiveTest5() {
        Assert.assertEquals(
                1,
                maxSubArrayFinder.maxSubArray(new int[]{-2, 1, -3})
        );
    }

    @Test
    public void positiveTest6() {
        Assert.assertEquals(
                -1,
                maxSubArrayFinder.maxSubArray(new int[]{-2, -1, -3})
        );
    }

    @Test
    public void positiveTest7() {
        Assert.assertEquals(
                3,
                maxSubArrayFinder.maxSubArray(new int[]{1, 2})
        );
    }

    @Test
    public void positiveTest8() {
        Assert.assertEquals(
                6,
                maxSubArrayFinder.maxSubArray(new int[]{1, 2, -1, -3, -5, 6})
        );
    }

    @Test
    public void positiveTest9() {
        Assert.assertEquals(
                21,
                maxSubArrayFinder.maxSubArray(new int[]{8, -19, 5, -4, 20})
        );
    }

}