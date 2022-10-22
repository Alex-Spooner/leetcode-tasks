package medium.longestpalindromicsubstring;

import org.junit.Test;

import static org.junit.Assert.*;

public class PalindromicSubstringFinderImplTest {

    PalindromicSubstringFinder palindromicSubstringFinder = new PalindromicSubstringFinderImpl();

    @Test
    public void positiveTest1(){
        String input = "babad";
        String expectedResult = "bab";
        assertEquals(expectedResult, palindromicSubstringFinder.longestPalindrome(input));
    }

    @Test
    public void positiveTest2(){
        String input = "cbbd";
        String expectedResult = "bb";
        assertEquals(expectedResult, palindromicSubstringFinder.longestPalindrome(input));
    }

    @Test
    public void positiveTest3(){
        String input = "d";
        String expectedResult = "d";
        assertEquals(expectedResult, palindromicSubstringFinder.longestPalindrome(input));
    }

    @Test
    public void positiveTest4(){
        String input = "aaa";
        String expectedResult = "aaa";
        assertEquals(expectedResult, palindromicSubstringFinder.longestPalindrome(input));
    }

    @Test
    public void positiveTest5(){
        String input = "aaaa";
        String expectedResult = "aaaa";
        assertEquals(expectedResult, palindromicSubstringFinder.longestPalindrome(input));
    }

    @Test
    public void positiveTest6(){
        String input = "xaabacxcabaaxcabaax";
        String expectedResult = "xaabacxcabaax";
        assertEquals(expectedResult, palindromicSubstringFinder.longestPalindrome(input));
    }
}