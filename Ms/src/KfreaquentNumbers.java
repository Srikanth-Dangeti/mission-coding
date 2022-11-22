import java.util.*;

public class KfreaquentNumbers {
    class Pair {
        int index;
        int value;
        public Pair(int index, int value) {
         this.index = index;
         this.value = value;
        }
        public Integer getindex() 
	    { 
	        return index; 
	    } 
    }
    public static void printtopkfrequentelements(int[] a, int k) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        PriorityQueue<Pair> minHeap = new PriorityQueue<>(new Comparator<Pair>(){
            public int compare(Pair p1, Pair p2) 
            { 
            	
            	
            	if (p1.value < p2.value)
                {
                    return -1;
                }
                else if (p1.value > p2.value)
                {
                    return 1;
                }
                else if (p1.value == p2.value)
                {
                	Integer index1 = p1.index;
                	Integer index2= p2.index;
                    return index1.compareTo(index2);
                }
                return 0;
            } 
        });

        for(int i=0; i<a.length;i++) {
            if(map.containsKey(a[i])) {
                map.put(a[i], map.get(a[i])+1);
            } else {
                map.put(a[i],1);
            }
        }
        System.out.println(map);
        for (Integer val : map.keySet())
        {
            Integer key = map.get(val);
            System.out.println("Key  " + key + "  value  " + val);
            minHeap.add(new KfreaquentNumbers().new Pair(val, key));
            if (minHeap.size() > k) {
	            minHeap.poll();
	        }

        }
	    
	    while(minHeap.size() > 0)
	    {
	    	System.out.println(minHeap.poll().value);
	    }
    }

    public static void main(String[] args) {
        int a[] = {1,1,1,1,3,3,3,3,3,2,3,3,2,2,2,2,6,4};
		int k=2;
		printtopkfrequentelements(a, k);
    }
}