
package Arrays;

import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.TreeMap;
import java.util.Map.Entry;

public class SortByFrequency {
	@SuppressWarnings("unchecked")
	static void sortByFreq(int a[]){
        Map<Integer, Integer> map = new TreeMap<> ();
        
       
       for(int i=0; i<a.length; i++){
           if(map.get(a[i]) == null){
               map.put(a[i], 1);
            }
           else{
               int frequency = map.get(a[i]);
               map.put(a[i], frequency+1);
           }
       }
       
       
       
       List list = new LinkedList(map.entrySet());
       
       //System.out.println(list);
       /* Sort the list elements based on frequency */
       Collections.sort(list, new Comparator<Entry<Integer, Integer>>() {
            @Override
            /*public int compare(Object obj1, Object obj2) {
               return ((Comparable) ((Map.Entry) (obj1)).getValue())
                  .compareTo(((Map.Entry) (obj2)).getValue());
            }*/
            public int compare(Entry<Integer, Integer> o1, Entry<Integer, Integer> o2) {

            	System.out.println("o1.getValue() = "+ o1.getValue());
            	System.out.println("o2.getValue() = "+o2.getValue());
                if (o1.getValue() < o2.getValue())
                {
                    return -1;
                }
                else if (o1.getValue() > o2.getValue())
                {
                    return 1;
                }
                else if (o1.getValue() == o2.getValue())
                {
                    return o1.getKey().compareTo(o2.getKey());
                }
                return 0;
            }
       }
       
       );
       
       int count=0;
       
      
       for (Iterator it = list.iterator(); it.hasNext();) {
            Map.Entry entry = (Map.Entry) it.next();
            
            int key = (int)entry.getKey();
            int val = (int)entry.getValue();
            //System.out.println(key);
            //System.out.println(val);
            for(int i=0; i < val; i++){
                a[count] = key;
                count++;
            }            
       } 
       
       
       
    }
	public static void main(String args[]){
        int a[] = {5,4,4,3,2,1,0,5,3,2,4,1,2,3,5};
        String str="vannaya";
        char []ch=str.toCharArray();
        System.out.println("Before Sorting");
        for(int i=0; i<a.length; i++){
            System.out.print(a[i] +" ");
        }
        
        sortByFreq(a);
        
        System.out.println("\nAfter Sorting");
        for(int i=0; i<a.length; i++){
            System.out.print(a[i] +" ");
        }
    }

}
