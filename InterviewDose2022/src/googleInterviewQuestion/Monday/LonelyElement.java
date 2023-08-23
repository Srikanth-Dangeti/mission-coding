package googleInterviewQuestion.Monday;

import java.util.*;

/***
 *
 * https://leetcode.com/problems/find-all-lonely-numbers-in-the-array/description/
 *
 *
 *
 *
 */
public class LonelyElement {
    /***
     * https://leetcode.com/problems/find-all-lonely-numbers-in-the-array/description/
     * @param nums
     * @return
     */
    public static List<Integer> findLonely(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        for(int i : nums)
            map.put(i,map.getOrDefault(i,0)+1);
        for(int i : map.keySet())
            if(!map.containsKey(i-1)&& !map.containsKey(i+1) && map.get(i) == 1)
                list.add(i);
        return list;
    }
    public static void main(String[] args) {
        int a[] = {1, 4, 2}; // 1, 2, 4
        System.out.println(findLonely(a));
    }
}
