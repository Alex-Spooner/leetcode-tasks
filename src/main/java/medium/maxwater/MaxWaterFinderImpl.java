package medium.maxwater;

public class MaxWaterFinderImpl implements MaxWaterFinder {
    @Override
    public int maxArea(int[] height) {
        if (height.length < 2) {
            return 0;
        }

        int result = 0;
        int currentResult;
        int firstWallIndex = 0;
        int secondWallIndex = height.length - 1;
        while (firstWallIndex < secondWallIndex) {
            currentResult = Math.min(height[firstWallIndex], height[secondWallIndex]) * (secondWallIndex - firstWallIndex);
            result = Math.max(result, currentResult);
            if (height[firstWallIndex] > height[secondWallIndex]) {
                secondWallIndex--;
            } else if (height[firstWallIndex] < height[secondWallIndex]) {
                firstWallIndex++;
            } else {
                firstWallIndex++;
                secondWallIndex--;
            }
        }

        return result;
    }

//    Brute Force
//    public int maxArea(int[] height) {
//        if (height.length < 2) {
//            return 0;
//        }
//
//        int result = 0;
//        for (int j = 0; j < height.length; j++) {
//            if (j > 0) {
//                for (int i = 0; i < j; i++) {
//                    int currentResult = Math.min(height[j], height[i]) * (j - i);
//                    if (currentResult > result) {
//                        result = currentResult;
//                    }
//                }
//            }
//        }
//
//        return result;
//    }
}
