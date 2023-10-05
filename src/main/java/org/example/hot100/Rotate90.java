package org.example.hot100;

/**
 * 48. 旋转图像
 * @author buku.ch
 * @Desc
 * @date 2023/10/6 00:05
 */
public class Rotate90 {

//    5 1 9 11
//    2 4 8 10
//    13 3 6 7
//    15 14 12 16
//
//
//    15 13 14 5
//
//    0, 2  -  1, 0 -

    public static void main(String[] args) {
        rotate(new int[][]{
                {5, 1, 9, 11},
                {2, 4, 8, 10},
                {13, 3, 6, 7},
                {15, 14, 12, 16}
        });
    }

    public static void rotate(int[][] matrix) {

        int n = matrix.length;
        if (n == 1) {
            return;
        }
        for (int i = 0; i < n / 2; i++) {
            for (int j = i; j < n - 1 - i; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[n - 1 - j][i];
                matrix[n - 1 - j][i] = matrix[n - 1 - i][n - 1 - j];
                matrix[n - 1 - i][n - 1 - j] = matrix[j][n - 1 - i];
                matrix[j][n - 1 - i] = tmp;
            }
        }

    }

}
