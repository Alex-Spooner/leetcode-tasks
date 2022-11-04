package utils;

import java.util.ArrayList;
import java.util.List;

public class ArrayUtils {
    public static List<Integer> convertArrayToList(int[] array) {
        List<Integer> result = new ArrayList<>();
        for (int integer : array) {
            result.add(integer);
        }
        return result;
    }
}