package Google2020Series;


import java.util.*;

/**
 * https://leetcode.com/problems/pacific-atlantic-water-flow/submissions/
 * Time Complexity : O(m * n)
 * Space Complexity : O(M * N)
 * https://www.youtube.com/watch?v=krL3r7MY7Dc
 */
public class PacificAtlanticWaterFlow {

     int dir[][] = {{0,1}, {0,-1}, {1,0}, {-1,0}};
    public List<List<Integer>> pacificAtlantic(int[][] matrix) {
        List<List<Integer>> res = new ArrayList<>();

        if(matrix == null || matrix.length == 0 || matrix[0].length == 0)
        {
            return res;
        }

        int row = matrix.length, col = matrix[0].length;

        boolean [][] pacific = new boolean[row][col];
        boolean [][] atlantic = new boolean[row][col];

        //DFS

        for (int i = 0; i < col; i++)
        {
            dfs(matrix, 0, i, Integer.MIN_VALUE, pacific);
            dfs(matrix, row-1, i, Integer.MIN_VALUE, atlantic);
        }

        for(int i = 0; i < row; i++){
            dfs(matrix, i, 0, Integer.MIN_VALUE, pacific);
            dfs(matrix, i, col-1, Integer.MIN_VALUE, atlantic);
        }

        //preparing the result

        for (int i = 0; i < row; i++)
        {
            for (int j = 0; j < col; j++)
            {
                if(pacific[i][j] && atlantic[i][j])
                {
                    res.add(Arrays.asList(i, j));
                }
            }
        }



        return res;
    }

    public  void dfs(int [][] matrix, int i, int j, int prev, boolean ocean[][])
    {
        if(i < 0 || i >= matrix.length || j < 0 || j >= matrix[i].length)
            return;

        if(matrix[i][j] < prev || ocean[i][j])
            return;

        ocean[i][j] = true;

        for(int [] d : dir)
        {
            dfs(matrix, i + d[0], j + d[i], matrix[i][j], ocean);
        }
    }

    public static void main(String []args)
    {

    }
}
