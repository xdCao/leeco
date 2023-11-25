package bytedance.thd;

/**
 * @author buku.ch
 * @Desc
 * @date 2023/11/25 11:09
 */
public class NumIslands {

    public int numIslands(char[][] grid) {
        int cnt = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                cnt += dfs(grid, i, j) ? 1 : 0;
            }
        }
        return cnt;
    }

    private boolean dfs(char[][] grid, int i, int j) {
        if (i < 0 || i > grid.length - 1 || j < 0 || j > grid[0].length - 1) {
            return false;
        }
        if (grid[i][j] != '1') {
            return false;
        }
        grid[i][j] = '2';
        dfs(grid, i - 1, j);
        dfs(grid, i + 1, j);
        dfs(grid, i, j - 1);
        dfs(grid, i, j + 1);
        return true;
    }


}
