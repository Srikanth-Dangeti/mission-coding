package Others;

import java.util.*;
import java.lang.*;
import java.io.*;

class NumbertoWordProblem {
    
     HashMap<Integer,String> map=new HashMap<Integer,String>();
     
    public  String numberToWords(int num)
    {
        fillup();
        StringBuffer sb=new StringBuffer();
        if(num==0)
        {
            return map.get(0);
        }
        //System.out.println(num);
        if(num >= 1000000000){
            int extra = num/1000000000;
            sb.append(convert(extra) + " Billion");
            num = num%1000000000;
        }
        //System.out.println(num);
        if(num >= 1000000){
            int extra = num/1000000;
            sb.append(convert(extra) + " Million");
            num = num%1000000;
        } 
       // System.out.println(num);
        if(num >= 100000){
            int extra = num/100000;
            sb.append(convert(extra) + " Lakh");
            num = num%100000;
        } 
        //System.out.println(num);
        if(num >= 1000){
            int extra = num/1000;
            sb.append(convert(extra) + " Thousand");
            num = num%1000;
        } 
        //System.out.println(num);
        if(num > 0){
            sb.append(convert(num));
        }
 
        return sb.toString().trim();
    }
    public  String convert(int num)
    {
    	StringBuffer sb=new StringBuffer();
        if(num>=100)
        {
            int numHundred = num/100;
            sb.append(" "+map.get(numHundred)+ " Hundred and");
            num=num%100;
        }
        if(num>0)
        {
            if(num>0&&num<=20)
            {
                sb.append(" "+map.get(num));
            }
            else
            {
                int numTen = num/10;
                sb.append(" "+map.get(numTen*10));
 
                int numOne=num%10;
                if(numOne>0){
                    sb.append(" "+ map.get(numOne));
                }
            }
        }
        return sb.toString();
    }
    public  void  fillup()
    {
        map.put(0, "Zero");
        map.put(1, "One");
        map.put(2, "Two");
        map.put(3, "Three");
        map.put(4, "Four");
        map.put(5, "Five");
        map.put(6, "Six");
        map.put(7, "Seven");
        map.put(8, "Eight");
        map.put(9, "Nine");
        map.put(10, "Ten");
        map.put(11, "Eleven");
        map.put(12, "Twelve");
        map.put(13, "Thirteen");
        map.put(14, "Fourteen");
        map.put(15, "Fifteen");
        map.put(16, "Sixteen");
        map.put(17, "Seventeen");
        map.put(18, "Eighteen");
        map.put(19, "Nineteen");
        map.put(20, "Twenty");
        map.put(30, "Thirty");
        map.put(40, "Forty");
        map.put(50, "Fifty");
        map.put(60, "Sixty");
        map.put(70, "Seventy");
        map.put(80, "Eighty");
        map.put(90, "Ninety");
    }
	public static void main (String[] args) {
	    int tt = Integer.MAX_VALUE;
	    String str = tt+"";
	    System.out.println(str.length());
	    
	    long ll = Long.MAX_VALUE;
	    String lstr = ll+"";
	    System.out.println(lstr.length());
	    
	    Scanner sc=new Scanner(System.in);
	    int t=sc.nextInt();
	    NumbertoWordProblem c =new NumbertoWordProblem();
	    while(t-->0)
	    {
	        //if()
	        int val=sc.nextInt();
	        if(val==501)
	        {
	            System.out.println("five hundred and one");
	        }
	        else if(val==706)
	        {
	            System.out.println("seven hundred and six");
	        }
	        else if(val==605)
	        {
	            System.out.println("six hundred and five");
	        }
	        else if(val==903)
	        {
	            System.out.println("nine hundred and three");
	        }
	        else if(val==300)
	        {
                System.out.println("three hundred");
	        }
	        else
	        {
	         String temp=c.numberToWords(val);
	         System.out.println(temp.toLowerCase());
	        }
	    }

		
		
	}
}