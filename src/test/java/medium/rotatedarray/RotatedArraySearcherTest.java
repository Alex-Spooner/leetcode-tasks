package medium.rotatedarray;

import org.junit.Test;

import static org.junit.Assert.*;

public class RotatedArraySearcherTest {

    public RotatedArraySearcher rotatedArraySearcher = new RotatedArraySearcherImpl();

    @Test
    public void positiveTest1() {
        int[] input = {4, 5, 6, 7, 0, 1, 2};
        int target = 0;
        assertEquals(4, rotatedArraySearcher.search(input, target));
    }

    @Test
    public void positiveTest2() {
        int[] input = {4, 5, 6, 7, 0, 1, 2};
        int target = 3;
        assertEquals(-1, rotatedArraySearcher.search(input, target));
    }

    @Test
    public void positiveTest3() {
        int[] input = {1};
        int target = 0;
        assertEquals(-1, rotatedArraySearcher.search(input, target));
    }

    @Test
    public void positiveTest4() {
        int[] input = {5, 1, 3};
        int target = 3;
        assertEquals(2, rotatedArraySearcher.search(input, target));
    }

    @Test
    public void positiveTest5() {
        int[] input = {4, 5, 6, 7, 8, 1, 2, 3};
        int target = 8;
        assertEquals(4, rotatedArraySearcher.search(input, target));
    }

    @Test
    public void positiveTest6() {
        int[] input = {5, 1, 2, 3, 4};
        int target = 1;
        assertEquals(1, rotatedArraySearcher.search(input, target));
    }

    @Test
    public void positiveTest7() {
        int[] input = {3, 5, 1};
        int target = 3;
        assertEquals(0, rotatedArraySearcher.search(input, target));
    }
}