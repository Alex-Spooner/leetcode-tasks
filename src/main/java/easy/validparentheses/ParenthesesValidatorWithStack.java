package easy.validparentheses;

import java.util.Map;
import java.util.Stack;

public class ParenthesesValidatorWithStack implements ParenthesesValidator {
    @Override
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        Map<Character, Character> parenthesesMap = Map.of(')', '(', '}', '{', ']', '[');
        for (char c : s.toCharArray()) {
            if (parenthesesMap.containsKey(c)) {
                if (stack.empty() || !stack.pop().equals(parenthesesMap.get(c))) {
                    return false;
                }
            } else {
                stack.push(c);
            }
        }
        return stack.empty();
    }
}
