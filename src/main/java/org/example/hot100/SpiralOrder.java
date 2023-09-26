package org.example.hot100;

import java.util.ArrayList;
import java.util.List;

/**
 * 54. 螺旋矩阵
 * https://leetcode.cn/problems/spiral-matrix/description/?envType=study-plan-v2&envId=top-100-liked
 * @author buku.ch
 * @Desc
 * @date 2023/9/26 23:26
 */
public class SpiralOrder {

    public static void main(String[] args) {
        List<Integer> integers = spiralOrder(new int[][]{
                {6, 9, 7}
        });
        System.out.println(integers);
    }

    public static List<Integer> spiralOrder(int[][] matrix) {

        List<Integer> res = new ArrayList<>();

        int m = matrix.length;
        int n = matrix[0].length;
        int i = 0;
        int j = 0;
        int arrow = 0;
        int cnt = 0;
        while (cnt < m * n) {
            if (i < m && j < n && i >= 0 && j >= 0 && matrix[i][j] != 10000) {
                res.add(matrix[i][j]);
                cnt += 1;
                matrix[i][j] = 10000;
            }
            switch (arrow % 4) {
                case 0:
                    // 向右
                    if (j + 1 < n && matrix[i][j + 1] != 10000) {
                        j++;
                    } else {
                        i += 1;
                        arrow += 1;
                    }
                    break;
                case 1:
                    // 向下
                    if (i + 1 < m && matrix[i + 1][j] != 10000) {
                        i++;
                    } else {
                        j -= 1;
                        arrow += 1;
                    }
                    break;
                case 2:
                    // 向左
                    if (j - 1 >= 0 && matrix[i][j - 1] != 10000) {
                        j--;
                    } else {
                        i -= 1;
                        arrow += 1;
                    }
                    break;
                case 3:
                    // 向上
                    if (i - 1 >= 0 && matrix[i - 1][j] != 10000) {
                        i--;
                    } else {
                        j += 1;
                        arrow += 1;
                    }
                    break;
            }
        }
        return res;
    }

}
