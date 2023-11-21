package bytedance.sec;

/**
 * @author buku.ch
 * @Desc
 * @date 2023/11/21 14:29
 */
public class NumIslands {

    public int numIslands(char[][] grid) {
        int cnt = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                int dfs = dfs(grid, i, j);
                if (dfs > 0) {
                    cnt++;
                }
            }
        }
        return cnt;
    }

    private int dfs(char[][] grid, int i, int j) {
        if (i < 0 || i > grid.length -1 || j < 0 || j > grid[0].length - 1) {
            return 0;
        }
        if (grid[i][j] != '1') {
            return 0;
        }
        int cnt = 1;
        grid[i][j] = '2';
        cnt += dfs(grid, i - 1, j);
        cnt += dfs(grid, i + 1, j);
        cnt += dfs(grid, i, j - 1);
        cnt += dfs(grid, i, j + 1);
        return cnt;
    }

}
