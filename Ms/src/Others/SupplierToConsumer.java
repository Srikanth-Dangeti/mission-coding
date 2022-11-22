package Others;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.DoubleSupplier;
import java.util.function.Supplier;

public class SupplierToConsumer {

	public static ArrayList<String> al =new ArrayList<>();
	
	public static int suppliers()
	{
		Random rand  = new Random();
		int size  =al.size();//got the no of employees present.
		//for(int i =0; i<size; i++)
		{
			int j=rand.nextInt(size);
			return j;
			//System.out.println("Calling the consumer on this index");
			//printConsumer(j);
		}
		
		
		
	}
	// Getting random index everytime my dear pran.
	public static void printConsumer(int index)
	{
		//System.out.println("Got the names for consumation");
		System.out.println("random index= "+index);
		System.out.println("Name = "+ al.get(index));
	}
	
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub

		Scanner sc =new Scanner(System.in);
		System.out.println("Enter the no of employees required");
		int n = sc.nextInt();
		System.out.println("enter the names one by one");
		
		for(int i =0 ; i < n; i++)
		{
			al.add(sc.next());
		}
		
		
		
		Supplier<Integer> randomValue = SupplierToConsumer::suppliers;   //Supplier functional interface
		
		
		Consumer<Integer> consumer1 = SupplierToConsumer::printConsumer;  //consumer interface in java 8
		
		for(int i= 0; i < n ;i++)
		{
			
			consumer1.accept(randomValue.get());   // Calling printConsumer method with index 
		}
		
		
		
		
         
		
	}

}
