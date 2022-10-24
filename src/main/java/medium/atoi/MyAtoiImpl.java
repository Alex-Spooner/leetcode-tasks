package medium.atoi;

import java.util.Map;
import java.util.Set;

public class MyAtoiImpl implements MyAtoi {
    @Override
    public int myAtoi(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        char[] chars = s.toCharArray();

        int firstNonSpaceSymbol = 0;
        char space = ' ';
        for (int i = 0; i < chars.length; i++) {
            char aChar = chars[i];
            if (aChar != space) {
                firstNonSpaceSymbol = i;
                break;
            } else if (i == chars.length - 1) {
                return 0;
            }
        }

        int firstExpectedDigitSymbol = firstNonSpaceSymbol;
        boolean isNegative = false;
        char minus = '-';
        char plus = '+';
        if (chars[firstNonSpaceSymbol] == minus) {
            isNegative = true;
            firstExpectedDigitSymbol++;
        } else if (chars[firstNonSpaceSymbol] == plus) {
            firstExpectedDigitSymbol++;
        }

        int signFactor = isNegative ? -1 : 1;
        int result = 0;
        boolean firstZero = true;
        char zero = '0';
        Map<Character, Integer> intsMap = Map.of(
                '0', 0,
                '1', 1,
                '2', 2,
                '3', 3,
                '4', 4,
                '5', 5,
                '6', 6,
                '7', 7,
                '8', 8,
                '9', 9
        );
        Set<Character> intsSet = intsMap.keySet();
        for (int i = firstExpectedDigitSymbol; i < chars.length; i++) {
            if (firstZero && chars[i] == zero) {
                continue;
            } else {
                firstZero = false;
            }
            if (intsSet.contains(chars[i])) {
                if (!isNegative && ((result > Integer.MAX_VALUE / 10) || ((result * 10) + intsMap.get(chars[i])) < 0)) {
                    return Integer.MAX_VALUE;
                }
                if (isNegative && ((result < Integer.MIN_VALUE / 10) || ((result * 10) + intsMap.get(chars[i]) * signFactor) > 0)) {
                    return Integer.MIN_VALUE;
                }
                result = result * 10 + intsMap.get(chars[i]) * signFactor;
            } else {
                break;
            }
        }
        return result;
    }
}
