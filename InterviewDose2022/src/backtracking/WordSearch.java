package backtracking;

/***
 * https://leetcode.com/problems/word-search/
 * Time Complexity :
 * Space Complexity :
 */
public class WordSearch {

    public static boolean isWordExist(char [][] board, String word)
    {
        for(int i = 0; i < board.length; i++)
        {
            for(int j = 0; j < board[i].length; j++)
            {
                if(board[i][j] ==  word.charAt(0) && dfs(board, i, j, 0, word))
                {
                    return true;
                }
            }
        }

        return false;
    }

    public static boolean isValid(int i, int j, int count, char[][]board, String word)
    {
        if(i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != word.charAt(count))
        {
            return true;
        }
        return false;
    }

    public static boolean dfs(char[][]board, int i, int j, int count, String word)
    {
        if(count == word.length())
        {
            return true;
        }

        if(isValid(i, j, count, board, word))
        {
            return false;
        }

        char temp = board[i][j];

        boolean found = dfs(board, i+1, j, count+1, word) ||
                        dfs(board, i-1, j, count+1, word) ||
                        dfs(board, i, j+1, count+1, word) ||
                        dfs(board, i, j-1, count+1, word);

        board[i][j] = temp;

        return found;


    }

    public static void main(String[] args) {
        char[][] board = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}};
        String word = "ABCCED";

        if(isWordExist(board, word))
        {
            System.out.println("Word Exist");
        }
        else
        {
            System.out.println("Word doesn't word");
        }
    }


}


