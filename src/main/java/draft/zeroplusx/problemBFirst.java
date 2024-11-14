package draft.zeroplusx;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class problemBFirst {

    public static void main(String[] args) {
        Scanner dataSource = new Scanner(System.in);

        List<Case> cases = extractCases(dataSource);

        int caseNumber = 1;
        for (Case aCase : cases) {
            solveCase(
                    aCase,
                    new HashSet<>(),
                    new HashSet<>(),
                    "",
                    "",
                    new StringBuilder(),
                    new StringBuilder()
            );

            handleOutput(aCase, caseNumber++);
        }

        dataSource.close();
    }

    private static void solveCase(Case aCase,
                                  Set<String> aUsedElements,
                                  Set<String> bUsedElements,
                                  String aElementsPrefix,
                                  String bElementsPrefix,
                                  StringBuilder aElementsResult,
                                  StringBuilder bElementsResult

    ) {
        if (aElementsResult.length() != 0 && aElementsResult.length() == bElementsResult.length()) {
            aCase.addResult(aElementsResult.toString());
        }

        for (String elementA : aCase.listA) {
            for (String elementB : aCase.listB) {
                String aElementWithPrefix = aElementsPrefix + elementA;
                String bElementWithPrefix = bElementsPrefix + elementB;

                if (elementA.equals(elementB)
                        || aUsedElements.contains(elementA)
                        || bUsedElements.contains(elementB)) {
                    continue;
                }

                if (aElementWithPrefix.startsWith(bElementWithPrefix)
                        || bElementWithPrefix.startsWith(aElementWithPrefix)) {
                    String currentAElementsPrefix;
                    String currentBElementsPrefix;
                    if (aElementWithPrefix.length() > bElementWithPrefix.length()) {
                        currentAElementsPrefix = aElementWithPrefix.substring(bElementWithPrefix.length());
                        currentBElementsPrefix = "";
                    } else  if (aElementWithPrefix.length() < bElementWithPrefix.length()){
                        currentAElementsPrefix = "";
                        currentBElementsPrefix = bElementWithPrefix.substring(aElementWithPrefix.length());
                    } else {
                        currentAElementsPrefix = "";
                        currentBElementsPrefix = "";
                    }

                    int aInitialLength = aElementsResult.length();
                    int bInitialLength = bElementsResult.length();

                    aUsedElements.add(elementA);
                    aElementsResult.append(elementA);

                    bUsedElements.add(elementB);
                    bElementsResult.append(elementB);

                    solveCase(
                            aCase,
                            aUsedElements,
                            bUsedElements,
                            currentAElementsPrefix,
                            currentBElementsPrefix,
                            aElementsResult,
                            bElementsResult
                    );

                    aUsedElements.remove(elementA);
                    aElementsResult.setLength(aInitialLength);

                    bUsedElements.remove(elementB);
                    bElementsResult.setLength(bInitialLength);
                }
            }
        }
    }

    private static void handleOutput(Case aCase, int caseNumber) {
        TreeSet<String> results = aCase.results;
        String result;
        if (!results.isEmpty()) {
            result = results.first();
        } else {
            result = "IMPOSSIBLE";
        }
        System.out.printf("Case %d: %s%n", caseNumber, result);
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
        public final int number;
        public final int itemsNumber;
        public final List<String> listA;
        public final List<String> listB;

        private final TreeSet<String> results = new TreeSet<>();

        private Case(int number, List<String> listA, List<String> listB) {
            this.number = number;
            this.itemsNumber = listA.size();
            this.listA = listA;
            this.listB = listB;
        }

        public void addResult(String result) {
            this.results.add(result);
        }
    }
}
