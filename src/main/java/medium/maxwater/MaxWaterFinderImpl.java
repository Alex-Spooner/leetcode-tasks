package medium.maxwater;

public class MaxWaterFinderImpl implements MaxWaterFinder {
    @Override
    public int maxArea(int[] height) {
        if (height.length < 2) {
            return 0;
        }

        int result = 0;
        for (int j = 0; j < height.length; j++) {
            if (j > 0) {
                for (int i = 0; i < j; i++) {
                    int currentResult = Math.min(height[j], height[i]) * (j - i);
                    if (currentResult > result) {
                        result = currentResult;
                    }
                }
            }
        }

        return result;
    }
}
