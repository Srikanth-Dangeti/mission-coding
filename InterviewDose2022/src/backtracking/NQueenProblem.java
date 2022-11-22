package backtracking;

import java.util.*;
/***
 *
 *  Date - 28/06/2022
 *  * Given nxn board place n queen on this board so that they dont attack each other. One solution is to find
 *  * any placement of queens which do not attack each other. Other solution is to find all placements of queen
 *  * on the board.
 *  *
 *  * Time complexity O(n*n)
 *  * Space complexity O(n*n)
 *
 *
 *  * Solution for https://leetcode.com/problems/n-queens/
 *
 */
public class NQueenProblem {

    class Position {
        int row, col;

        Position(int r, int c) {
            this.row = r;
            this.col = c;
        }
    }

    /***
     *
     * @param n
     * @return
     */
    public Position[] solveNQueenOneSolution(int n) {
        Position[] vertex = new Position[n];
        boolean hasSolution = solveNQueenOneSolutionUtil(n, 0, vertex);
        if (hasSolution)
            return vertex;
        else
            return new Position[0];

    }

    /***
     *
     * @param n
     * @param row
     * @param vertex
     * @return
     */
    public boolean solveNQueenOneSolutionUtil(int n, int row, Position[] vertex) {
        if (n == row)
            return true;

        int col;
        for (col = 0; col < n; col++) {
            boolean foundSafe = true;

            //check if this current row and col is not under attack by previous placement of the queeen
            for (int index = 0; index < row; index++) {
                if (vertex[index].col == col || vertex[index].row - vertex[index].col == row - col ||
                        vertex[index].row + vertex[index].col == row + col) {
                    foundSafe = false;
                    break;
                }
            }

            if (foundSafe) {
                vertex[row] = new Position(row, col);

                if (solveNQueenOneSolutionUtil(n, row + 1, vertex))
                    return true;
            }

        }
        return false;
    }

    public static void main(String[] args) {
        NQueenProblem s = new NQueenProblem();
        Position[] positions = s.solveNQueenOneSolution(4);
        Arrays.stream(positions).forEach(position -> System.out.println(position.row + " " + position.col));
    }
}
