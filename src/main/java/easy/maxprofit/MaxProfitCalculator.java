package easy.maxprofit;

import java.util.*;

public class MaxProfitCalculator {

    public int maxProfit(int[] prices) {
        if( prices.length == 1){
            return 0;
        }
        int buyPrice = prices[0];
        int resultMaxProfit = 0;
        for(int i = 1; i < prices.length ; i++){
            if(buyPrice > prices[i]){
                buyPrice = prices[i];
            } else if ((prices[i] - buyPrice) > resultMaxProfit){
                resultMaxProfit = prices[i] - buyPrice;
            }
        }
        return resultMaxProfit;
    }

    public List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<>();
        if (nums.length == 0){
            return result;
        }
        int start = 0;
        for(int i = 1; i < nums.length; i++){
            if((i+1) == nums.length || (nums[i] + 1) != nums[i+1]){
                if(start != i){
                    result.add(String.format("%d->%d", nums[start], nums[i]));
                } else {
                    result.add(String.format("%d", nums[start]));
                }
                start = i;
            }
        }

        return result;
    }



      public class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode() {}
          TreeNode(int val) { this.val = val; }
          TreeNode(int val, TreeNode left, TreeNode right) {
              this.val = val;
              this.left = left;
              this.right = right;
          }
      }



    public List<Double> averageOfLevels(TreeNode root) {
        List<TreeNode> currentLevel = new ArrayList<>();
        currentLevel.add(root);
        List<TreeNode> nextLevel = new ArrayList<>();
        int currentLevelIndex = 0;
        List<Double> results = new ArrayList<>();
        while(currentLevel.size() != 0){
            results.add(currentLevelIndex, 0.0d);
            for(TreeNode currentLevelNode : currentLevel){
                if(currentLevelNode.left != null){
                    nextLevel.add(currentLevelNode.left);
                }
                if(currentLevelNode.right != null){
                    nextLevel.add(currentLevelNode.right);
                }
                results.set(currentLevelIndex, results.get(currentLevelIndex) + currentLevelNode.val);
            }
            results.set(currentLevelIndex, results.get(currentLevelIndex)/currentLevel.size());
            currentLevel = new ArrayList<>(nextLevel);
            nextLevel = new ArrayList<>();
            currentLevelIndex++;
        }
        return results;
    }


    public class TrieNode {
        public TrieNode(){}
        public Character value;
        public Map<Character, TrieNode> children;
        public Boolean endOfWord;
    }

    private TreeNode calculateNode(int[] nums){
        if(nums.length == 1){
            return new TreeNode(nums[0], null, null);
        }
        int midleIndex = nums.length/2;
        TreeNode left = null;
        if(midleIndex > 0){
            left = calculateNode(Arrays.copyOfRange(nums, 0, midleIndex));
        }
        TreeNode right = null;
        if(midleIndex < (nums.length - 1)){
            left = calculateNode(Arrays.copyOfRange(nums, midleIndex + 1, nums.length));
        }
        return new TreeNode(nums[midleIndex], left, right);
    }




    public int minSubArrayLen(int target, int[] nums) {
        int currentSum = 0;
        int minLength = 0;
        int startIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            currentSum = currentSum + nums[i];

            if (currentSum >= target) {
                minLength = Math.min(i - startIndex + 1, minLength);

                for (int j = minLength; j <= i; j++) {
                    if ((currentSum - nums[j]) > target) {
                        currentSum = currentSum - nums[j];
                        startIndex = j;
                        minLength = Math.min(i - startIndex + 1, minLength);
                    } else {
                        currentSum = currentSum - nums[j];
                        break;
                    }
                }
            }
        }
        return minLength;
    }

    public int[] twoSum(int[] numbers, int target) {
        int firstIndex = 0;
        for (int i = 1; i < numbers.length; i++) {
            if ((numbers[firstIndex] + numbers[i]) == target) {
                return new int[]{firstIndex, i};
            } else if ((numbers[firstIndex] + numbers[i]) < target) {
                for (int j = firstIndex; j < i; j++) {
                    if ((numbers[j] + numbers[i]) == target) {
                        return new int[]{j, i};
                    }
                }
            }
        }
        return new int[]{0, 1};
    }


    public int[][] merge1(int[][] intervals) {
        Map<Integer, List<InvervalInfo>> startEndMap = new TreeMap<>();
        for (int i = 0; i < intervals.length; i++) {
            int start = intervals[i][0];
            int end = intervals[i][1];
            startEndMap.computeIfAbsent(start, (ignore) -> new ArrayList<>()).add(new InvervalInfo(true, i));
            startEndMap.computeIfAbsent(end, (ignore) -> new ArrayList<>()).add(new InvervalInfo(false, i));
        }

        Set<Integer> startedIntervals = new HashSet<>();
        List<Interval> results = new ArrayList<>();
        int currentIndex = 0;
        for (Map.Entry<Integer, List<InvervalInfo>> entry : startEndMap.entrySet()) {
            List<InvervalInfo> value = entry.getValue();
            value.sort(Comparator.comparing(invervalInfo -> !invervalInfo.isStart));
            for (InvervalInfo listIntervalInfo : value) {
                if (listIntervalInfo.isStart) {
                    startedIntervals.add(listIntervalInfo.intervalNumber);
                    if (startedIntervals.size() == 1) {
                        results.add(new Interval(entry.getKey()));
                    }
                } else {
                    if (startedIntervals.contains(listIntervalInfo.intervalNumber) && startedIntervals.size() == 1) {
                        Interval interval = results.get(currentIndex);
                        interval.end = entry.getKey();
                        startedIntervals.remove(listIntervalInfo.intervalNumber);
                        currentIndex++;
                    } else {
                        startedIntervals.remove(listIntervalInfo.intervalNumber);
                    }
                }
            }
        }
        int[][] result = new int[intervals.length][2];
        for (int i = 0; i < result.length; i++) {
            result[i][0] = results.get(i).start;
            result[i][1] = results.get(i).end;
        }
        return result;
    }

    public static class Interval {

        public Interval(int start){
            this.start = start;
        }
        public int start;
        public int end;
    }

    public static class InvervalInfo {
        public Boolean isStart;
        public Integer intervalNumber;
        public InvervalInfo(Boolean isStart, Integer intervalNumber){
            this.isStart = isStart;
            this.intervalNumber = intervalNumber;
        }
    }

    public int[][] merge(int[][] intervals) {
        List<int[]> resultList = new ArrayList<>();
        List<int[]> intervalList = new ArrayList<>(Arrays.asList(intervals));
        intervalList.sort((a, b) -> a[0] >= b[0] ? (a[0] == b[0] ? 0 : 1) : -1);
        resultList.add(intervalList.get(0));
        for (int i = 0; i < intervals.length - 1; i++) {
            int[] first = resultList.get(resultList.size() - 1);
            int[] second = intervals[i + 1];
            if (first[1] > second[0]) {
                resultList.set(resultList.size() - 1, new int[]{first[0], Math.max(first[1], second[1])});
            } else {
                resultList.add(second);
            }
        }

        int[][] result = new int[resultList.size()][2];
        for (int i = 0; i < result.length; i++) {
            result[i] = resultList.get(i);
        }
        return result;
    }


    public int lengthOfLongestSubstring(String s) {
        if (s == null) {
            return 0;
        }
        char[] sChars = s.toCharArray();
        if (sChars.length == 0) {
            return 0;
        }
        if (sChars.length == 1) {
            return 1;
        }

        int startIndex = 0;
        Set<Character> buffer = new HashSet<>();
        buffer.add(sChars[0]);
        int result = 1;
        for (int i = 1; i < sChars.length; i++) {
            if (!buffer.contains(sChars[i])) {
                buffer.add(sChars[i]);
                if (i == (sChars.length - 1)) {
                    result = Math.max(result, (i - startIndex + 1));
                }
            } else {
                result = Math.max(result, (i - startIndex));

                if (sChars[startIndex] == sChars[i]) {
                    while ((sChars[startIndex] == sChars[i] && startIndex < i)) {
                        startIndex++;
                    }
                } else {
                    while (sChars[startIndex] != sChars[i]) {
                        buffer.remove(sChars[startIndex]);
                    }
                    startIndex++;
                }
            }
        }
        return result;
    }


    private void traverse(TreeNode root, Map<Integer, NodeContext> result){

    }

    private class NodeContext {
        public int rightIndex;
        public TreeNode val;

        public NodeContext(int rightIndex, TreeNode val){
            this.rightIndex = rightIndex;
            this.val = val;
        }
    }
}
