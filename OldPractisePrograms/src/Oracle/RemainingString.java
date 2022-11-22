package Oracle;

import java.util.Scanner;

public class RemainingString {


	public static void main (String[] args) {
		//code
		Scanner scan=new Scanner(System.in);
		int t=scan.nextInt();
		while(t-->0){
		    String str=scan.next();
		    char ch=scan.next().charAt(0);
		    int n=scan.nextInt();
		    int count=0;
		    boolean boo=true;
		    for(int i=0;i<str.length();i++){
		        if(count==n){
		            boo=false;
		            System.out.print(str.charAt(i));
		            continue;
		        }
		        else if(str.charAt(i)==ch){
		            count++;
		        }
		    }
		    if(boo){
		        System.out.print("Empty string");
		    }
		    System.out.println();
		}
	}
}
