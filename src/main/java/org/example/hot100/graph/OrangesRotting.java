package org.example.hot100.graph;

/**
 * 994. 腐烂的橘子
 * @author buku.ch
 * @Desc
 * @date 2023/11/15 10:40
 */
public class OrangesRotting {

    public static void main(String[] args) {
        OrangesRotting orangesRotting = new OrangesRotting();
        int i = orangesRotting.orangesRotting(new int[][]{
                {2, 0, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 0, 1, 0, 0, 0, 0, 0, 0, 1},
                {1, 0, 1, 0, 1, 1, 1, 1, 0, 1},
                {1, 0, 1, 0, 1, 0, 0, 1, 0, 1},
                {1, 0, 1, 0, 1, 0, 0, 1, 0, 1},
                {1, 0, 1, 0, 1, 1, 0, 1, 0, 1},
                {1, 0, 1, 0, 0, 0, 0, 1, 0, 1},
                {1, 0, 1, 1, 1, 1, 1, 1, 0, 1},
                {1, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1}
        });
        System.out.println(i);
    }

    public int orangesRotting(int[][] grid) {
        if (check(grid)) {
            return 0;
        }
        int maxTime = grid.length * grid[0].length;
        for (int i = 1; i <= maxTime; i++) {
            for (int j = 0; j < grid.length; j++) {
                for (int k = 0; k < grid[0].length; k++) {
                    if (grid[j][k] == i + 1) {
                        grid[j][k] = i + 2;
                        infect(grid, j, k, i + 2);
                    }
                }
            }
            boolean isComplete = check(grid);
            if (isComplete) {
                return i;
            }
        }
        return check(grid) ? maxTime : -1;
    }

    public void infect(int[][] grid, int j, int k, int i) {
        if (j - 1 >= 0 && grid[j - 1][k] == 1) {
            grid[j - 1][k] = i;
        }

        if (k - 1 >= 0 && grid[j][k - 1] == 1) {
            grid[j][k - 1] = i;
        }

        if (j + 1 < grid.length && grid[j + 1][k] == 1) {
            grid[j + 1][k] = i;
        }

        if (k + 1 < grid[0].length && grid[j][k + 1] == 1) {
            grid[j][k + 1] = i;
        }
    }


    public boolean check(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    return false;
                }
            }
        }
        return true;
    }

    private void dfs(int[][] grid, int j, int k) {
        if (j < 0 || j >= grid.length || k < 0 || k >= grid[0].length) {
            return;
        }
        if (grid[j][k] != 1) {
            return;
        }
        grid[j][k] = 2;
        dfs(grid, j - 1, k);
        dfs(grid, j + 1, k);
        dfs(grid, j, k - 1);
        dfs(grid, j, k + 1);
    }

}
