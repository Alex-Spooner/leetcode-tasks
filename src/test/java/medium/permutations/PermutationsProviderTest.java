package medium.permutations;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class PermutationsProviderTest {

    public static PermutationsProvider permutationsProvider = new PermutationsProviderImpl();

    @Test
    public void positiveTest1() {
        int[] input = {1, 2, 3};
        List<List<Integer>> expectedResult = List.of(
                List.of(1, 2, 3),
                List.of(1, 3, 2),
                List.of(2, 1, 3),
                List.of(2, 3, 1),
                List.of(3, 1, 2),
                List.of(3, 2, 1)
        );
        List<List<Integer>> actualResult = permutationsProvider.permute(input);
        assertTrue(expectedResult.containsAll(actualResult));
        assertTrue(actualResult.containsAll(expectedResult));
    }

    @Test
    public void positiveTest2() {
        int[] input = {0, 1};
        List<List<Integer>> expectedResult = List.of(
                List.of(0, 1),
                List.of(1, 0)
        );
        List<List<Integer>> actualResult = permutationsProvider.permute(input);
        assertTrue(expectedResult.containsAll(actualResult));
        assertTrue(actualResult.containsAll(expectedResult));
    }

    @Test
    public void positiveTest3() {
        int[] input = {1};
        List<List<Integer>> expectedResult = List.of(
                List.of(1)
        );
        List<List<Integer>> actualResult = permutationsProvider.permute(input);
        assertTrue(expectedResult.containsAll(actualResult));
        assertTrue(actualResult.containsAll(expectedResult));
    }
}