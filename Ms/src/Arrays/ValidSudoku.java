package Arrays;

import java.util.ArrayList;

public class ValidSudoku {

	public static void main(String [] args) 
	{
		
		
		//System.out.println('8'-'1');
		ArrayList al = new ArrayList();
		
		al.add(0, 1);
		al.add(0, 2);
		al.add(4);
		
		System.out.println(al.size());
		
		al.remove(0);
		//al.contains(3)
		System.out.println(al);
	}
}
