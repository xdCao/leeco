package org.example.hot100;

/**
 * 240. 搜索二维矩阵 II
 * @author buku.ch
 * @Desc
 * @date 2023/10/6 22:39
 */
public class SearchMatrix {

    public static void main(String[] args) {
        new SearchMatrix().searchMatrix(new int[][]{
                {-1, 3}
        }, 5);
    }

    public boolean greedy(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int i = m - 1;
        int j = 0;
        while (i >= 0 && j <= n - 1) {
            int flag = matrix[i][j];
            if (flag == target) {
                return true;
            }
            if (flag > target) {
                i--;
            } else {
                j++;
            }
        }
        return false;
    }

    public boolean searchMatrix(int[][] matrix, int target) {

        for (int i = 0; i < matrix.length; i++) {
            int searched = searchCol(matrix[i], target);
            if (searched >= 0) {
                return true;
            }
        }
        return false;

    }

    private int searchCol(int[] matrix, int target) {
        int begin = 0;
        int end = matrix.length - 1;
        while (true) {
            int cur = (begin + end) / 2;
            if (matrix[cur] == target) {
                return cur;
            }
            if (begin >= end) {
                return -1;
            }
            if (matrix[cur] < target) {
                begin = cur + 1;
                continue;
            }
            if (matrix[cur] > target) {
                end = cur - 1;
                continue;
            }
            return -1;
        }
    }

    private int searchRow(int[][] matrix, int target) {
        int begin = 0;
        int end = matrix.length - 1;
        while (true) {
            int cur = (begin + end) / 2;
            if (matrix[cur][0] <= target && matrix[cur + 1][0] > target) {
                return cur;
            }
            if (begin <= end) {
                return -1;
            }
            if (matrix[cur][0] > target) {
                begin = cur;
                continue;
            }
            if (matrix[cur][0] < target) {
                end = cur;
            }
        }
    }
}
