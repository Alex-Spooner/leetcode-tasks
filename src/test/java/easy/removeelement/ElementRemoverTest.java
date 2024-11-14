package easy.removeelement;

import org.junit.Assert;
import org.junit.Test;

public class ElementRemoverTest {

    ElementRemover elementRemover = new ElementRemover();

    @Test
    public void positiveTest1() {
        int[] inputArray = {3, 2, 2, 3};

        int resultNumNumber = elementRemover.removeElement(inputArray, 3);
        int[] resultArray = new int[resultNumNumber];
        System.arraycopy(inputArray, 0, resultArray, 0, resultNumNumber);

        Assert.assertArrayEquals(
                new int[]{2, 2},
                resultArray
        );
    }

    @Test
    public void positiveTest2() {
        int[] inputArray = {0,4,4,0,4,4,4,0,2};

        int resultNumNumber = elementRemover.removeElement(inputArray, 4);
        int[] resultArray = new int[resultNumNumber];
        System.arraycopy(inputArray, 0, resultArray, 0, resultNumNumber);

        Assert.assertArrayEquals(
                new int[]{0,0,2,0},
                resultArray
        );
    }
}