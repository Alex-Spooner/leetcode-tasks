package easy.singlenumber;

import java.util.HashSet;
import java.util.Set;

public class SingleNumberFinderSimple implements SingleNumberFinder {
    @Override
    public int singleNumber(int[] nums) {
        Set<Integer> uniqueNums = new HashSet<>();
        int numsSum = 0;
        for (int num : nums) {
            numsSum += num;
            uniqueNums.add(num);
        }
        int uniqueNumsSum = 0;
        for (Integer uniqueNum : uniqueNums) {
            uniqueNumsSum += uniqueNum;
        }
        return uniqueNumsSum * 2 - numsSum;
    }
}
