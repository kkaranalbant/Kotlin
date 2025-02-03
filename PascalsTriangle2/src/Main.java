import java.util.ArrayList;
import java.util.List;


public class Main {
    public static void main(String[] args) {
        for (int x : getRow(5)) {
            System.out.println(x);
        }
    }

    public static List<Integer> getRow(int rowIndex) {
        List<Integer> result = new ArrayList();
        if (rowIndex == 0) {
            result.add(1);
            return result;
        }
        if (rowIndex == 1) {
            result.add(1);
            result.add(1);
            return result;
        }
        int size = ((rowIndex + 2) * (rowIndex + 1)) / 2;
        int[] triangle = new int[size];
        triangle[0] = 1;
        triangle[1] = 1;
        triangle[2] = 1;
        int currentRowElementLastIndex = 5;
        int currentRowElementStartIndex = 3;
        int previousRowElementStartIndex = 1;
        for (int i = 2; i <= rowIndex; i++) {
            triangle[currentRowElementStartIndex] = 1;
            triangle[currentRowElementLastIndex] = 1;
            for (int j = currentRowElementLastIndex - i + 1; j < currentRowElementLastIndex; j++) {
                triangle[j] = triangle[previousRowElementStartIndex] + triangle[previousRowElementStartIndex + 1];
                previousRowElementStartIndex++;
            }
            previousRowElementStartIndex = currentRowElementStartIndex;
            currentRowElementStartIndex = currentRowElementLastIndex + 1;
            currentRowElementLastIndex = currentRowElementStartIndex + i + 1;

        }
        for (int i = previousRowElementStartIndex; i <= previousRowElementStartIndex + rowIndex; i++) {
            result.add(triangle[i]);
        }

        return result;
    }

}