package Arrays;
import java.util.*;

/***
 *
 *
 * Q 1. Given an array of random numbers, how can one find length of the longest consecutive sequence?
 *
 * Ex 2, 3, 93, 8, 5, 6, 7, 8, 2, 0, 3, 4, 5, 9
 * 2, 3, 93, 8,7,6,5,4,5,6,7,8,9
 * [2, 3 ,2] Ans - 2
 * increaasing flag =false
 *
 * Ans: 4
 * Explaination :
 *  Two varibales
 *  result = 0;
 *  current = 0 ;
 *  CurrentElement = a[0]-1;
 *  for()
 *  {
 *     if(2 ==currentElement+1)
 *     {
 *         current++;
 *
 *     }
 *  }
 *
 * Q. Given a graph, find all the nodes that are dependent on a specific node
 *
 *     y   z
 *
 * A->c      x
 *
 * B      C
 *
 *  D       E
 *  Input is Node C
 *
 * Output - A, X, Y, Z
 *
 *  Ajanceny List :
 *  A -> B, C
 *  B ->
 *  C -> D, E
 *  D ->
 *  E ->
 *  X -> C
 *  Y -> X
 *  Z -> X
 *
 */
public class Qualcomm {

    public static int longestIncreasingSequence(int[] arr){
        if(arr == null)
            return -1;
        if(arr.length == 0 || arr.length == 1)
            return 1;
  //[2,3]

        //2,3,4,3,2,1
        int current=0,currentElement = arr[0]-1,result = 0;
        boolean increasing_flag = true;//1
        for(int i =0;i<arr.length;i++){
            if(arr[i]==(currentElement+1)){
                if(increasing_flag == true) {

                    current++;//1
                }
                else{
                    current = 2;// need to modify
                    increasing_flag = true;
                }

                if (current > result) {
                    result = current;
                }
                currentElement = arr[i]; //2
            }
            else if(arr[i]==(currentElement-1)){
                if(increasing_flag== false){
                    current ++;
                }
                else{
                    increasing_flag = false;
                    current = 2;
                }

                if(current>result){
                    result = current;
                }
                currentElement = arr[i];
            }
            else {
                current = 1;
                currentElement  = arr[i];
            }
        }
        return current==0?1:result;
    }

    public static void main(String[] args) {
        int[] arr = {2, 3, 93, 8, 5, 6, 7, 8, 2, 0, 3, 4, 5, 9};

        System.out.println(longestIncreasingSequence(arr));
    }


    /***
     * Ajanceny List :
     *  *  A -> B, C
     *  *  B ->
     *  *  C -> D, E
     *  *  D ->
     *  *  E ->
     *  *  X -> C
     *  *  Y -> X
     *  *  Z -> X
     * @param map
     * @param node
     * @return
     */
    public List<Character> dependentList(Map<Character,List<Character>> map, Character node){

        Queue<Character> queue = new LinkedList<>();
        List<Character> resultSet= new ArrayList<>();
        Map<Character,Boolean> visitedMap = new HashMap<>();
        for(Map.Entry<Character,List<Character>> entry: map.entrySet()){
            visitedMap.put(entry.getKey(),false);
            if(entry.getValue().contains(node)){
                queue.add(entry.getKey());// A and X
            }
        }

         if(queue.isEmpty()==true)
             return new ArrayList<Character>();

        while(queue.isEmpty()){
            Character node1 = queue.poll();
            visitedMap.put(node1,true); //A -> true
            for(Map.Entry<Character,List<Character>> entry: map.entrySet()){

                if(entry.getValue().contains(node1) && visitedMap.get(entry.getKey())){
                    queue.add(entry.getKey());
                }
            }
            resultSet.add(node1);
        }

        return resultSet;

    }
}
