package Google2020Series;

import java.util.ArrayList;
import java.util.List;

/***
 * https://leetcode.com/problems/letter-combinations-of-a-phone-number/
 *
 * Input: digits = "23"
 * Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]
 *
 * Time Complexity : O(2 power n)
 */
public class LetterCombinationOfPhoneNumber {

    public static List<String> letterCombinations(String digits) {
        List<String> combinations = new ArrayList<>();

        if (digits == null || digits.length() == 0) {
            return combinations;
        }

        String[] numberToStringMapping =
                {
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

        letterCombinationsUtil(combinations, digits, "", 0, numberToStringMapping);

        return combinations;
    }

    public static void letterCombinationsUtil(List<String> combinations,
                                              String digits,
                                              String current,
                                              int index,
                                              String numberToStringMapping[]) {
        if (index == digits.length()) {
            combinations.add(current);
            return;
        }

        String letters = numberToStringMapping[digits.charAt(index) - '0'];
        System.out.println(combinations);
        System.out.println("current = " +current);
        System.out.println(letters);

        for (int i = 0; i < letters.length(); i++) {
            letterCombinationsUtil(combinations,
                    digits,
                    current + letters.charAt(i),
                    index + 1,
                    numberToStringMapping);
        }

    }

    public static void main(String[] args) {

        System.out.println(letterCombinations("23"));
    }
}
