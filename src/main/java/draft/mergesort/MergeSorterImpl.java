package draft.mergesort;

public class MergeSorterImpl implements MergeSorter {
    @Override
    public void sort(int[] arr) {
        mergeSort(arr, arr.length);
    }

    private void mergeSort(int[] arr, int n) {
        if (n < 2) {
            return;
        }

        int middle = n / 2;

        int leftArraySize = middle;
        int[] leftArr = new int[leftArraySize];
        for (int i = 0; i < leftArraySize; i++) {
            leftArr[i] = arr[i];
        }

        int rightArraySize = n - middle;
        int[] rightArr = new int[rightArraySize];
        for (int i = middle; i < n; i++) {
            rightArr[i - middle] = arr[i];
        }

        mergeSort(leftArr, leftArraySize);
        mergeSort(rightArr, rightArraySize);

        merge(arr, leftArr, rightArr, leftArraySize, rightArraySize);
    }

    private void merge(int[] arr, int[] leftArr, int[] rightArr, int leftArraySize, int rightArraySize) {
        int resultIndex = 0;
        int leftIndex = 0;
        int rightIndex = 0;
        while (leftIndex < leftArraySize && rightIndex < rightArraySize) {
            if (leftArr[leftIndex] <= rightArr[rightIndex]) {
                arr[resultIndex] = leftArr[leftIndex++];
            } else {
                arr[resultIndex] = rightArr[rightIndex++];
            }
            resultIndex++;
        }

        while (leftIndex < leftArraySize){
            arr[resultIndex++] = leftArr[leftIndex++];
        }

        while (rightIndex < rightArraySize){
            arr[resultIndex++] = rightArr[rightIndex++];
        }
    }
}
