package easy.maxprofit;

import org.junit.Assert;
import org.junit.Test;

public class MaxProfitCalculatorTest {

    MaxProfitCalculator maxProfitCalculator = new MaxProfitCalculator();

    @Test
    public void positiveTest1() {
        int[] inputArray = {7,1,5,3,6,4};

        int resultProfit = maxProfitCalculator.maxProfit(inputArray);

        Assert.assertEquals(
                5,
                resultProfit
        );
    }
}