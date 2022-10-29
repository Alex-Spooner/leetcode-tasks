package medium.pow;

import org.junit.Test;

import static org.junit.Assert.*;

public class MyPowTest {

    public MyPow myPow = new MyPowImpl();

    @Test
    public void positiveTest1() {
        double x = 2.0;
        int n = 10;
        double expectedResult = 1024.0;
        assertEquals(expectedResult, myPow.myPow(x, n), 0.0);
    }

    @Test
    public void positiveTest2() {
        double x = 2.1;
        int n = 3;
        double expectedResult = 9.261;
        assertEquals(expectedResult, myPow.myPow(x, n), 0.00000000000001);
    }

    @Test
    public void positiveTest3() {
        double x = 2.0;
        int n = -2;
        double expectedResult = 0.25;
        assertEquals(expectedResult, myPow.myPow(x, n), 0.0);
    }

    @Test
    public void positiveTest4() {
        double x = 2.0;
        int n = -2147483648;
        double expectedResult = 0;
        assertEquals(expectedResult, myPow.myPow(x, n), 0.0);
    }

    @Test
    public void positiveTest5() {
        double x = 1.0;
        int n = -2147483648;
        double expectedResult = 1.0;
        assertEquals(expectedResult, myPow.myPow(x, n), 0.0);
    }

    @Test
    public void positiveTest6() {
        double x = -1.0;
        int n = -2147483648;
        double expectedResult = 1.0;
        assertEquals(expectedResult, myPow.myPow(x, n), 0.0);
    }
}