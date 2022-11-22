package Google2020Series;

/**
 * Time Complexity:
 * O(N+M), where
 * N is a number of nodes (vertices) and
 * M is a number of edges.
 * Space Complexity:
 * O(N). This space is occupied by the visited hash map and in addition to that,
 * space would also be occupied by the recursion stack since we are adopting a recursive approach here.
 * The space occupied by the recursion stack would be equal to
 * O(H) where
 * H is the height of the graph. Overall, the space complexity would be
 * O(N).
 */
public class MaxAreaOfIslands {

    public int maxAreaOfIsland(int[][] grid) {

        int ans = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                ans = Math.max(ans, dfs(grid, i, j, grid.length, grid[i].length, new int[1]));
            }
        }

        return ans;
    }

    public int dfs(int[][] grid, int i, int j, int m, int n, int[] count) {
        if (i < 0 || j < 0 || i >= m || j >= n || grid[i][j] == 0 || grid[i][j] == 2)
            return count[0];

        count[0]++;
        grid[i][j] = 2;
        dfs(grid, i - 1, j, m, n, count);
        dfs(grid, i + 1, j, m, n, count);
        dfs(grid, i, j - 1, m, n, count);
        dfs(grid, i, j + 1, m, n, count);
        // We can do like this also return 1 + dfs(grid, i - 1, j, m, n, count)
        //       + dfs(grid, i + 1, j, m, n, count)
        //        + dfs(grid, i, j - 1, m, n, count)
        //       + dfs(grid, i, j + 1, m, n, count);
        return count[0];
    }
}
