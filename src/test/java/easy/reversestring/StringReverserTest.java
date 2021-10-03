package easy.reversestring;

import org.junit.Test;

import static org.junit.Assert.*;

public class StringReverserTest {

    StringReverser stringReverser = new StringReverserImpl();

    @Test
    public void positiveTest() {
        char[] inputArray = {'h','e','l','l','o'};
        stringReverser.reverseString(inputArray);
        assertArrayEquals(
                new char[]{'o','l','l','e','h'},
                inputArray
        );
    }

    @Test
    public void positiveTest2() {
        char[] inputArray = {'H','a','n','n','a','h'};
        stringReverser.reverseString(inputArray);
        assertArrayEquals(
                new char[]{'h','a','n','n','a','H'},
                inputArray
        );
    }

}