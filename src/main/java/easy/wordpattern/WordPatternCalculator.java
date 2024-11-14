package easy.wordpattern;

import model.TreeNode;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class WordPatternCalculator {

    public boolean wordPattern(String pattern, String s) {
        char[] patternChars = pattern.toCharArray();
        Map<Character, List<Integer>> patternCharsToPlaces = new LinkedHashMap<>();
        for (int i = 0; i < patternChars.length; i++) {
            patternCharsToPlaces.computeIfAbsent(patternChars[i], noUsage -> new ArrayList<>()).add(i);
        }

        String[] sWords = s.split(" ");
        Map<String, List<Integer>> stringWordsToPlaces = new LinkedHashMap<>();
        for (int i = 0; i < sWords.length; i++) {
            stringWordsToPlaces.computeIfAbsent(sWords[i], noUsage -> new ArrayList<>()).add(i);
        }

        if (patternCharsToPlaces.values().size() != stringWordsToPlaces.values().size()) {
            return false;
        }

        for (int j = 0; j < patternCharsToPlaces.values().size(); j++) {
            List<Integer> sCharsCurrentPlacesList = patternCharsToPlaces.values().iterator().next();
            List<Integer> sWordsCurrentPlacesList = stringWordsToPlaces.values().iterator().next();

            if (sCharsCurrentPlacesList.size() != sWordsCurrentPlacesList.size()) {
                return false;
            }

            for (int k = 0; k < sCharsCurrentPlacesList.size(); k++) {
                if (!sCharsCurrentPlacesList.get(k).equals(sWordsCurrentPlacesList.get(k))) {
                    return false;
                }
            }
        }

        return true;
    }


    public boolean isAnagram(String s, String t) {
        char[] sChars = s.toCharArray();
        Map<Character, Integer> sCharsToPlaces = new LinkedHashMap<>();
        for (int i = 0; i < sChars.length; i++) {
            sCharsToPlaces.compute(sChars[i], (k, v) -> (v == null) ? 1 : v + 1);
        }

        char[] tChars = t.toCharArray();
        for (int i = 0; i < tChars.length; i++) {
            sCharsToPlaces.compute(tChars[i], (k, v) -> (v == null) ? -1 : v - 1);
        }

        return sCharsToPlaces.values().stream().allMatch(count -> count.equals(0));
    }


    public boolean isSymmetric(TreeNode root) {
        if(root == null){
            return true;
        }

        return isSymmetric(root.left, root.right);
    }

    public boolean isSymmetric(TreeNode left, TreeNode right){
        if((left == null && right != null) || (left != null && right == null)){
            return false;
        }
        if((left == null) && (right == null)){
            return true;
        }

        boolean valComparison = (left.val == right.val);
        boolean externalComparison = isSymmetric(left.left, right.right);
        boolean internalComparison = isSymmetric(left.right, right.left);
        return valComparison && externalComparison && internalComparison;
    }


    public String addBinary(String a, String b) {
        char[] aChars = a.toCharArray();
        char[] bChars = b.toCharArray();
        StringBuilder result = new StringBuilder();
        boolean additionalDigit = false;
        int maxResultLength = Math.max(aChars.length, bChars.length) + 1;
        for(int i = 0; i < maxResultLength; i++){
            char aChar = ' ';
            if(aChars.length > i){
                aChar = aChars[i];
            }

            char bChar = ' ';
            if(bChars.length > i){
                bChar = bChars[i];
            }

            if(aChar == '1' && bChar == '1'){
                if(additionalDigit){
                    result.append('1');
                    additionalDigit = true;
                } else {
                    result.append('0');
                    additionalDigit = false;
                }
            } else if(aChar == '1' || bChar == '1'){
                if(additionalDigit){
                    result.append('0');
                    additionalDigit = true;
                } else {
                    result.append('1');
                    additionalDigit = false;
                }
            } else {
                if(additionalDigit){
                    result.append('1');
                } else {
                    result.append('0');
                }
            }
        }

        if(additionalDigit){
            result.append('1');
        }

        return result.reverse().toString();
    }

    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());
        queue.addAll(Arrays.stream(nums).boxed().collect(Collectors.toList()));
        int result = 0;

        if(nums.length < k){
            return 0;
        }

        for(int i = 0; i<k; i++){
            result = queue.poll();
        }
        return result;
    }


    public int getMinimumDifference(TreeNode root) {
        TreeSet<Integer> resultSet = new TreeSet<>();
        collectToSet(root, resultSet);

        int previous = -1;
        int result = 1000000;
        for (int current : resultSet) {
            if(previous > 0){
                result = Math.min(result, Math.abs(current - previous));
            }
            previous = current;
        }

        return result;
    }

    public void collectToSet(TreeNode node, TreeSet<Integer> resultSet){
        if(node != null){
            resultSet.add(node.val);
            if(node.left != null){
                collectToSet(node.left, resultSet);
            }
            if(node.right != null){
                collectToSet(node.right, resultSet);
            }
        }
    }


    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        boolean removeFromStart = true;
        int end = nums.length - 1;
        for(int start = 0; start + 1 < end;){

            int twoSum = nums[start] + nums[end];
            if(twoSum >= 0){
                for(int middle = start + 1; middle < end; middle++){
                    if(twoSum + nums[middle] == 0){
                        result.add(List.of(nums[start], nums[middle], nums[end]));
                        break;
                    }

                    if(twoSum + nums[middle] < 0){
                        break;
                    }
                }
            } else {
                for(int middle = end - 1; middle > start; middle--){
                    if(twoSum + nums[middle] == 0){
                        result.add(List.of(nums[start], nums[middle], nums[end]));
                        break;
                    }

                    if(twoSum + nums[middle] > 0){
                        break;
                    }
                }
            }

            if(removeFromStart){
                for(int i = start + 1; i + 1 < end; i++){
                    if(nums[start] != nums[i]){
                        start = i;
                        break;
                    }
                }
                removeFromStart = false;
            } else {
                for(int i = end - 1; i + 1 > start; i--){
                    if(nums[end] != nums[i]){
                        end = i;
                        break;
                    }
                }
                removeFromStart = true;
            }
        }
        return result.stream().distinct().collect(Collectors.toList());
    }


    public List<List<String>> groupAnagrams(String[] strs) {
        return new ArrayList<>(Arrays.stream(strs)
                .collect(Collectors.groupingBy(
                        str -> {
                            char[] charArray = str.toCharArray();
                            Arrays.sort(charArray);
                            return new String(charArray);
                        }
                )).values());
    }

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> log = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            Integer place = log.get(nums[i]);
            if(place == null){
                log.put(nums[i], i);
            } else {
                if( Math.abs(place - i) <= k){
                    return true;
                }
                log.put(nums[i], i);
            }
        }
        return false;
    }

    public List<Integer> spiralOrder(int[][] matrix) {
        int horStart = 0;
        int horEnd = matrix[0].length - 1;
        int vertStart = 0;
        int vertEnd = matrix.length - 1;
        List<Integer> result = new ArrayList<>();
        while(horStart < horEnd || vertStart < vertEnd){
            for(int i = horStart; i <= horEnd; i++){
                result.add(matrix[vertStart][i]);
                vertStart++;
            }

            for(int i = vertStart; i <= vertEnd; i++){
                result.add(matrix[i][horEnd]);
                horEnd--;
            }

            for(int i = horEnd; i >= horStart; i--){
                result.add(matrix[vertEnd][i]);
                vertEnd--;
            }

            for(int i = vertEnd; i >= vertStart; i--){
                result.add(matrix[i][horStart]);
                horStart++;
            }
        }
        return result;
    }

    public int[][] insert(int[][] intervals, int[] newInterval) {
        if(intervals == null || intervals.length == 0){
            return new int[][]{newInterval};
        }

        List<int[]> result = new ArrayList<>();
        for(int i = 0; i< intervals.length; i++){
            int[] current = intervals[i];
            //support cases when new is before or after current
            if(current[1] < newInterval[0] || current[0] > newInterval[1]){
                result.add(current);
                continue;
            }

            int newStart = Math.min(current[0], newInterval[0]);
            int newEnd;
            if(current[1] <= newInterval[1]){
                newEnd = newInterval[1];
            } else {
                newEnd = current[1];
                for(int j = i + 1; j < intervals.length; j++){
                    if(intervals[j][0] > current[1]){
                        break;
                    } else if (intervals[j][0] <= current[1] && intervals[j][1] >= current[1]){
                        newEnd = intervals[j][1];
                        i++;
                    } else {
                        i++;
                    }
                }
            }
            result.add(new int[]{newStart, newEnd});
        }
        return result.toArray(new int[result.size()][]);
    }

