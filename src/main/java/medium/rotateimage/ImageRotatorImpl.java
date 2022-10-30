package medium.rotateimage;

public class ImageRotatorImpl implements ImageRotator {
    @Override
    public void rotate(int[][] matrix) {
        if (matrix == null) return;
        int n = matrix[0].length;
        if (n < 2) return;

        for (int rowIndex = 0; rowIndex < n; rowIndex++) {
            for (int columnIndex = rowIndex; columnIndex < n; columnIndex++) {
                int tmp = matrix[rowIndex][columnIndex];
                matrix[rowIndex][columnIndex] = matrix[columnIndex][rowIndex];
                matrix[columnIndex][rowIndex] = tmp;
            }
        }
        for (int rowIndex = 0; rowIndex < n; rowIndex++) {
            for (int columnIndex = 0; columnIndex < n / 2; columnIndex++) {
                int tmp = matrix[rowIndex][columnIndex];
                int swapIndex = n - columnIndex - 1;
                matrix[rowIndex][columnIndex] = matrix[rowIndex][swapIndex];
                matrix[rowIndex][swapIndex] = tmp;
            }
        }
    }
}
