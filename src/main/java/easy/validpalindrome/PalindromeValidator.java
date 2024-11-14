package easy.validpalindrome;

import java.util.HashMap;
import java.util.Map;

public class PalindromeValidator {

    public boolean isPalindrome(String s) {
        String regex = "[^A-Za-z0-9]";
        String normalisedS = s.toLowerCase().replaceAll(regex, "");
        char[] normalisedChars = normalisedS.toCharArray();
        for (int i = 0; i < normalisedChars.length / 2; i++) {
            if (normalisedChars[i] != normalisedChars[normalisedChars.length - 1 - i]) {
                return false;
            }
        }
        return true;
    }
}
