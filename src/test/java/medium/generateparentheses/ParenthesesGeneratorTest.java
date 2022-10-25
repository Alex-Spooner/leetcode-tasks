package medium.generateparentheses;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class ParenthesesGeneratorTest {

    static ParenthesesGenerator parenthesesGenerator = new ParenthesesGeneratorImpl();

    @Test
    public void positiveTest1(){
        List<String> expectedResult = List.of(
                "((()))",
                "(()())",
                "(())()",
                "()(())",
                "()()()"
        );
        List<String> actualResult = parenthesesGenerator.generateParenthesis(3);
        assertTrue(expectedResult.containsAll(actualResult));
        assertTrue(actualResult.containsAll(expectedResult));
    }

    @Test
    public void positiveTest2(){
        List<String> expectedResult = List.of(
                "()"
        );
        assertEquals(expectedResult, parenthesesGenerator.generateParenthesis(1));
    }
}