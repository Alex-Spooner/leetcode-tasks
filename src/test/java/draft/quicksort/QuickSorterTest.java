package draft.quicksort;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;
import static utils.ArrayUtils.convertArrayToList;

public class QuickSorterTest {

    public static QuickSorter quickSorter = new QuickSorterImpl();

    @Test
    public void positiveTest1(){
     int[] actualArray = {5, 9, 4, 6, 5, 3};
     int[] expectedResult = {3, 4, 5, 5, 6, 9};
        List<Integer> expectedList = convertArrayToList(expectedResult);
        quickSorter.quickSort(actualArray);
        List<Integer> actualList = convertArrayToList(actualArray);
        assertTrue(expectedList.containsAll(actualList));
        assertTrue(actualList.containsAll(expectedList));
    }
}