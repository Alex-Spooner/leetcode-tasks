package easy.validparentheses;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class ParenthesesValidatorTest {

    private final ParenthesesValidator parenthesesValidator;

    public ParenthesesValidatorTest(ParenthesesValidator parenthesesValidator) {
        this.parenthesesValidator = parenthesesValidator;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {new ParenthesesValidatorSimple()}, {new ParenthesesValidatorWithStack()}
        });
    }

    @Test
    public void positiveTest() {
        Assert.assertTrue(parenthesesValidator.isValid("()"));
    }

    @Test
    public void positiveTest2() {
        Assert.assertTrue(parenthesesValidator.isValid("()[]{}"));
    }

    @Test
    public void positiveTest3() {
        Assert.assertTrue(parenthesesValidator.isValid("([()])"));
    }

    @Test
    public void negativeTest() {
        Assert.assertFalse(parenthesesValidator.isValid("(]"));
    }

    @Test
    public void negativeTest2() {
        Assert.assertFalse(parenthesesValidator.isValid("([)]"));
    }

    @Test
    public void negativeTest3() {
        Assert.assertFalse(parenthesesValidator.isValid("([(()]))"));
    }

    @Test
    public void negativeTest4() {
        Assert.assertFalse(parenthesesValidator.isValid("]"));
    }
}