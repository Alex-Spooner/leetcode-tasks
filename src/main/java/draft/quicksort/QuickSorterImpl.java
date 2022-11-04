package draft.quicksort;

public class QuickSorterImpl implements QuickSorter {
    @Override
    public void quickSort(int[] arr) {
        quickSort(arr, 0, (arr.length - 1));
    }

    private void quickSort(int[] arr, int start, int end) {
        if (start >= end) {
            return;
        }

        int pivotIndex = start - 1;
        int pivot = arr[end];
        for (int index = start; index < end; index++) {
            if (arr[index] <= pivot) {
                pivotIndex++;

                int tmp = arr[index];
                arr[index] = arr[pivotIndex];
                arr[pivotIndex] = tmp;
            }
        }

        pivotIndex++;
        int tmp = arr[end];
        arr[end] = arr[pivotIndex];
        arr[pivotIndex] = tmp;

        quickSort(arr, start, pivotIndex - 1);
        quickSort(arr, pivotIndex + 1, end);
    }
}
