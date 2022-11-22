package Google2020Series;

import java.util.*;

/****
 * https://www.lintcode.com/problem/920/
 *  Time Complexity : O(nlogn)
 *  Space Complexity : O(1)
 */

class Intervals {
    int start;
    int end;
    Intervals(int start, int end)
    {
        this.start = start;
        this.end = end;
    }
}
public class MeetingRoom1 {
    public static boolean canAttendMeetings(List<Intervals> intervals) {

        Collections.sort(intervals, (a, b) -> a.start - b.start);

        /*Collections.sort(intervals, new Comparator<Intervals>() {
            @Override
            public int compare(Intervals o1, Intervals o2) {
                return o1.start - o2.start;
            }
        });*/

        for(int i = 0; i < intervals.size() - 1; i++)
        {
            if(intervals.get(i).end > intervals.get(i+1).start)
            {
                return false;
            }
        }

        return true;
    }
    public static void main(String []args)
    {
       ArrayList<Intervals> list = new ArrayList<>();
       list.add(new Intervals(0, 30));
       list.add(new Intervals(5,10));
       list.add(new Intervals(15,20));
        //(5,8),(9,15)
       /* list.add(new Intervals(5, 8));
        list.add(new Intervals(9, 15));*/

        if(canAttendMeetings(list))
        {
            System.out.println("Times will not conflict");
        }
        else
        {
            System.out.println("Times will conflict");
        }

    }
}
