package Arrays;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

public class SortStringcharonFrequnecy {
	
	static void sortByFreq(int ch[])
	{
		HashMap<Integer,Integer> m =new HashMap<Integer,Integer>();
		
		for(int i=0;i<ch.length;i++)
		{
			if(m.containsKey(ch[i]))
			{
				m.put(ch[i], m.get(ch[i])+1);
			}
			else
			{
				m.put(ch[i],1);
			}
		}
		LinkedList list=new LinkedList(m.entrySet());
		
		Collections.sort(list,new Comparator() {
			
			public int compare(Object obj1, Object obj2) {
	               return ((Comparable) ((Map.Entry) (obj1)).getValue()).compareTo(((Map.Entry) (obj2)).getValue());
	            }
			
		});
		
		int count=0;
		for(Iterator it=list.iterator();it.hasNext();)
		{
			Map.Entry entry = (Map.Entry) it.next();
			
			int key=(int)entry.getKey();
			int val=(int)entry.getValue();
			
			
		}
		
	}
	
	public static void main(String []args)
	{
		String str="1234511223344";
		//char ch[]=str.toCharArray();
		int ch[]= {1,2,3,1,3,2,4,4,5,1,2};
		System.out.println("Before Sorting");
		
		for(int i=0; i<ch.length; i++){
			
            System.out.print(ch[i] +" ");
        }
		
		sortByFreq(ch);
		System.out.println();
		
		System.out.println("After sorting");
		
		for(int i=0; i<ch.length; i++){
            System.out.print(ch[i] +" ");
        }
	}

}
