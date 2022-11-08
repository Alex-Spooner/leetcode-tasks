package draft.insertionsort;

public class InsertionSorterImpl implements InsertionSorter {
    @Override
    public void sort(int[] arr) {
        for (int iterationIndex = 2; iterationIndex < arr.length; iterationIndex++) {
            int key = arr[iterationIndex];
            for (int tailIndex = iterationIndex - 1; tailIndex > 0; tailIndex--) {
                if (key < arr[tailIndex]) {
                    arr[tailIndex + 1] = arr[tailIndex];
                    arr[tailIndex] = key;
                }
            }
        }
    }
}
