package easy.twosum;

import java.util.HashMap;
import java.util.Map;

public class SumCalculatorWithMap implements SumCalculator {
    @Override
    public int[] twoSum(int[] nums, int target) {
        if (nums == null) {
            return null;
        }

        Map<Integer, Integer> numsWithIndexes = new HashMap<>();
        int i = 0;
        for (int num : nums) {
            numsWithIndexes.put(num, i++);
        }

        Integer secondIndex;
        for (int j = 0; j < nums.length; j++) {
            if ((secondIndex = numsWithIndexes.get(target - nums[j])) != null && secondIndex != j) {
                return new int[]{j, secondIndex};
            }
        }

        return null;
    }
}
