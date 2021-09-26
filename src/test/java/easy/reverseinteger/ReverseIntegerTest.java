package easy.reverseinteger;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class ReverseIntegerTest {

    private final IntegerReverser integerReverser;

    public ReverseIntegerTest(IntegerReverser integerReverser) {
        this.integerReverser = integerReverser;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {new ReverseIntegerSimple()}
        });
    }

    @Test
    public void zeroTest() {
        Assert.assertEquals(
                0,
                integerReverser.reverse(0)
        );
    }

    @Test
    public void positiveNumberTest() {
        Assert.assertEquals(
                321,
                integerReverser.reverse(123)
        );
    }

    @Test
    public void positiveNumber2Test() {
        Assert.assertEquals(
                4321,
                integerReverser.reverse(1234)
        );
    }

    @Test
    public void negativeNumberTest() {
        Assert.assertEquals(
                -321,
                integerReverser.reverse(-123)
        );
    }

    @Test
    public void numberWithLastZeroTest() {
        Assert.assertEquals(
                21,
                integerReverser.reverse(120)
        );
    }

    @Test
    public void bigPositiveIntegerTest() {
        Assert.assertEquals(
                0,
                integerReverser.reverse(1534236469)
        );
    }

    @Test
    public void bigNegativeIntegerTest() {
        Assert.assertEquals(
                0,
                integerReverser.reverse(-1534236469)
        );
    }

    @Test
    public void negativeIntegerWithSeveralZeroTest() {
        Assert.assertEquals(
                -109,
                integerReverser.reverse(-901000)
        );
    }
}
