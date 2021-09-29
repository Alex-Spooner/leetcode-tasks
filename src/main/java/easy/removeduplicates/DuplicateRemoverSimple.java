package easy.removeduplicates;

public class DuplicateRemoverSimple implements DuplicateRemover {
    @Override
    public int removeDuplicates(int[] nums) {
        int maxItemToSwitch = nums.length;
        for (int i = 0; i < nums.length && maxItemToSwitch > i + 1;) {
            if (i + 1 < nums.length && nums[i] == nums[i + 1]) {
                System.arraycopy(nums, i + 1, nums, i, maxItemToSwitch - i - 1);
                maxItemToSwitch--;
            } else {
                i++;
            }
        }
        return maxItemToSwitch;
    }
}