//    class LRUCache {
//
//        Map<Integer, Integer> cache;
//
//        public LRUCache(int capacity) {
//            this.cache = new LinkedHashMap<>(capacity, 0.75F, true) {
//                // This method is called just after a new entry has been added
//                public boolean removeEldestEntry(Map.Entry eldest) {
//                    return size() > capacity;
//                }
//            };
//        }
//
//        public int get(int key) {
//            if(!cache.containsKey(key)){
//                return -1;
//            }
//            return cache.get(key);
//        }
//
//        Map<Integer, CoinResult> memo = new HashMap<>();
//
//        public int coinChange(int[] coins, int amount) {
//            Set<Integer> coinSet = new HashSet<>();
//            for(int coin: coins){
//                coinSet.add(coin);
//            }
//
//            CoinResult result = coinChangeRec(coins, amount);
//            if(result.negative){
//                return -1;
//            } else {
//                return val;
//            }
//        }
//
//        private CoinResult coinChangeRec(Set<Integer>  coinSet, int amount){
//            if(amount < 0){
//                return new CoinResult(-1, true);
//            }
//
//            if(coinSet.contains(amount)){
//                return new CoinResult(1, false);
//            }
//
//            if(memo.containsKey(amount)){
//                return memo.get(amount);
//            }
//
//            CoinResult result = new CoinResult(-1, true);
//            for(Integer coin: coinSet){
//                CoinResult currentResult = coinChangeRec(coinSet, (amoint - coin));
//                if(!currentResult.negative){
//                    if(result.negative){
//                        result.val = currentResult.val;
//                        result.negative = false;
//                    } else {
//                        result.val = Math.min(result.val, currentResult.val);
//                    }
//                }
//            }
//            return result;
//        }
//
//        private Set<Integer> processedNodes = new HashSet<>().iterator().next();
}
