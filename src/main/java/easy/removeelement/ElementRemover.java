package easy.removeelement;

public class ElementRemover {

    public int removeElement(int[] nums, int val) {
        int indexToCopy = 0;
        int indexToTraverseTo = nums.length;
        for (int index = 0; index < indexToTraverseTo; index++) {
            if (nums[index] == val) {
                if (index > 0 && (nums[index - 1] != val)) {
                    indexToCopy = index;
                }

                if ((index < nums.length - 1)) {
                    if ((nums[index + 1] != val)) {
                        System.arraycopy(nums, index + 1, nums, indexToCopy, nums.length - (index + 1));
                        indexToTraverseTo = indexToTraverseTo - (index - indexToCopy + 1);
                    }
                }
            }
        }

        return (indexToTraverseTo + 1);
    }
}
