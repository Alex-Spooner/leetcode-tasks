package easy.mysqrt;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MySqrtTest {

    MySqrt mySqrt = new MySqrtImpl();

    @Test
    public void positiveTest(){
        assertEquals(
                2,
                mySqrt.mySqrt(8)
        );
    }

    @Test
    public void positiveTest2(){
        assertEquals(
                2,
                mySqrt.mySqrt(4)
        );
    }

    @Test
    public void positiveTest3(){
        assertEquals(
                46340,
                mySqrt.mySqrt(2147395600)
        );
    }

}