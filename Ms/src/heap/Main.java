package heap;

class Main
{
    // Function to find out the minimum number of deletions required to
    // convert a given string `X[i…j]` into a palindrome
    public static int minDeletions(String X, int i, int j)
    {
        // base condition
        if (i >= j) {
            return 0;
        }
 
        // if the last character of the string is the same as the first character
        if (X.charAt(i) == X.charAt(j)) {
            return minDeletions(X, i + 1, j - 1);
        }
 
        // otherwise, if the last character of the string is different from the
        // first character
 
        // 1. Remove the last character and recur for the remaining substring
        // 2. Remove the first character and recur for the remaining substring
 
        // return 1 (for remove operation) + minimum of the two values
 
        return 1 + Math.min(minDeletions(X, i, j - 1), minDeletions(X, i + 1, j));
    }
 
    public static void main(String[] args)
    {
        String X = "ervervige";
        int n = X.length();
 
        System.out.print("The minimum number of deletions required is " +
                                minDeletions(X, 0, n - 1));
    }
}