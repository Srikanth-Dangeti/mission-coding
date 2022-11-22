package Oracle;
import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;
// A simple java program to print
// records in a sorted manner
public class StringwithNumberSorting {
 
       // Function to sort the records
       static void sortRecords(String records) {
 
              // split the string on the basis of delimiter space(" ")
              String[] rec = records.split(" ");
               
              //Tree map to store employee's salary with employee's name
              Map<Integer,ArrayList<String>> map = new TreeMap<>();
               
              // Traverse the records array and store values in map
              for(int i = 1; i < rec.length; i+=2 ) 
              {
                  // Converting String to integer
                  int sal = Integer.parseInt(rec[i]);
                  String name = rec[i-1];
                  if(map.containsKey(sal)) 
                  {
                       ArrayList<String> al = map.get(sal);
                       al.add(name);
                       // Sorting list of employees having Salary sal
                       Collections.sort(al);
                       map.remove(sal);
                       map.put(sal,al);
                  }
                  else 
                  {
                       ArrayList<String> al = new ArrayList<>();
                       al.add(name);
                       map.put(sal,al);
                  }
              }
 
             // Traversing the map to print the sorted records
             for (Map.Entry<Integer, ArrayList<String>> entry : map.entrySet()) {
                  ArrayList<String> al1 = entry.getValue();
                  System.out.println(al1);
                  for(int i = 0;i < al1.size();i++) 
                      System.out.print(al1.get(i)+" "+entry.getKey() + " ");
             }
       }
        
       // Driver code
       public static void main(String args[]) throws Exception {
                BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
                
                int t=Integer.parseInt(br.readLine());
                while(t>0)
                {
                    int n=Integer.parseInt(br.readLine());
                    
                    String records="";
                        records=br.readLine();
                    
                    
              // Calling function to sort the records
              sortRecords(records);
                    System.out.println();
              t--;
                }
 
       }
}