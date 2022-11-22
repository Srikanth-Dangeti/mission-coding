package StringPrg;

public class ReverseStrpreservingSpcaes {
	
	static void reverseString(String str)
	{
		char [] inputStringArray=str.toCharArray();
		char []resultArray=new char [str.length()];
		
		for (int i = 0; i < inputStringArray.length; i++) 
        {
            if (inputStringArray[i] == ' ') 
            {
                resultArray[i] = ' ';
            }
        }
         
        //Initializing 'j' with length of resultArray
         
        int j = resultArray.length-1;
                 
        //Second for loop :
        //we copy every non-space character of inputStringArray 
        //from first to last at 'j' position of resultArray
         
        for (int i = 0; i < inputStringArray.length; i++)
        {
            if (inputStringArray[i] != ' ') 
            {
                //If resultArray already has space at index j then decrementing 'j'
                 
                if(resultArray[j] == ' ')
                {
                    j--;
                }
                 
                resultArray[j] = inputStringArray[i];
                 
                j--;
            }
        }
         
        System.out.println("inputString"+"--->"+String.valueOf(resultArray));
		
	}
	public static void main(String []args)
	{
		reverseString("I Am Not String");
        
        reverseString("JAVA JSP ANDROID");
         
        reverseString("1 22 333 4444 55555");
	}

}
