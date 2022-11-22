package Oracle;

import java.util.ArrayList;
import java.util.Scanner;

public class StockBuyandSell {
	
	public static void main (String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            int n=sc.nextInt();
            int arr[]=new int[n];
            for(int i=0;i<n;i++){
                arr[i]=sc.nextInt();
            }
            ArrayList<Integer> list=new ArrayList<Integer>();
            for(int i=0;i<n-1;){
                if(arr[i]<arr[i+1])
                {
                    list.add(i);
                    while(i<n-1&&arr[i]<=arr[i+1])
                    i++;
                    list.add(i);
                }
                    i++;
                }
                if(list.size()==0){
                    System.out.print("No Profit");
                }
                else{
                for(int i=0;i<list.size()-1;i+=2){
                    System.out.print("("+list.get(i)+" "+list.get(i+1)+")"+" ");
                }}
                System.out.println();
            }
        
}

}
