package Google2020Series;

import java.util.LinkedList;
import java.util.Queue;


/**
 * https://www.youtube.com/watch?v=yf3oUhkvqA0&list=PLgUwDviBIf0oE3gA41TKO2H5bHpPd7fzn&index=11
 * Time Complexity : O ( n * m)
 * Space Complexity : O ( n * m)
 */
class Pair {
    int row;
    int col;
    int tm;

    Pair(int row, int col, int tm) {
        this.row = row;
        this.col = col;
        this.tm = tm;
    }
}

public class RottenOranges {

    public int orangesRotting(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        Queue<Pair> q = new LinkedList<>();

        int[][] visited = new int[rows][cols];
        int countFresh = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 2) {
                    q.add(new Pair(i, j, 0));
                    visited[i][j] = 2;
                } else {
                    visited[i][j] = 0;
                }

                if (grid[i][j] == 1)
                    countFresh++;


            }
        }

        int tm = 0;

        int drow[] = {-1, 0, 1, 0};
        int dcol[] = {0, 1, 0, -1};
        int count = 0;
        while (!q.isEmpty()) {
            int r = q.peek().row;
            int c = q.peek().col;
            int t = q.peek().tm;

            tm = Math.max(tm, t);

            q.remove();

            for (int i = 0; i < 4; i++) {
                int nrow = r + drow[i];
                int ncol = c + dcol[i];

                if (nrow >= 0
                        && ncol >= 0
                        && nrow < rows
                        && ncol < cols
                        && visited[nrow][ncol] == 0
                        && grid[nrow][ncol] == 1) {
                    q.add(new Pair(nrow, ncol, t + 1));
                    visited[nrow][ncol] = 2;
                    count++;
                }

            }
        }

        if (count != countFresh) return -1;

        return tm;
    }


    public static void main(String[] args) {
        int grid[][] = {{2, 1, 1}, {1, 1, 0}, {0, 1, 1}};
        RottenOranges rotten = new RottenOranges();
        System.out.println(rotten.orangesRotting(grid));
    }
}
