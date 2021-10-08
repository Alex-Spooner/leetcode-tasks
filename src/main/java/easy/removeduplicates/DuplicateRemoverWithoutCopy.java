package easy.removeduplicates;

public class DuplicateRemoverWithoutCopy implements DuplicateRemover {
    @Override
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int moveItemIndex = 1;
        int itemToCompare = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (itemToCompare < nums[i]) {
                itemToCompare = nums[moveItemIndex] = nums[i];
                moveItemIndex++;
            }
        }
        return moveItemIndex;
    }
}
