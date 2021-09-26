package romaintointeger;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class RomainToIntegerTest {

    private final RomainToIntegerConverter romanToIntegerConverter;

    public RomainToIntegerTest(RomainToIntegerConverter reverter) {
        this.romanToIntegerConverter = reverter;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {new RomainToIntegerConverterSimple()}
        });
    }

    @Test
    public void positiveTest1() {
        Assert.assertEquals(
                3,
                romanToIntegerConverter.romanToInt("III")
        );
    }

    @Test
    public void positiveTest2() {
        Assert.assertEquals(
                4,
                romanToIntegerConverter.romanToInt("IV")
        );
    }

    @Test
    public void positiveTest3() {
        Assert.assertEquals(
                9,
                romanToIntegerConverter.romanToInt("IX")
        );
    }

    @Test
    public void positiveTest4() {
        Assert.assertEquals(
                58,
                romanToIntegerConverter.romanToInt("LVIII")
        );
    }

    @Test
    public void positiveTest5() {
        Assert.assertEquals(
                1994,
                romanToIntegerConverter.romanToInt("MCMXCIV")
        );
    }
}
