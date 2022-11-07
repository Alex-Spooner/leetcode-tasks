package draft.insertionsort;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;
import static utils.ArrayUtils.convertArrayToList;

public class InsertionSorterTest {

    public static InsertionSorter insertionSorter = new InsertionSorterImpl();

    @Test
    public void positiveTest1(){
        int[] actualArray = {5, 9, 4, 6, 5, 3};
        int[] expectedResult = {3, 4, 5, 5, 6, 9};
        List<Integer> expectedList = convertArrayToList(expectedResult);
        insertionSorter.insertionSort(actualArray);
        List<Integer> actualList = convertArrayToList(actualArray);
        assertTrue(expectedList.containsAll(actualList));
        assertTrue(actualList.containsAll(expectedList));
    }

    @Test
    public void positiveTest2(){
        int[] actualArray = {6, 2, 3, 4, 5, 1};
        int[] expectedResult = {1, 2, 3, 4, 5, 6};
        List<Integer> expectedList = convertArrayToList(expectedResult);
        insertionSorter.insertionSort(actualArray);
        List<Integer> actualList = convertArrayToList(actualArray);
        assertTrue(expectedList.containsAll(actualList));
        assertTrue(actualList.containsAll(expectedList));
    }
}