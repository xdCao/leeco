package org.example.hot100.graph;

import java.util.LinkedList;
import java.util.Queue;

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


    public int orangesRotting(int[][] grid) {
        if (check(grid)) {
            return 0;
        }
        Queue<Locator> queue = new LinkedList<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 2) {
                    queue.add(new Locator(i, j));
                }
            }
        }
        int turn = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Locator poll = queue.poll();
                if (poll.m - 1 >= 0 && grid[poll.m - 1][poll.n] == 1) {
                    grid[poll.m - 1][poll.n] = 2;
                    queue.add(new Locator(poll.m - 1, poll.n));
                }

                if (poll.m + 1 < grid.length && grid[poll.m + 1][poll.n] == 1) {
                    grid[poll.m + 1][poll.n] = 2;
                    queue.add(new Locator(poll.m + 1, poll.n));
                }

                if (poll.n - 1 >= 0 && grid[poll.m][poll.n - 1] == 1) {
                    grid[poll.m][poll.n - 1] = 2;
                    queue.add(new Locator(poll.m, poll.n - 1));
                }

                if (poll.n + 1 < grid[0].length && grid[poll.m][poll.n + 1] == 1) {
                    grid[poll.m][poll.n + 1] = 2;
                    queue.add(new Locator(poll.m, poll.n + 1));
                }
            }
            turn++;
        }
        boolean check = check(grid);
        if (check) {
            return turn - 1;
        }
        return -1;
    }

    class Locator {
        int m;
        int n;

        public Locator(int m, int n) {
            this.m = m;
            this.n = n;
        }
    }

}
