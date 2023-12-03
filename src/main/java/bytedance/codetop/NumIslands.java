package bytedance.codetop;

/**
 * @author buku.ch
 * @Desc
 * @date 2023/12/3 09:31
 */
public class NumIslands {

    public int numIslands(char[][] grid) {
        int cnt = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                cnt += (dfs(grid, i, j) > 0) ? 1 : 0;
            }
        }
        return cnt;
    }

    private int dfs(char[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length) {
            return 0;
        }
        if (grid[i][j] != '1') {
            return 0;
        }
        grid[i][j] = '2';
        int sum = 1;
        sum += dfs(grid, i - 1, j);
        sum += dfs(grid, i + 1, j);
        sum += dfs(grid, i, j - 1);
        sum += dfs(grid, i, j + 1);
        return sum;
    }

}
