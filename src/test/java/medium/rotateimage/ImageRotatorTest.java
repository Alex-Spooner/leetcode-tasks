package medium.rotateimage;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class ImageRotatorTest {

    public static ImageRotator imageRotator = new ImageRotatorImpl();

    @Test
    public void positiveTest1() {
        int[][] input = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] expectedResult = {{7, 4, 1}, {8, 5, 2}, {9, 6, 3}};
        imageRotator.rotate(input);
        assertTrue(Arrays.deepEquals(expectedResult, input));
    }

    @Test
    public void positiveTest2() {
        int[][] input = {{5, 1, 9, 11}, {2, 4, 8, 10}, {13, 3, 6, 7}, {15, 14, 12, 16}};
        int[][] expectedResult = {{15, 13, 2, 5}, {14, 3, 4, 1}, {12, 6, 8, 9}, {16, 7, 10, 11}};
        imageRotator.rotate(input);
        assertTrue(Arrays.deepEquals(expectedResult, input));
    }

    @Test
    public void positiveTest3() {
        int[][] input = {{1, 2}, {3, 4}};
        int[][] expectedResult = {{3, 1}, {4, 2}};
        imageRotator.rotate(input);
        assertTrue(Arrays.deepEquals(expectedResult, input));
    }

    @Test
    public void positiveTest4() {
        int[][] input = {{1}};
        int[][] expectedResult = {{1}};
        imageRotator.rotate(input);
        assertTrue(Arrays.deepEquals(expectedResult, input));
    }
}