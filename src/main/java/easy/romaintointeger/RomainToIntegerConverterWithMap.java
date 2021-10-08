package easy.romaintointeger;

import java.util.HashMap;
import java.util.Map;

public class RomainToIntegerConverterWithMap implements RomainToIntegerConverter {
    @Override
    public int romanToInt(String s) {
        Map<Character, Integer> romainToIntegerMap = new HashMap<>();
        romainToIntegerMap.put('I', 1);
        romainToIntegerMap.put('V', 5);
        romainToIntegerMap.put('X', 10);
        romainToIntegerMap.put('L', 50);
        romainToIntegerMap.put('C', 100);
        romainToIntegerMap.put('D', 500);
        romainToIntegerMap.put('M', 1000);

        int result = 0;
        char[] charArray = s.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            if (i + 1 < charArray.length && romainToIntegerMap.get(charArray[i]) < romainToIntegerMap.get(charArray[i + 1])) {
                result -= romainToIntegerMap.get(charArray[i]);
            } else {
                result += romainToIntegerMap.get(charArray[i]);
            }
        }
        return result;
    }
}
