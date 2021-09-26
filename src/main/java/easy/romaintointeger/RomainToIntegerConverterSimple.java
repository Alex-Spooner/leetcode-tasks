package easy.romaintointeger;

public class RomainToIntegerConverterSimple implements RomainToIntegerConverter {
    @Override
    public int romanToInt(String s) {
        char[] charArray = s.toCharArray();
        int result = 0;
        for (int i = 0; i < charArray.length; i++) {
            char c = charArray[i];
            switch (c) {
                case 'I':
                    result = getResultWithPostfixCheck(charArray, i, 'V', 'X', 1,  result);
                    break;
                case 'V':
                    result = result + 5;
                    break;
                case 'X':
                    result = getResultWithPostfixCheck(charArray, i, 'L', 'C', 10,  result);
                    break;
                case 'L':
                    result = result + 50;
                    break;
                case 'C':
                    result = getResultWithPostfixCheck(charArray, i, 'D', 'M', 100,  result);
                    break;
                case 'D':
                    result = result + 500;
                    break;
                case 'M':
                    result = result + 1000;
                    break;
            }

        }
        return result;
    }

    private int getResultWithPostfixCheck(char[] charArray,
                                          int i,
                                          char firstPostfix,
                                          char secondPostfix,
                                          int increment,
                                          int result) {
        if ((i + 1 < charArray.length) && (charArray[i + 1] == firstPostfix || charArray[i + 1] == secondPostfix)) {
            result = result - increment;
        } else {
            result = result + increment;
        }
        return result;
    }
}
