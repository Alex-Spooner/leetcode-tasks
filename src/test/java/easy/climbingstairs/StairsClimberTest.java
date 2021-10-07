package easy.climbingstairs;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class StairsClimberTest {

    StairsClimber stairsClimber = new StairsClimberSimple();

    @Test
    public void positiveTest() {
        assertEquals(
                1,
                stairsClimber.climbStairs(1) // 1
        );
    }

    @Test
    public void positiveTest1() {
        assertEquals(
                2,
                stairsClimber.climbStairs(2) // 11, 2
        );
    }

    @Test
    public void positiveTest2() {
        assertEquals(
                3,
                stairsClimber.climbStairs(3) // 111, 21, 12
        );
    }

    @Test
    public void positiveTest4() {
        assertEquals(
                5,
                stairsClimber.climbStairs(4) // 1111, 211, 121, 112, 22
        );
    }

    @Test
    public void positiveTest5() {
        assertEquals(
                8,
                stairsClimber.climbStairs(5) // 11111, 2111, 1211, 1121, 1112, 221, 212, 122
        );
    }

    @Test
    public void positiveTest6() {
        assertEquals(
                13,
                stairsClimber.climbStairs(6) // 111111, 21111, 12111, 11211, 11121, 11112, 2211, 1221, 1122
                                                //2121, 1212, 2112, 222
        );
    }



}