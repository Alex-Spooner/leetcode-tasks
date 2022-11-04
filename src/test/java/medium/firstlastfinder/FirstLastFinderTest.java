package medium.firstlastfinder;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;
import static utils.ArrayUtils.convertArrayToList;

public class FirstLastFinderTest {

    public static FirstLastFinder firstLastFinder = new FirstLastFinderImpl();

    @Test
    public void positiveTest1() {
        int[] inputs = {5, 7, 7, 8, 8, 10};
        int target = 8;
        int[] expectedResult = {3, 4};
        int[] actualResult = firstLastFinder.searchRange(inputs, target);
        List<Integer> expectedList = convertArrayToList(expectedResult);
        List<Integer> actualList = convertArrayToList(actualResult);
        assertTrue(expectedList.containsAll(actualList));
        assertTrue(actualList.containsAll(expectedList));
    }

    @Test
    public void positiveTest2() {
        int[] inputs = {5, 7, 7, 8, 8, 10};
        int target = 6;
        int[] expectedResult = {-1, -1};
        int[] actualResult = firstLastFinder.searchRange(inputs, target);
        List<Integer> expectedList = convertArrayToList(expectedResult);
        List<Integer> actualList = convertArrayToList(actualResult);
        assertTrue(expectedList.containsAll(actualList));
        assertTrue(actualList.containsAll(expectedList));
    }

    @Test
    public void positiveTest3() {
        int[] inputs = {};
        int target = 0;
        int[] expectedResult = {-1, -1};
        int[] actualResult = firstLastFinder.searchRange(inputs, target);
        List<Integer> expectedList = convertArrayToList(expectedResult);
        List<Integer> actualList = convertArrayToList(actualResult);
        assertTrue(expectedList.containsAll(actualList));
        assertTrue(actualList.containsAll(expectedList));
    }

    @Test
    public void positiveTest4() {
        int[] inputs = {1, 1, 1, 1, 1, 1, 1};
        int target = 1;
        int[] expectedResult = {0, 6};
        int[] actualResult = firstLastFinder.searchRange(inputs, target);
        List<Integer> expectedList = convertArrayToList(expectedResult);
        List<Integer> actualList = convertArrayToList(actualResult);
        assertTrue(expectedList.containsAll(actualList));
        assertTrue(actualList.containsAll(expectedList));
    }

    @Test
    public void positiveTest5() {
        int[] inputs = {2, 2};
        int target = 2;
        int[] expectedResult = {0, 1};
        int[] actualResult = firstLastFinder.searchRange(inputs, target);
        List<Integer> expectedList = convertArrayToList(expectedResult);
        List<Integer> actualList = convertArrayToList(actualResult);
        assertTrue(expectedList.containsAll(actualList));
        assertTrue(actualList.containsAll(expectedList));
    }

    @Test
    public void positiveTest6() {
        int[] inputs = {1, 3};
        int target = 1;
        int[] expectedResult = {0, 0};
        int[] actualResult = firstLastFinder.searchRange(inputs, target);
        List<Integer> expectedList = convertArrayToList(expectedResult);
        List<Integer> actualList = convertArrayToList(actualResult);
        assertTrue(expectedList.containsAll(actualList));
        assertTrue(actualList.containsAll(expectedList));
    }
}