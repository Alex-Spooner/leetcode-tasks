package easy.mergesortedarray;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class ArrayMergerTest {

    private final ArrayMerger arrayMerger;

    public ArrayMergerTest(ArrayMerger arrayMerger) {
        this.arrayMerger = arrayMerger;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {new ArrayMergerImpl()}
        });
    }

    @Test
    public void positiveTest() {
        int[] firstArray = new int[]{1, 2, 3, 0, 0, 0};
        int firstIndex = 3;
        int[] secondArray = new int[]{2, 5, 6};
        int secondIndex = 3;
        arrayMerger.merge(firstArray, firstIndex, secondArray, secondIndex);
        Assert.assertArrayEquals(
                new int[]{1, 2, 2, 3, 5, 6},
                firstArray
        );
    }

    @Test
    public void positiveTest2() {
        int[] firstArray = new int[]{1};
        int firstIndex = 1;
        int[] secondArray = new int[]{};
        int secondIndex = 0;
        arrayMerger.merge(firstArray, firstIndex, secondArray, secondIndex);
        Assert.assertArrayEquals(
                new int[]{1},
                firstArray
        );
    }

    @Test
    public void positiveTest3() {
        int[] firstArray = new int[]{0};
        int firstIndex = 0;
        int[] secondArray = new int[]{1};
        int secondIndex = 1;
        arrayMerger.merge(firstArray, firstIndex, secondArray, secondIndex);
        Assert.assertArrayEquals(
                new int[]{1},
                firstArray
        );
    }


    @Test
    public void positiveTest4() {
        int[] firstArray = new int[]{3, 4, 5, 0, 0, 0};
        int firstIndex = 3;
        int[] secondArray = new int[]{1, 2, 3};
        int secondIndex = 3;
        arrayMerger.merge(firstArray, firstIndex, secondArray, secondIndex);
        Assert.assertArrayEquals(
                new int[]{1, 2, 3, 3, 4, 5},
                firstArray
        );
    }

    @Test
    public void positiveTest5() {
        int[] firstArray = new int[]{1, 2, 5, 0, 0};
        int firstIndex = 3;
        int[] secondArray = new int[]{3, 4};
        int secondIndex = 2;
        arrayMerger.merge(firstArray, firstIndex, secondArray, secondIndex);
        Assert.assertArrayEquals(
                new int[]{1, 2, 3, 4, 5},
                firstArray
        );
    }

    @Test
    public void positiveTest6() {
        int[] firstArray = new int[]{1, 2, 3, 0, 0};
        int firstIndex = 3;
        int[] secondArray = new int[]{4, 5};
        int secondIndex = 2;
        arrayMerger.merge(firstArray, firstIndex, secondArray, secondIndex);
        Assert.assertArrayEquals(
                new int[]{1, 2, 3, 4, 5},
                firstArray
        );
    }

}