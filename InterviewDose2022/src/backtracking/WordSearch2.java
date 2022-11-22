package backtracking;

import java.util.ArrayList;
import java.util.List;

public class WordSearch2 {

    public static List<String> findWords(char [][]board, String[]words)
    {
        List<String> foundWords = new ArrayList<String>();
        for(String word : words)
        if(WordSearch.isWordExist(board, word))
        {
            foundWords.add(word);
        }

        return foundWords;
    }
    public static void main(String[] args) {
        char[][] board = {{'o', 'a', 'a', 'n'},
                {'e', 't', 'a', 'e'}, {'i', 'h', 'k', 'r'}, {'i', 'f', 'l', 'v'}};
        String words[] = {"oath", "pea", "eat", "rain"};

        System.out.println("List of the words Exist = "+ findWords(board, words));
    }
}
