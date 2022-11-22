package Testing;

import java.util.*;
public class CollapseString {

    public static String collapseString(String inputString) {
        if(null == inputString)
            return null;
        StringBuilder output = new StringBuilder();
        char currentChar = inputString.charAt(0);
        int repeating = 1, start=0;
        for(int i=1; i<inputString.length(); i++) {
            if(inputString.charAt(i) == currentChar) {
                repeating++;
            }else {
                output.append(repeating).append(currentChar);
                start=i;
                repeating = 1;
                currentChar =inputString.charAt(i);
            }
        }
        output.append(repeating).append(currentChar);
        return output.toString();
    }
    public static void main(String[] args) {
        System.out.println(collapseString("GGGTTGGGG"));
    }
}
