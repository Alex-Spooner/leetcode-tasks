package easy.mergesortedarray;

public class ArrayMergerImpl implements ArrayMerger {
    @Override
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int firstArrayIndex = m - 1;
        int secondArrayIndex = n - 1;
        for (int j = nums1.length - 1; j >= 0; j--) {
            if (firstArrayIndex >= 0 && secondArrayIndex >= 0) {
                if (nums1[firstArrayIndex] > nums2[secondArrayIndex]) {
                    nums1[j] = nums1[firstArrayIndex];
                    firstArrayIndex--;
                } else {
                    nums1[j] = nums2[secondArrayIndex];
                    secondArrayIndex--;
                }
            } else if (secondArrayIndex >= 0) {
                nums1[j] = nums2[secondArrayIndex];
                secondArrayIndex--;
            }
        }
    }
}
