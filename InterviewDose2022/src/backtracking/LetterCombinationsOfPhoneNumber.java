package backtracking;

import java.util.ArrayList;
import java.util.List;

public class LetterCombinationsOfPhoneNumber {
    public static List<String> letterCombination(String digits) {
        List<String> combinations = new ArrayList<String>();
        if (digits == null || digits.length() == 0) {
            return combinations;
        }
        String[] mapping = {
                "0",
                "1",
                "abc",
                "def",
                "ghi",
                "jkl",
                "mno",
                "pqrs",
                "tuv",
                "wxyz"
        };

        letterCombinationUtil(combinations, digits, "", 0, mapping);
        return combinations;

    }

    public static void letterCombinationUtil(List<String> result, String digits, String currentCombination,
                                             int index,
                                             String[] mapping) {
        if (index == digits.length()) {
            result.add(currentCombination);
            return;
        }

        String letters = mapping[digits.charAt(index) - '0'];

        for (int i = 0; i < letters.length(); i++) {
            letterCombinationUtil(result,
                    digits,
                    currentCombination + letters.charAt(i),
                    index + 1, mapping);
        }

    }

    public static void main(String[] args) {
            System.out.println(letterCombination("23"));
    }
}
