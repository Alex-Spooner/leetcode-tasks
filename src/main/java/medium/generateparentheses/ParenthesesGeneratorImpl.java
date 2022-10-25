package medium.generateparentheses;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ParenthesesGeneratorImpl implements ParenthesesGenerator {
    public static final String OPEN = "(";
    public static final String CLOSE = ")";

    @Override
    public List<String> generateParenthesis(int n) {
        List<ResultHolder> results = new ArrayList<>();
        ResultHolder firstResultHolder = new ResultHolder(n);
        firstResultHolder.addBracket(OPEN);
        firstResultHolder.reduceForOpen();
        results.add(firstResultHolder);
        for (int i = 0; i < n * 2 - 1; i++) {
            List<ResultHolder> extraResults = new ArrayList<>();
            for (ResultHolder result : results) {
                boolean oneMoreClose = result.oneMoreClose();
                boolean oneMoreOpen = result.oneMoreOpen();
                if (oneMoreClose && oneMoreOpen) {
                    ResultHolder additionalResultHolder = new ResultHolder(result);
                    additionalResultHolder.addBracket(CLOSE);
                    additionalResultHolder.reduceForClose();
                    extraResults.add(additionalResultHolder);
                } else if(oneMoreClose){
                    result.addBracket(CLOSE);
                    result.reduceForClose();
                }
                if (oneMoreOpen) {
                    result.addBracket(OPEN);
                    result.reduceForOpen();
                }
            }
            results.addAll(extraResults);
        }
        return results.stream()
                .map(ResultHolder::toString)
                .collect(Collectors.toList());
    }

    public static class ResultHolder {
        public StringBuilder result = new StringBuilder();
        public Map<String, Integer> parenthesesCounter;

        public Integer closeLimitCounter = 0;

        public ResultHolder(int n) {
            parenthesesCounter = new HashMap<>();
            parenthesesCounter.put(OPEN, n);
            parenthesesCounter.put(CLOSE, n);
        }

        public ResultHolder(ResultHolder resultHolder) {
            result = new StringBuilder(resultHolder.result);
            parenthesesCounter = new HashMap<>();
            parenthesesCounter.put(OPEN, resultHolder.parenthesesCounter.get(OPEN));
            parenthesesCounter.put(CLOSE, resultHolder.parenthesesCounter.get(CLOSE));
            closeLimitCounter = resultHolder.closeLimitCounter;
        }

        public void addBracket(String bracket) {
            if (OPEN.equals(bracket)) {
                closeLimitCounter++;
            }
            result.append(bracket);
        }

        public String toString() {
            return result.toString();
        }

        public void reduceForOpen() {
            Integer forOpen = parenthesesCounter.get(OPEN);
            parenthesesCounter.put(OPEN, forOpen - 1);
        }

        public void reduceForClose() {
            Integer forOpen = parenthesesCounter.get(CLOSE);
            parenthesesCounter.put(CLOSE, forOpen - 1);
            closeLimitCounter--;
        }

        public boolean oneMoreOpen() {
            Integer forOpen = parenthesesCounter.get(OPEN);
            return forOpen > 0;
        }

        public boolean oneMoreClose() {
            Integer forClose = parenthesesCounter.get(CLOSE);
            return forClose > 0 && closeLimitCounter > 0;
        }
    }
}
