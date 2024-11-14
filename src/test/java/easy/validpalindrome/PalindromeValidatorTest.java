package easy.validpalindrome;

import org.junit.Test;

import java.util.*;

import static org.junit.Assert.*;

public class PalindromeValidatorTest {

    PalindromeValidator palindromeValidator = new PalindromeValidator();

    @Test
    public void positiveTest1(){
        boolean isPalindrome = palindromeValidator.isPalindrome("A man, a plan, a canal: Panama");
        assertTrue(isPalindrome);

        Collection<String> test = new ArrayList<>();
    }


    public boolean isIsomorphic(String s, String t) {
        char[] sChars = s.toCharArray();
        Map<Character, List<Integer>> sCharsToPlaces = new HashMap<>();
        for (int i = 0; i < sChars.length; i++) {
            sCharsToPlaces.computeIfAbsent(sChars[i], noUsage -> new ArrayList<>()).add(i);
        }

        char[] tChars = t.toCharArray();
        Map<Character, List<Integer>> tCharsToPlaces = new HashMap<>();
        for (int i = 0; i < tChars.length; i++) {
            tCharsToPlaces.computeIfAbsent(tChars[i], noUsage -> new ArrayList<>()).add(i);
        }

        if (sCharsToPlaces.values().size() != tCharsToPlaces.values().size()) {
            return false;
        }

        for (int j = 0; j < sCharsToPlaces.values().size(); j++) {
            List<Integer> sCharsCurrentPlacesList = sCharsToPlaces.values().iterator().next();
            List<Integer> tCharsCurrentPlacesList = tCharsToPlaces.values().iterator().next();

            if (sCharsCurrentPlacesList.size() != tCharsCurrentPlacesList.size()) {
                return false;
            }

            for (int k = 0; k < sCharsCurrentPlacesList.size(); k++) {
                if (!sCharsCurrentPlacesList.get(k).equals(tCharsCurrentPlacesList.get(k))) {
                    return false;
                }
            }
        }

        return true;
    }
}