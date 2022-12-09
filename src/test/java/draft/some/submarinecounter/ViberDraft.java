package draft.some.submarinecounter;

import lombok.Data;

import java.util.List;

public class ViberDraft {

    public int countSubs(List<List<Boolean>> board) {
        int submarineCounterForColumns = getNumberForColumns(board);
        int submarineCounterForRows = getNumberForRows(board);
        return submarineCounterForColumns + submarineCounterForRows;
    }

    private int getNumberForColumns(List<List<Boolean>> board) {
        int submarineCounter = 0;
        for (List<Boolean> row : board) {
            boolean insideSubmarine;
            int submarineItemsCounter = 0;
            boolean needToAddSubmarine = true;
            for (Boolean item : row) {
                if (item) {
                    insideSubmarine = true;
                } else {
                    insideSubmarine = false;
                    submarineItemsCounter = 0;
                    needToAddSubmarine = true;
                }
                if (insideSubmarine) {
                    submarineItemsCounter++;
                }
                if (submarineItemsCounter == 3 && needToAddSubmarine) {
                    submarineCounter++;
                    needToAddSubmarine = false;
                }
            }
        }
        return submarineCounter;
    }

    private int getNumberForRows(List<List<Boolean>> board) {
        int submarineCounter = 0;
        int rowSize = board.get(0).size();
        for (int columnIndex = 0; columnIndex < rowSize; rowSize++) {
            int submarineItemsCounter = 0;
            boolean insideSubmarine;
            boolean needToAddSubmarine = true;
            for (List<Boolean> row : board) {
                boolean item = row.get(columnIndex);
                if (item) {
                    insideSubmarine = true;
                } else {
                    insideSubmarine = false;
                    submarineItemsCounter = 0;
                    needToAddSubmarine = true;
                }
                if (insideSubmarine) {
                    submarineItemsCounter++;
                }
                if (submarineItemsCounter == 3 && needToAddSubmarine) {
                    submarineCounter++;
                    needToAddSubmarine = false;
                }
            }
        }
        return submarineCounter;
    }

    @Data
    public static class IterationState {
        public int submarineItemsCounter = 0;
        public boolean insideSubmarine = false;
        public boolean needToAddSubmarine = true;
    }
}
