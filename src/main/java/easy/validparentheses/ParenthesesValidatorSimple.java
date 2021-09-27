package easy.validparentheses;

import java.util.regex.Pattern;

public class ParenthesesValidatorSimple implements ParenthesesValidator {
    @Override
    public boolean isValid(String s) {
        int stringLengthBefore = s.length();
        int stingLengthAfter = 0;
        Pattern pattern = Pattern.compile("\\(\\)|\\[\\]|\\{\\}");
        while (stingLengthAfter < stringLengthBefore) {
            stringLengthBefore = s.length();
            s = pattern.matcher(s).replaceAll("");
            stingLengthAfter = s.length();
        }
        return s.length() == 0;
    }
}
