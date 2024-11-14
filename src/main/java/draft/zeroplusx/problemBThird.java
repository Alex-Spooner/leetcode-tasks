package draft.zeroplusx;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class problemBThird {

    public static void main(String[] args) {
        Scanner dataSource = new Scanner(System.in);
        List<Case> cases = extractCases(dataSource);
        int caseNumber = 1;

        for (Case aCase : cases) {
            String result = solveCase(aCase);
            System.out.printf("Case %d: %s%n", caseNumber++, result);
        }
        dataSource.close();
    }

    private static String solveCase(Case aCase) {
        Map<String, String> memo = new HashMap<>();
        String result = findSequence(aCase, new HashSet<>(), new HashSet<>(), "", "", memo);
        return result.isEmpty() ? "IMPOSSIBLE" : result;
    }

    private static String findSequence(Case aCase,
                                       Set<String> aUsed,
                                       Set<String> bUsed,
                                       String aCurrent,
                                       String bCurrent,
                                       Map<String, String> memo) {

        String state = aCurrent + "#" + bCurrent;
        if (memo.containsKey(state)) {
            return memo.get(state);
        }

        if (aCurrent.equals(bCurrent) && !aCurrent.isEmpty()) {
            memo.put(state, aCurrent);
            return aCurrent;
        }

        String bestResult = "";

        for (int i = 0; i < aCase.itemsNumber; i++) {
            String aElement = aCase.listA.get(i);
            String bElement = aCase.listB.get(i);

            if (aUsed.contains(aElement) || bUsed.contains(bElement)) {
                continue;
            }

            aUsed.add(aElement);
            bUsed.add(bElement);

            String newA = aCurrent + aElement;
            String newB = bCurrent + bElement;

            String candidate = "";

            if (newA.startsWith(bCurrent) || newB.startsWith(aCurrent)) {
                candidate = findSequence(aCase, aUsed, bUsed, newA, newB, memo);
            }

            aUsed.remove(aElement);
            bUsed.remove(bElement);

            if (!candidate.isEmpty() && (bestResult.isEmpty() ||
                    candidate.length() < bestResult.length() ||
                    (candidate.length() == bestResult.length() && candidate.compareTo(bestResult) < 0))) {
                bestResult = candidate;
            }
        }

        memo.put(state, bestResult);
        return bestResult;
    }

    private static List<Case> extractCases(Scanner dataSource) {
        List<Case> cases = new ArrayList<>();
        while (dataSource.hasNextInt()) {
            int caseNumber = dataSource.nextInt();
            dataSource.nextLine();

            List<String> listA = new ArrayList<>();
            List<String> listB = new ArrayList<>();

            for (int i = 0; i < caseNumber; i++) {
                String line = dataSource.nextLine();
                String[] parts = line.split(" ");
                listA.add(parts[0]);
                listB.add(parts[1]);
            }

            cases.add(new Case(caseNumber, listA, listB));
        }

        return cases;
    }

    private static class Case {
        public final int itemsNumber;
        public final List<String> listA;
        public final List<String> listB;

        private Case(int itemsNumber, List<String> listA, List<String> listB) {
            this.itemsNumber = itemsNumber;
            this.listA = listA;
            this.listB = listB;
        }
    }
}
