package medium.atoi;

import org.junit.Test;

import static org.junit.Assert.*;

public class MyAtoiTest {

    public static MyAtoi myAtoi = new MyAtoiImpl();

    @Test
    public void positiveTest1(){
        String input = "42";
        int expectedResult = 42;
        assertEquals(expectedResult, myAtoi.myAtoi(input));
    }

    @Test
    public void positiveTest2(){
        String input = "   -42";
        int expectedResult = -42;
        assertEquals(expectedResult, myAtoi.myAtoi(input));
    }

    @Test
    public void positiveTest3(){
        String input = "4193 with words";
        int expectedResult = 4193;
        assertEquals(expectedResult, myAtoi.myAtoi(input));
    }

    @Test
    public void positiveTest4(){
        String input = "words and 987";
        int expectedResult = 0;
        assertEquals(expectedResult, myAtoi.myAtoi(input));
    }

    @Test
    public void positiveTest5(){
        String input = "-91283472332";
        int expectedResult = -2147483648;
        assertEquals(expectedResult, myAtoi.myAtoi(input));
    }

    @Test
    public void positiveTest6(){
        String input = "-2147483649";
        int expectedResult = -2147483648;
        assertEquals(expectedResult, myAtoi.myAtoi(input));
    }

    @Test
    public void positiveTest7(){
        String input = "91283472332";
        int expectedResult = 2147483647;
        assertEquals(expectedResult, myAtoi.myAtoi(input));
    }

    @Test
    public void positiveTest8(){
        String input = "2147483648";
        int expectedResult = 2147483647;
        assertEquals(expectedResult, myAtoi.myAtoi(input));
    }
}