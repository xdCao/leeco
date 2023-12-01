package bytedance.codetop;

import java.util.*;

/**
 * @author buku.ch
 * @Desc
 * @date 2023/12/1 09:58
 */
public class SpiralOrder {

    public static void main(String[] args) {
        spiralOrder(new int[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        });
    }

    public static List<Integer> spiralOrder(int[][] matrix) {
        Set<String> visited = new HashSet<>();
        List<Integer> result = new ArrayList<>();

        Integer curDir = 1; // 右
        int curRow = 0;
        int curCol = 0;

        while (result.size() < matrix.length * matrix[0].length) {
            if (!visited.contains(curRow + "," + curCol)) {
                result.add(matrix[curRow][curCol]);
                visited.add(curRow + "," + curCol);
            }
            switch (curDir % 4) {
                case 1:
                    if (visited.contains(curRow + "," + (curCol + 1)) || curCol >= matrix[0].length - 1) {
                        curDir++;
                    } else {
                        curCol = curCol + 1;
                    }
                    break;
                case 2:
                    if (visited.contains((curRow + 1) + "," + curCol) || curRow >= matrix.length - 1) {
                        curDir++;
                    } else {
                        curRow = curRow + 1;
                    }
                    break;
                case 3:
                    if (visited.contains(curRow + "," + (curCol - 1)) || curCol == 0) {
                        curDir++;
                    } else {
                        curCol = curCol - 1;
                    }
                    break;
                case 0:
                    if (visited.contains((curRow - 1) + "," + curCol) || curRow == 0) {
                        curDir++;
                    } else {
                        curRow = curRow - 1;
                    }
                    break;
            }
        }
        return result;
    }

}
