package TrieandRelatedQuestions;


/*
 * This is hiring manager round but not looks like hiring manager round :)
he started with the problem and the problem was you have given the matrix of n*n 
which contains the small character only and you have given the dictionary as well 
which contain the English valid word, you have to find the how many 
word can be formed using this matrix, the word must contain in dictionary, 
you can move in matrix to left, right, top, bottom and diagonal
t o p
a g i
b r g

the possible Words are:- 1. top 2. tab 3. bat 4. pig 5. bag 6. gip

discussion about what data structure you have to use for Dictionary and 
i have solve this problem by using of DFS. and for dictionary i have used the Trie data structure.
 */
public class WordBoggleMSQuestion {
	
	// Alphabet size
		static final int ALPHABET_SIZE = 26;

		static final int M = 3;
		static final int N = 3;
        static int count =0;
		
		static class TrieNode 
		{
			TrieNode[] Child = new TrieNode[ALPHABET_SIZE];

			
			boolean isEndOfWord;

			
			public TrieNode()
			{
				isEndOfWord = false;
				for (int i = 0; i < ALPHABET_SIZE; i++)
					Child[i] = null;
			}
		}
		
		static TrieNode root;

		static void insert(TrieNode root, String Key)
		{
			int n = Key.length();
			TrieNode temp = root;

			for (int i = 0; i < n; i++) {
				int index = Key.charAt(i) - 'a';

				if (temp.Child[index] == null)
					temp.Child[index] = new TrieNode();

				temp = temp.Child[index];
			}

			
			temp.isEndOfWord = true;
		}

		
		static boolean isSafe(int i, int j, boolean visited[][])
		{
			return (i >= 0 && i < M && j >= 0
					&& j < N && !visited[i][j]);
		}

		
		static void searchWord(TrieNode root, char matrix[][], int i,
							int j, boolean visited[][], String str)
		{
			
			if (root.isEndOfWord == true)
			{
				count++;
			}

			
			if (isSafe(i, j, visited)) 
			{
				
				visited[i][j] = true;

				
				for (int K = 0; K < ALPHABET_SIZE; K++) 
				{
					if (root.Child[K] != null) 
					{
						
						char ch = (char)(K + 'a');
	                    System.out.println("ch = "+ch);

						
	                    
	                    for (int row = i - 1; row <= i + 1 && row < matrix.length; row++) {
	                        for (int col = j - 1; col <= col + 1 && col < matrix[0].length; col++) {
	                            if (row >= 0 && col >= 0 && !visited[row][col]) {
	                            	if (isSafe(row, col, visited)&& matrix[row][col] == ch)
	        							searchWord(root.Child[K], matrix,row, col, visited, str + ch);
	                            }
	                        }
	                    }
						
					}
				}

				visited[i][j] = false;
			}
		}

		
		static void findWords(char matrix[][], TrieNode root)
		{
			
			boolean[][] visited = new boolean[M][N];
			TrieNode temp = root;

			String str = "";

			
			for (int i = 0; i < M; i++) 
			{
				for (int j = 0; j < N; j++) 
				{
					
					if (temp.Child[(matrix[i][j]) - 'a'] != null) 
					{
	                     System.out.println("matrix[i][j] = "+matrix[i][j]);
						str = str + matrix[i][j];
	                    System.out.println("str= "+str);
	                    
						searchWord(temp.Child[(matrix[i][j]) - 'a'],matrix, i, j, visited, str);
						
						str = "";
					}
				}
			}
		}

		
		public static void main(String args[])
		{
			
			String dictionary[] = {  "gee","geeks", "for", "quiz" };

			root = new TrieNode();

			//insrtion
			for (int i = 0; i < dictionary.length; i++)
				insert(root, dictionary[i]);

			char matrix[][] = { { 'g', 'i', 'z' },
								{ 'u', 'e', 'k' },
								{ 'q', 's', 'e' } };

			findWords(matrix, root);
			System.out.println("Total words can be formed =  "+count);
		}

}
