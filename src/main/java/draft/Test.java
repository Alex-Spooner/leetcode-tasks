package draft;

import java.util.ArrayList;
import java.util.List;

public class Test {

    public String reverseWords(String s) {
        s = s.trim();
        List<String> words = new ArrayList<>();
        char[] letters = s.toCharArray();
        StringBuilder buffer = new StringBuilder();
        for (int i = 0; i < letters.length; i++) {
            if (Character.isWhitespace(letters[i])) {
                buffer.append(letters[i]);
            } else {
                if (buffer.length() != 0) {
                    words.add(buffer.toString());
                    buffer.setLength(0);
                }
            }
        }
        words.add(buffer.toString());
        buffer.setLength(0);

        for (int j = words.size() - 1; j >= 0; j--) {
            buffer.append(words.get(j));
            if (j != 0) {
                buffer.append(" ");
            }
        }

        return buffer.toString();
    }

    public void setZeroes(int[][] matrix) {
        List<Integer> columnsToSetZero = new ArrayList<>();
        List<Integer> rowsToSetZero = new ArrayList<>();
        for(int row = 0; row < matrix.length; row ++){
            for(int column = 0; column < matrix[0].length; column++){
                if(matrix[row][column] == 0){
                    columnsToSetZero.add(column);
                    rowsToSetZero.add(row);
                }
            }
        }

        for(Integer rowToZero: rowsToSetZero){
            int[] row = matrix[rowToZero];
            for(int i = 0; i < row.length; i++ ){
                row[i] = 0;
            }
        }

        for(Integer columnToZero: columnsToSetZero){
            for(int i = 0; i < matrix.length; i++ ){
                matrix[columnToZero][i] = 0;
            }
        }
    }

    public void setZeroes1(int[][] matrix) {
        boolean firstColumnIsNull = false;
        boolean firstRowIsNull = false;

        for (int row = 0; row < matrix.length; row++) {
            for (int column = 0; column < matrix[0].length; column++) {
                if (matrix[row][column] == 0) {
                    if (row != 0 && column != 0) {
                        matrix[row][0] = 0;
                        matrix[0][column] = 0;
                    }
                    if (column == 0) {
                        matrix[row][0] = 0;
                        firstColumnIsNull = true;
                    }
                    if (row == 0) {
                        firstRowIsNull = true;
                        matrix[0][column] = 0;
                    }
                }
            }
        }

        for (int row = 1; row < matrix.length; row++) {
            if (matrix[row][0] == 0) {
                for (int column = 0; column < matrix[0].length; column++) {
                    matrix[row][column] = 0;
                }
            }
        }

        for (int column = 1; column < matrix[0].length; column++) {
            if (matrix[0][column] == 0) {
                for (int row = 0; row < matrix.length; row++) {
                    matrix[row][column] = 0;
                }
            }
        }

        if(firstColumnIsNull){
            for (int row = 0; row < matrix.length; row++) {
                matrix[row][0] = 0;
            }
        }

        if(firstRowIsNull){
            for (int column = 0; column < matrix[0].length; column++) {
                matrix[0][column] = 0;
            }
        }
    }
}
