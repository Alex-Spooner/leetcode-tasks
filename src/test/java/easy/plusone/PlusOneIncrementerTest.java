package easy.plusone;

        import org.junit.Assert;
        import org.junit.Test;

public class PlusOneIncrementerTest {

    PlusOneIncrementer plusOneIncrementer = new PlusOneIncrementerSimple();

    @Test
    public void positiveTest() {
        Assert.assertArrayEquals(
                new int[]{1, 2, 4},
                plusOneIncrementer.plusOne(new int[]{1, 2, 3})
        );
    }

    @Test
    public void positiveTest2() {
        Assert.assertArrayEquals(
                new int[]{4, 3, 2, 2},
                plusOneIncrementer.plusOne(new int[]{4, 3, 2, 1})
        );
    }

    @Test
    public void positiveTest3() {
        Assert.assertArrayEquals(
                new int[]{1},
                plusOneIncrementer.plusOne(new int[]{0})
        );
    }

    @Test
    public void positiveTest4() {
        Assert.assertArrayEquals(
                new int[]{1, 0},
                plusOneIncrementer.plusOne(new int[]{9})
        );
    }

    @Test
    public void positiveTest5() {
        Assert.assertArrayEquals(
                new int[]{1, 0},
                plusOneIncrementer.plusOne(new int[]{9})
        );
    }

    @Test
    public void positiveTest6() {
        Assert.assertArrayEquals(
                new int[]{1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                plusOneIncrementer.plusOne(new int[]{9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9})
        );
    }

}