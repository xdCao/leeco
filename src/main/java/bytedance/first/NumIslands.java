package bytedance.first;

/**
 * @author buku.ch
 * @Desc
 * @date 2023/11/18 16:15
 */
public class NumIslands {

    public int numIslands(char[][] grid) {
        int cnt = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                boolean dfs = dfs(grid, i, j);
                if (dfs) {
                    cnt++;
                }
            }
        }
      return cnt;
    }

    private boolean dfs(char[][] grid, int i, int j) {
        if (i > grid.length - 1 || i < 0 || j > grid[0].length - 1 || j < 0) {
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
