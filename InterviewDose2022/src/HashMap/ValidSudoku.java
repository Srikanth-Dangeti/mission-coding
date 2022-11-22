package HashMap;

/**
 * https://leetcode.com/problems/valid-sudoku/
 */
public class ValidSudoku {

    /**
     * 
     * @param board
     * @return
     */
    public static boolean isValidSudoku(char board[][]) {
        if (board == null || board.length != 9 || board[0].length != 9) {
            return false;
        }

        // Check for each Column

        for (int i = 0; i < board.length; i++) {
            boolean visited[] = new boolean[board.length];
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] != '.') {
                    if (visited[(int) board[i][j] - '1']) {
                        return false;
                    }

                    visited[(int) board[i][j] - '1'] = true;
                }
            }
        }

        // check for the row now

        for (int i = 0; i < board.length; i++) {
            boolean visited[] = new boolean[board.length];
            for (int j = 0; j < board[0].length; j++) {
                if (board[j][i] != '.') {
                    if (visited[(int) board[j][i] - '1']) {
                        return false;
                    }

                    visited[(int) board[j][i] - '1'] = true;
                }
            }
        }

        // check each 3*3 matrix
        //check each 3*3 matrix
	for (int block = 0; block < 9; block++) {
		boolean[] m = new boolean[9];
        System.out.println("block = "+block);
        System.out.println("block / 3 * 3  = "+block / 3 * 3);
        System.out.println("block / 3 * 3 + 3 = "+ (block / 3 * 3 + 3));
		for (int i = block / 3 * 3; i < block / 3 * 3 + 3; i++) {
            //System.out.println("Debugging");
			for (int j = block % 3 * 3; j < block % 3 * 3 + 3; j++) {
				if (board[i][j] != '.') {
					if (m[(int) (board[i][j] - '1')]) {
						return false;
					}
					m[(int) (board[i][j] - '1')] = true;
				}
			}
		}
	}


        return true;
    }

    public static void main(String[] args) {

        char board[][] = { 
                            { '5', '3', '.', '.', '7', '.', '.', '.', '.' },
                            { '6', '.', '.', '1', '9', '5', '.', '.', '.' }, 
                            { '.', '9', '8', '.', '.', '.', '.', '6', '.' },
                            { '8', '.', '.', '.', '6', '.', '.', '.', '3' }, 
                            { '4', '.', '.', '8', '.', '3', '.', '.', '1' },
                            { '7', '.', '.', '.', '2', '.', '.', '.', '6' }, 
                            { '.', '6', '.', '.', '.', '.', '2', '8', '.' },
                            { '.', '.', '.', '4', '1', '9', '.', '.', '5' }, 
                            { '.', '.', '.', '.', '8', '.', '.', '7', '9' } 
                         };

        if (isValidSudoku(board)) {
            System.out.println("Valid");
        } else {
            System.out.println("Not a Valid Suduko");
        }
    }
}
