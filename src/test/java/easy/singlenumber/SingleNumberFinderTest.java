package easy.singlenumber;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SingleNumberFinderTest {

    SingleNumberFinder singleNumberFinder = new SingleNumberFinderSimple();

    @Test
    public void positiveTest() {
        assertEquals(
                1,
                singleNumberFinder.singleNumber(new int[]{2, 2, 1})
        );
    }

    @Test
    public void positiveTest2() {
        assertEquals(
                4,
                singleNumberFinder.singleNumber(new int[]{4, 1, 2, 1, 2})
        );
    }

    @Test
    public void positiveTest3() {
        assertEquals(
                1,
                singleNumberFinder.singleNumber(new int[]{1})
        );
    }

}