package easy.commonprefix;

public class CommonPrefixFinderSimple implements CommonPrefixFinder {
    @Override
    public String longestCommonPrefix(String[] strs) {
        int wordsNumber = strs.length;
        if (wordsNumber == 0) {
            return "";
        }

        char[][] words = new char[wordsNumber][];
        for (int i = 0; i < wordsNumber; i++) {
            String str = strs[i];
            words[i] = str.toCharArray();
        }

        char[] firstWord = words[0];
        if (firstWord.length == 0) {
            return "";
        }

        int resultIndex = getResultIndex(words, firstWord);

        return strs[0].substring(0, resultIndex);
    }

    private int getResultIndex(char[][] words, char[] firstWord) {
        int resultIndex;
        for (resultIndex = 0; resultIndex < firstWord.length; resultIndex++) {
            char firstWordCurrentChar = firstWord[resultIndex];
            for (char[] word : words) {
                if (word.length <= resultIndex || (word[resultIndex] != firstWordCurrentChar)) {
                    return resultIndex;
                }
            }
        }
        return resultIndex;
    }
}
