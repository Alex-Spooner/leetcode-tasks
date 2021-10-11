package easy.mysqrt;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class MySqrtTest {

    private final MySqrt mySqrt;

    public MySqrtTest(MySqrt mySqrt) {
        this.mySqrt = mySqrt;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {new MySqrtImpl()}, {new MySqrtNewton()}
        });
    }

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

    @Test
    public void positiveTest4(){
        assertEquals(
                1,
                mySqrt.mySqrt(3)
        );
    }

}