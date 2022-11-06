package medium.rotatedarray;

public class RotatedArraySearcherImpl implements RotatedArraySearcher {
    public int result = -1;

    @Override
    public int search(int[] nums, int target) {
        findTarget(nums, target, 0, nums.length - 1);
        return result;
    }

    private void findTarget(int[] nums, int target, int start, int end) {
        if (start > end) return;
        int middle = start + (end - start) / 2;
        int middleElement = nums[middle];
        if (target < middleElement && nums[start] < nums[end]) {
            findTarget(nums, target, start, middle - 1);
        } else if (target > middleElement && nums[start] < nums[end]) {
            findTarget(nums, target, middle + 1, end);
        } else if (target < middleElement && nums[start] > nums[end]) {
            if (middleElement <= nums[end]) {
                findTarget(nums, target, start, middle - 1);
            } else {
                if (target >= nums[start]) {
                    findTarget(nums, target, start, middle - 1);
                } else {
                    findTarget(nums, target, middle + 1, end);
                }
            }
        } else if (target > middleElement && nums[start] > nums[end]) {
            if (middleElement >= nums[start]){
                findTarget(nums, target, middle + 1, end);
            } else {
                if (target > nums[end]) {
                    findTarget(nums, target, start, middle - 1);
                } else {
                    findTarget(nums, target, middle + 1, end);
                }
            }
        } else {
            if (middleElement == target) {
                result = middle;
            }
        }
    }
}
