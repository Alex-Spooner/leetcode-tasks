package easy.singlenumber;

public class SingleNumberFinderXor implements SingleNumberFinder {
    @Override
    public int singleNumber(int[] nums) {
        int result = 0;
        for (int num : nums) {
            result ^= num;
        }
        return result;
    }
}
