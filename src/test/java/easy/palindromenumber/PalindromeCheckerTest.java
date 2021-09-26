package easy.palindromenumber;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class PalindromeCheckerTest {

    private final PalindromeChecker palindromeChecker;

    public PalindromeCheckerTest(PalindromeChecker palindromeChecker) {
        this.palindromeChecker = palindromeChecker;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {new PalindromeCheckerSimple()}
        });
    }

    @Test
    public void positivePalindromeTest() {
        Assert.assertTrue(
                palindromeChecker.isPalindrome(121)
        );
    }

    @Test
    public void positivePalindrome2Test() {
        Assert.assertTrue(
                palindromeChecker.isPalindrome(11)
        );
    }

    @Test
    public void positivePalindrome4Test() {
        Assert.assertTrue(
                palindromeChecker.isPalindrome(1)
        );
    }

    @Test
    public void positivePalindrome3Test() {
        Assert.assertTrue(
                palindromeChecker.isPalindrome(0)
        );
    }

    @Test
    public void positiveNumberNotPalindromeTest() {
        Assert.assertFalse(
                palindromeChecker.isPalindrome(10)
        );
    }

    @Test
    public void negativeNumberNotPalindromeTest() {
        Assert.assertFalse(
                palindromeChecker.isPalindrome(-121)
        );
    }

    @Test
    public void negativeNumberNotPalindrome2Test() {
        Assert.assertFalse(
                palindromeChecker.isPalindrome(-101)
        );
    }
}
