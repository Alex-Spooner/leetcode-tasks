package medium.longestsubsrtring;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringFinderImpl implements LongestSubstringFinder {

    @Override
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        Map<Character, Integer> lastIndexForCharacter = new HashMap<>();
        int result = 0;
        int currentResult = 0;
        int currentBeginIndex = 0;
        char[] charArray = s.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            char c = charArray[i];
            Integer lastCharIndex = lastIndexForCharacter.put(c, i);
            currentResult++;
            if (lastCharIndex != null && lastCharIndex >= currentBeginIndex) {
                currentResult = currentResult - (lastCharIndex - currentBeginIndex) - 1;
                currentBeginIndex = lastCharIndex + 1;
            }
            if (currentResult > result) {
                result = currentResult;
            }
        }
        return result;
    }
}
