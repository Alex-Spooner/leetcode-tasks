package easy.removeduplicates;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class DuplicateRemoverTest {
    private final DuplicateRemover duplicateRemover;

    public DuplicateRemoverTest(DuplicateRemover duplicateRemover) {
        this.duplicateRemover = duplicateRemover;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {new DuplicateRemoverSimple()}
        });
    }

    @Test
    public void positiveTest() {
        int[] ints = {1, 1, 1, 2};
        int resultIntNumber = duplicateRemover.removeDuplicates(ints);
        Assert.assertEquals(
                2,
                resultIntNumber
        );
        assertResultInts(ints, resultIntNumber, new int[]{1, 2});
    }

    @Test
    public void positiveTest2() {
        int[] ints = {1, 1, 1, 1};
        int resultIntNumber = duplicateRemover.removeDuplicates(ints);
        Assert.assertEquals(
                1,
                resultIntNumber
        );
        assertResultInts(ints, resultIntNumber, new int[]{1, 2});
    }

    @Test
    public void positiveTest3() {
        int[] ints = {0,0,1,1,1,2,2,3,3,4};
        int resultIntNumber = duplicateRemover.removeDuplicates(ints);
        Assert.assertEquals(
                5,
                resultIntNumber
        );
        assertResultInts(ints, resultIntNumber, new int[]{0, 1, 2, 3, 4});
    }

    private void assertResultInts(int[] ints, int resultIntNumber, int[] expectedInts) {
        for (int i = 0; i < resultIntNumber; i++) {
            Assert.assertEquals(expectedInts[i], ints[i]);
        }
    }
}