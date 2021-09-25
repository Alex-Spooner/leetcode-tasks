package palindromenumber;

public class PalindromeCheckerSimple implements PalindromeChecker {
    @Override
    public boolean isPalindrome(int x) {
        int[] intDigits = new int[10];
        int base = 10;
        int digitPlace = 0;
        if (x < 0) {
            return false;
        } else if (x < 10) {
            return true;
        } else {
            while (x != 0) {
                int digit = x % base;
                intDigits[digitPlace++] = digit;
                x = (x - digit) / base;
            }
            int middleIndexForDigits = digitPlace / 2;
            for (int j = 0; j < middleIndexForDigits; j++) {
                if (intDigits[j] != intDigits[digitPlace - j - 1]) {
                    return false;
                }
            }
            return true;
        }
    }
}
