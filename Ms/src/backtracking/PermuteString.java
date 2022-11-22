package backtracking;
public class PermuteString {  
    //Function for swapping the characters at position I with character at position j  
    public static String swapString(String a, int i, int j) 
    {  
    	char temp; 
        char[] charArray = a.toCharArray(); 
        temp = charArray[i] ; 
        charArray[i] = charArray[j]; 
        charArray[j] = temp; 
        return String.valueOf(charArray); 
    }  
      
    public static void main(String[] args)  
    {  
        String str = "1234";  
        int len = str.length();  
        System.out.println("All the permutations of the string are: ");  
        generatePermutation(str, 0, len-1);  
    }  
      
    //Function for generating different permutations of the string  
    public static void generatePermutation(String str, int start, int end)  
    {  
        //Prints the permutations  
        if (start == end)  
            System.out.println(str);  
        else  
        {  
            for (int i = start; i <= end; i++)  
            {  
                //Swapping the string by fixing a character  
                str = swapString(str,start,i); 
                //System.out.println("Before calling generatePermutation "+ str);
                //Recursively calling function generatePermutation() for rest of the characters
                //System.out.println("Start = "+start);
                
                generatePermutation(str,start+1,end);  
                
                //System.out.println("After calling generatePermutation");
                //Backtracking and swapping the characters again.  
                str = swapString(str,start,i);  
                
                //System.out.println("last swap "+str);
            }  
        }  
    }  
}