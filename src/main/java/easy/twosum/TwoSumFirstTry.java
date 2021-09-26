package easy.twosum;

public class TwoSumFirstTry implements SumCalculator{
    @Override
    public int[] twoSum(int[] nums, int target) {
        if (nums == null) {
            return null;
        }

        int[] firstCandidatesIndexes = new int[nums.length];
        int j = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            firstCandidatesIndexes[j++] = i;
            for (int firstCandidateIndex : firstCandidatesIndexes) {
                if ((nums[i + 1] + nums[firstCandidateIndex]) == target) {
                    return new int[]{firstCandidateIndex, i + 1};
                }
            }
        }
        return null;
    }
}
