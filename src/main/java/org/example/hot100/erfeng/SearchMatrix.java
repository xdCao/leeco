package org.example.hot100.erfeng;

/**
 * 74. 搜索二维矩阵
 * @author buku.ch
 * @Desc
 * @date 2023/11/15 14:41
 */
public class SearchMatrix {

    public boolean searchMatrix(int[][] matrix, int target) {
        int m = searchRow(matrix, target, 0 , matrix.length - 1);
        if (m < 0) {
            return false;
        }
        return searchColumn(matrix[m], target, 0, matrix[m].length - 1) >= 0;
    }

    private int searchColumn(int[] matrix, int target, int begin, int end) {
        if (begin > end) {
            return -1;
        }
        int mid = (begin + end) / 2;
        if (matrix[mid] == target) {
            return mid;
        }
        if (matrix[mid] < target) {
            return searchColumn(matrix, target, mid + 1, end);
        }
        return searchColumn(matrix, target, begin, mid - 1);
    }

    private int searchRow(int[][] matrix, int target, int begin, int end) {
        if (begin > end) {
            return -1;
        }
        int mid = (begin + end) / 2;
        if (matrix[mid][0] <= target && (mid + 1 == matrix.length || matrix[mid + 1][0] > target)) {
            return mid;
        }
        if (matrix[mid][0] > target) {
            return searchRow(matrix, target, begin, mid - 1);
        }
        return searchRow(matrix, target, mid + 1, end);
    }

}
