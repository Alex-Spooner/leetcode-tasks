package easy.singlenumber;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class SingleNumberFinderTest {

    private final SingleNumberFinder singleNumberFinder;

    public SingleNumberFinderTest(SingleNumberFinder singleNumberFinder) {
        this.singleNumberFinder = singleNumberFinder;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {new SingleNumberFinderSimple()}, {new SingleNumberFinderXor()}
        });
    }

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

    @Test
    public void xorExperiments() {
        int notUniqueInt = 123;
        int uniqueInt = 321;
        assertEquals(
                uniqueInt,
                notUniqueInt ^ notUniqueInt ^ uniqueInt
        );
    }
}