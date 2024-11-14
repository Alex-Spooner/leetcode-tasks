package medium.listmerger;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListMerger {

    public int[][] merge(int[][] intervals) {
        List<int[]> resultList = new ArrayList<>();
        List<int[]> intervalList = new ArrayList<>(Arrays.asList(intervals));
        intervalList.sort((a, b) -> a[0] >= b[0] ? (a[0] == b[0] ? 0 : 1) : -1);
        resultList.add(intervalList.get(0));
        for (int i = 0; i < intervals.length - 1; i++) {
            int[] first = resultList.get(resultList.size() - 1);
            int[] second = intervalList.get(i + 1);
            if (first[1] >= second[0]) {
                resultList.set(resultList.size() - 1, new int[]{first[0], Math.max(first[1], second[1])});
            } else {
                resultList.add(second);
            }
        }

        int[][] result = new int[resultList.size()][2];
        for (int i = 0; i < result.length; i++) {
            result[i] = resultList.get(i);
        }
        return result;
    }
}
