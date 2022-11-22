package Google2020Series;

import java.util.*;

/**
 Time Complexity : O(n * m)
 Space Complexity : O(n * m);
 */
public class SurroundedRegions {

    public void surroundedRegions(char[][] board)
    {
        int row = board.length;
        int col = board[0].length;

        for (int i = 0; i < col; i++) {
            if (board[0][i] == 'O') dfs(board, 0, i);
            if (board[row - 1][i] == 'O') dfs(board, row - 1, i);
        }

        for (int i = 0; i < row; i++) {
            if (board[i][0] == 'O') dfs(board, i, 0);
            if (board[i][row - 1] == 'O') dfs(board, i, row - 1);
        }

        for (int i = 0; i < row; i++)
        {
            for (int j = 0; j < col; j++)
            {
                if (board[i][j] == 'O')
                {
                    board[i][j] = 'X';
                } else if (board[i][j] == '1')
                {
                    board[i][j] = 'O';
                }
            }
        }
    }

    public void dfs(char[][] board, int i, int j)
    {
        if (i < 0 || i >= board.length || j < 0 || j >= board[i].length || board[i][j] != 'O') {
            return;
        }

        board[i][j] = '1';

        dfs(board, i + 1, j);
        dfs(board, i - 1, j);
        dfs(board, i, j + 1);
        dfs(board, i, j - 1);
    }

    public static void main(String[] args) {

        char[][] board = {{'X', 'X', 'X', 'X'},
                          {'X', 'O', 'O', 'X'},
                          {'X', 'X', 'O', 'X'},
                          {'X', 'O', 'X', 'X'}};

        SurroundedRegions obj = new SurroundedRegions();

        obj.surroundedRegions(board);

        System.out.println(Arrays.deepToString(board));

    }
}
