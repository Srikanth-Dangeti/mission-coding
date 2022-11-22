package Google2020Series;


import java.util.*;
import util.CodeHelper;

/***
 * Design a number container system that can do the following:
 *
 * Insert or Replace a number at the given index in the system.
 * Return the smallest index for the given number in the system.
 * Implement the NumberContainers class:
 *
 * NumberContainers() Initializes the number container system.
 * void change(int index, int number) Fills the container at index with the number. If there is already a number at that index, replace it.
 * int find(int number) Returns the smallest index for the given number, or -1 if there is no index that is filled by number in the system.
 */
public class NumberContainers {

    HashMap<Integer, ArrayList<Integer>> hmap;
    TreeMap<Integer, Integer> treeMap;
    public NumberContainers() {
        hmap = new HashMap<>();
        treeMap = new TreeMap<>();
    }

    public void change(int index, int number)
    {
        treeMap.put(index, number);
    }

    public int find(int number)
    {

        if(treeMap.containsValue(number))
        {
            return CodeHelper.getKey(treeMap, number);
        }

        return -1;
    }

    public static void main(String [] args)
    {
        NumberContainers nc = new NumberContainers();
        nc.find(10); // There is no index that is filled with number 10. Therefore, we return -1.
        nc.change(2, 10); // Your container at index 2 will be filled with number 10.
        nc.change(1, 10); // Your container at index 1 will be filled with number 10.
        nc.change(3, 10); // Your container at index 3 will be filled with number 10.
        nc.change(5, 10); // Your container at index 5 will be filled with number 10.
        nc.find(10); // Number 10 is at the indices 1, 2, 3, and 5. Since the smallest index that is filled with 10 is 1, we return 1.
        nc.change(1, 20); // Your container at index 1 will be filled with number 20. Note that index 1 was filled with 10 and then replaced with 20.
        System.out.println(nc.find(10)); // Number 10 is at the indices 2, 3, and 5. The smallest index that is filled with 10 is 2. Therefore, we return 2.
       /* TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        treeMap.put(2, 10);
        treeMap.put(1, 10);
        treeMap.put(3, 10);

        System.out.println(treeMap);;*/
    }
}