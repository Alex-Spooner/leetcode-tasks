package easy.twosum;

public class TwoSumSimple implements SumCalculator {

    public int[] twoSum(int[] nums, int target) {
        if (nums == null) {
            return null;
        }

        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if ((nums[i] + nums[j] == target) && (i != j)) {
                    return new int[]{i, j};
                }
            }
        }

        return null;
    }
}
