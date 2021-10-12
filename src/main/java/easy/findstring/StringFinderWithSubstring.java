package easy.findstring;

public class StringFinderWithSubstring implements StringFinder {
    @Override
    public int strStr(String haystack, String needle) {
        if (needle.length() == 0) {
            return 0;
        }

        int needleLength = needle.length();
        int haystackLength = haystack.length();
        for (int i = 0; i + needleLength - 1 < haystackLength; i++) {
            if (needle.equals(haystack.substring(i, i + needleLength))) {
                return i;
            }
        }

        return -1;
    }
}
