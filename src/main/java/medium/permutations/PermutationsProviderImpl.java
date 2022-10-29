package medium.permutations;

import java.util.*;

public class PermutationsProviderImpl implements PermutationsProvider {

    @Override
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return result;
        }
        List<Integer> numsList = new ArrayList<>();
        for (int num : nums) {
            numsList.add(num);
        }
        result.add(numsList);

        int numsLength = nums.length;
        for (int index = 0; index < numsLength; index++) {
            List<List<Integer>> additionalResults = new ArrayList<>();
            for (List<Integer> integers : result) {
                additionalResults.addAll(getNextPermutations(integers, index));
            }
            result.addAll(additionalResults);
        }
        return result;
    }

    private List<List<Integer>> getNextPermutations(List<Integer> base, int target) {
        List<List<Integer>> additionalResults = new ArrayList<>();
        for (int destination = base.size() - 1; destination > target; destination--) {
            additionalResults.add(swapElements(base, target, destination));
        }
        return additionalResults;
    }

    private List<Integer> swapElements(List<Integer> base, int target, int destination) {
        List<Integer> copy = new ArrayList<>(base);
        Integer tmp = copy.get(target);
        copy.set(target, copy.get(destination));
        copy.set(destination, tmp);
        return copy;
    }
}
