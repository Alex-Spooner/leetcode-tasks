package medium.firstlastfinder;

public class FirstLastFinderImpl implements FirstLastFinder {

    @Override
    public int[] searchRange(int[] nums, int target) {
        int firstPosition = bynarySearch(nums, target, true);
        int secondPositions = bynarySearch(nums, target, false);
        return new int[]{firstPosition, secondPositions};
    }

    private int bynarySearch(int[] nums, int target, boolean needToFindFirst) {
        int left = 0;
        int result = -1;
        int right = nums.length - 1;
        while (left <= right) {
            int base = left + (right - left) / 2;
            if (target > nums[base]) {
                left = base + 1;
            } else if (target < nums[base]) {
                right = base - 1;
            } else {
                result = base;
                if (needToFindFirst) {
                    right = right - 1;
                } else {
                    left = left + 1;
                }
            }
        }
        return result;
    }
}
