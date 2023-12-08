package bytedance.fourth;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author buku.ch
 * @Desc
 * @date 2023/12/7 11:13
 */
public class SpiralOrder {

    public static void main(String[] args) {
        List<Integer> list = spiralOrder(new int[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        });
        System.out.println(list);
    }

    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();

        // 0 向右 1向下 2向左 3向上
        int direction = 0;
        int row = 0;
        int col = 0;
        Set<String> visited = new HashSet<>();
        while (result.size() < matrix.length * matrix[0].length) {
            if (!visited.contains(row + "," + col)) {
                result.add(matrix[row][col]);
                visited.add(row + "," + col);
            }
            int nextRow = row;
            int nextCol = col;
            switch (direction % 4) {
                case 0:
                    nextCol++;
                    break;
                case 1:
                    nextRow++;
                    break;
                case 2:
                    nextCol--;
                    break;
                case 3:
                    nextRow--;
                    break;
            }
            // 如果下一个位置没有访问过，并且没超过边界，设置row和col
            if (visited.contains(nextRow + "," + nextCol)
                    || nextRow < 0
                    || nextRow >= matrix.length
                    || nextCol < 0
                    || nextCol >= matrix[0].length
            ) {
                direction++;
                continue;
            }
            row = nextRow;
            col = nextCol;
        }

        return result;

    }

}
