import java.util.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

    }

    public void setZeroes(int[][] matrix) {
        List<List<Integer>> defaultZeroes = findZeroes(matrix);
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (isDefaultZero(defaultZeroes, i, j)) {
                    makeAllRawAndColumnZero(matrix,i,j);
                }
            }
        }
    }

    private void makeAllRawAndColumnZero(int[][] matrix, int i, int j) {
        for (int row = i; row < matrix.length; row++) {
            matrix[row][j] = 0;
        }
        for (int row = i; row >= 0; row--) {
            matrix[row][j] = 0;
        }
        for (int column = j; column < matrix[i].length; column++) {
            matrix[i][column] = 0;
        }
        for (int column = j; column >= 0; column--) {
            matrix[i][column] = 0;
        }
    }

    private List<List<Integer>> findZeroes(int[][] matrix) {
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0) {
                    List<Integer> subResult = new ArrayList<>();
                    subResult.add(i);
                    subResult.add(j);
                    result.add(subResult);
                }
            }
        }
        return result;
    }

    private boolean isDefaultZero(List<List<Integer>> defaultZero, int row, int column) {
        for (List<Integer> subResult : defaultZero) {
            for (int i = 0; i < 2; i++) {
                if (subResult.getFirst().intValue() == row && subResult.getLast().intValue() == column) {
                    return true;
                }
            }
        }
        return false;
    }
}