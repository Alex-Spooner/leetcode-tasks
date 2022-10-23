package medium.maxwater;

import org.junit.Test;

import static org.junit.Assert.*;

public class MaxWaterFinderTest {

    public static MaxWaterFinder maxWaterFinder = new MaxWaterFinderImpl();

    @Test
    public void positiveTest1(){
     int[] inputs = {1,8,6,2,5,4,8,3,7};
     int expectedResult = 49;
        assertEquals(expectedResult, maxWaterFinder.maxArea(inputs));
    }

    @Test
    public void positiveTest2(){
        int[] inputs = {1,1};
        int expectedResult = 1;
        assertEquals(expectedResult, maxWaterFinder.maxArea(inputs));
    }

    @Test
    public void positiveTest3(){
        int[] inputs = {1};
        int expectedResult = 0;
        assertEquals(expectedResult, maxWaterFinder.maxArea(inputs));
    }
}