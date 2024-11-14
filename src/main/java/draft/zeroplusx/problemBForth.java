package draft.zeroplusx;

import java.util.*;

public class problemBForth {

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
        if (aCase.incorrect) {
            return "IMPOSSIBLE";
        }
        Map<String, String> memo = new HashMap<>();
        String result = findSequence(aCase, new TreeSet<>(), new TreeSet<>(), new HashSet<>(), "", "", memo);
        return result.isEmpty() ? "IMPOSSIBLE" : result;
    }

    private static String findSequence(Case aCase,
                                       Set<String> aUsed,
                                       Set<String> bUsed,
                                       Set<Integer> usedIndices,
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

            if (aUsed.contains(aElement)
                    || bUsed.contains(bElement)
                    || usedIndices.contains(i)
            ) {
                continue;
            }

            usedIndices.add(i);

            aUsed.add(aElement);
            bUsed.add(bElement);

            String newA = aCurrent + aElement;
            String newB = bCurrent + bElement;

            String candidate = "";

            if (newA.startsWith(newB) || newB.startsWith(newA)) {
                candidate = findSequence(aCase, aUsed, bUsed, usedIndices, newA, newB, memo);
            }

            aUsed.remove(aElement);
            bUsed.remove(bElement);

            usedIndices.remove(i);

            if (
                    !candidate.isEmpty()
                            && (
                            bestResult.isEmpty()
                                    || candidate.length() < bestResult.length()
                                    || (candidate.length() == bestResult.length() && candidate.compareTo(bestResult) < 0)
                    )
            ) {
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

            boolean incorrect = false;
            for (int i = 0; i < caseNumber; i++) {
                String line;
                try {
                    line = dataSource.nextLine();
                } catch (Exception e) {
                    incorrect = true;
                    continue;
                }
                String[] parts = line.split("\\s+");
                if (parts.length != 2) {
                    incorrect = true;
                    continue;
                }
                listA.add(parts[0]);
                listB.add(parts[1]);
            }

            cases.add(new Case(caseNumber, listA, listB, incorrect));
        }

        return cases;
    }

    private static class Case {
        public final int itemsNumber;
        public final List<String> listA;
        public final List<String> listB;

        public final boolean incorrect;

        private Case(int itemsNumber, List<String> listA, List<String> listB, boolean incorrect) {
            this.itemsNumber = itemsNumber;
            this.listA = listA;
            this.listB = listB;
            this.incorrect = incorrect;
        }
    }
}
