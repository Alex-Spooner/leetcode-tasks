package medium.longestpalindromicsubstring;

public class PalindromicSubstringFinderImpl implements PalindromicSubstringFinder {

    @Override
    public String longestPalindrome(String s) {
        String result = s.substring(0, 1);
        char[] charArray = s.toCharArray();
        for (int index = 0; index < charArray.length; index++) {
            if (((index - 1) >= 0)
                    && ((index + 1) < charArray.length)
                    && (charArray[(index - 1)] == charArray[index + 1])) {
                int left = index - 1;
                int right = index + 1;
                if (result.length() < (right - left + 1)) {
                    result = s.substring(left, right + 1);
                }
                while (--left >= 0 && ++right < charArray.length) {
                    if (charArray[left] != charArray[right]) {
                        if (result.length() < (right - left + 1 - 2)) {
                            result = s.substring(left + 1, right);
                        }
                        break;
                    } else if (left == 0 || right == charArray.length - 1) {
                        if (result.length() < (right - left + 1)) {
                            result = s.substring(left, right + 1);
                        }
                    }
                }
            }
            if (((index + 1) < charArray.length)
                    && (charArray[(index)] == charArray[index + 1])) {
                int left = index;
                int right = index + 1;
                if (result.length() < (right - left + 1)) {
                    result = s.substring(left, right + 1);
                }
                while (--left >= 0 && ++right < charArray.length) {
                    if (charArray[left] != charArray[right]) {
                        if (result.length() < (right - left + 1 - 2)) {
                            result = s.substring(left + 1, right);
                        }
                        break;
                    } else if (left == 0 || right == charArray.length - 1) {
                        if (result.length() < (right - left + 1)) {
                            result = s.substring(left, right + 1);
                        }
                    }
                }
            }
        }
        return result;
    }
}
