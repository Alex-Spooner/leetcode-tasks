package medium.longestsubsrtring;

import org.junit.Test;

import static org.junit.Assert.*;

public class LongestSubstringFinderTest {

    public static LongestSubstringFinder longestSubstringFinder = new LongestSubstringFinderImpl();

    @Test
    public void positiveTest1() {
        String input = "abcabcbb";
        int expectedResult = 3;
        assertEquals(expectedResult, longestSubstringFinder.lengthOfLongestSubstring(input));
    }

    @Test
    public void positiveTest2() {
        String input = "bbbbb";
        int expectedResult = 1;
        assertEquals(expectedResult, longestSubstringFinder.lengthOfLongestSubstring(input));
    }

    @Test
    public void positiveTest3() {
        String input = "pwwkew";
        int expectedResult = 3;
        assertEquals(expectedResult, longestSubstringFinder.lengthOfLongestSubstring(input));
    }

    @Test
    public void positiveTest4() {
        String input = " ";
        int expectedResult = 1;
        assertEquals(expectedResult, longestSubstringFinder.lengthOfLongestSubstring(input));
    }

    @Test
    public void positiveTest5() {
        String input = "tmmzuxt";
        int expectedResult = 5;
        assertEquals(expectedResult, longestSubstringFinder.lengthOfLongestSubstring(input));
    }

    @Test
    public void positiveTest6() {
        String input = "bbtablud";
        int expectedResult = 6;
        assertEquals(expectedResult, longestSubstringFinder.lengthOfLongestSubstring(input));
    }

    @Test
    public void positiveTest7() {
        String input = "cdd";
        int expectedResult = 2;
        assertEquals(expectedResult, longestSubstringFinder.lengthOfLongestSubstring(input));
    }
}