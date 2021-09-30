package easy.findstring;

public class StringFinderSimple implements StringFinder {
    @Override
    public int strStr(String haystack, String needle) {
        if (needle.length() == 0) {
            return 0;
        }

        char[] chars = haystack.toCharArray();
        char[] charsToFind = needle.toCharArray();

        int resultIndex = 0;
        boolean foundFirstSameSymbol = false;
        int symbolsFound = 0;
        int searchAgainIndex = 0;
        for (int i = 0; i < chars.length; i++) {
            if (!foundFirstSameSymbol && chars[i] == charsToFind[0]) {
                resultIndex = i;
                foundFirstSameSymbol = true;
            }

            if (foundFirstSameSymbol
                    && ((i - resultIndex) < charsToFind.length)
                    && (chars[i] == charsToFind[i - resultIndex])) {
                symbolsFound++;
                if (chars[i] == chars[resultIndex] && searchAgainIndex < resultIndex) {
                    searchAgainIndex = i;
                }
            } else {
                if (foundFirstSameSymbol) {
                    i = searchAgainIndex;
                }
                foundFirstSameSymbol = false;
                symbolsFound = 0;
            }

            if (symbolsFound == needle.length()) {
                return resultIndex;
            }

        }
        return -1;
    }
}
