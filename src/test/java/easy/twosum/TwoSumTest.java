package easy.twosum;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;


@RunWith(Parameterized.class)
public class TwoSumTest {

    private final SumCalculator twoSum;

    public TwoSumTest(SumCalculator twoSum) {
        this.twoSum = twoSum;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {new TwoSumSimple()}
        });
    }

    @Test
    public void nullTest() {
        Assert.assertNull(twoSum.twoSum(null, 0));
    }

    @Test
    public void firstTwoCorrectTest() {
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        int[] expected = {0, 1};
        Assert.assertArrayEquals(
                expected,
                twoSum.twoSum(nums, target)
        );
    }

    @Test
    public void lastTwoCorrectTest() {
        int[] nums = {3, 2, 4};
        int target = 6;
        int[] expected = {1, 2};
        Assert.assertArrayEquals(
                expected,
                twoSum.twoSum(nums, target)
        );
    }

    @Test
    public void onlyTwoSameCorrectTest() {
        int[] nums = {3, 3};
        int target = 6;
        int[] expected = {0, 1};
        Assert.assertArrayEquals(
                expected,
                twoSum.twoSum(nums, target)
        );
    }

    @Test
    public void bothNegativeAndPositiveTest() {
        int[] nums = {-1, 3, 12, 7, 0};
        int target = 6;
        int[] expected = {0, 3};
        Assert.assertArrayEquals(
                expected,
                twoSum.twoSum(nums, target)
        );
    }

    @Test
    public void negativeTargetTest() {
        int[] nums = {3, 1, 12, 7, 0, -7, 13};
        int target = -6;
        int[] expected = {1, 5};
        Assert.assertArrayEquals(
                expected,
                twoSum.twoSum(nums, target)
        );
    }

}
