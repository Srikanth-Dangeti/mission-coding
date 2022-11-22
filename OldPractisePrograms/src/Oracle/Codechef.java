package Oracle;
import java.util.*;
import java.util.Map.*;
import java.lang.*;
import java.io.*;


class Codechef
{
                public static void main(String args[]) {
                     String str="vvbbannbvya";
        String arr[] = str.split("");
        Map<String, Integer> map = new HashMap<String, Integer>();
        int len = arr.length;
        for (int j = 0; j < len; j++) {
            if (map.get(arr[j]) == null) {
                map.put(arr[j], 1);
            } else {
                map.put(arr[j], (Integer) map.get(arr[j]) + 1);
            }
        }

        Set<Entry<String, Integer>> set = map.entrySet();
        ArrayList<Entry<String, Integer>> list = new ArrayList<Entry<String, Integer>>(set);
        list.sort(new Comparator<Entry<String, Integer>>() {
            @Override
            public int compare(Entry<String, Integer> o1, Entry<String, Integer> o2) {


                if (o1.getValue() < o2.getValue())
                {
                    return 1;
                }
                else if (o1.getValue() > o2.getValue())
                {
                    return -1;
                }
                else if (o1.getValue() == o2.getValue())
                {
                    return o1.getKey().compareTo(o2.getKey());
                }
                return 0;
            }
        });
        for (Map.Entry<String, Integer> en : list) {
            int val = en.getValue();
            while(val!=0){
            System.out.print(en.getKey());
            val--;
            }
        }
    }
}