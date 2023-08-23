package googleInterviewQuestion;

import java.util.*;

/***
 *
 * https://www.geeksforgeeks.org/check-if-the-given-array-can-be-constructed-uniquely-from-the-given-set-of-subsequences/
 *
 * Time complexity :
 * The time complexity of the above algorithm will be O(N+E),
 * where ‘N’ is the number of elements and ‘E’ is the total number of the rules.
 * Since, at most, each pair of numbers can give us one rule,
 * we can conclude that the upper bound for the rules is O(M)
 * where ‘M’ is the count of numbers in all sequences.
 * So, we can say that the time complexity of our algorithm is O(N + M).
 * Auxiliary Space : O(N+ M), since we are storing all possible rules for each element.
 */
public class ConstructArrayUsingUniqueSequence {

    public static boolean canReConstruct(int[] originalArray, int[][] sequence) {
        List<Integer> sortedOrder = new ArrayList<>();
        if (originalArray.length <= 0) {
            return false;
        }

        //Count the incoming edges for each vertex using the below map
        Map<Integer, Integer> inDegree = new HashMap<Integer, Integer>();

        //Adjacency list graph
        Map<Integer, ArrayList<Integer>> graph = new HashMap<>();

        for (int[] seq : sequence) {
            for (int i = 0; i < seq.length; i++) {
                inDegree.put(seq[i], 0);
                graph.put(seq[i], new ArrayList<>());
            }
        }

        //Build the graph

        for (int[] seq : sequence) {
            for (int i = 1; i < seq.length; i++) {
                int parent = seq[i - 1], child = seq[i];
                graph.get(parent).add(child);
                inDegree.put(child, inDegree.get(child) + 1);
            }
        }

        System.out.println(inDegree);
        System.out.println(graph);
        //if ordering rules for all the numbers are not present

        if (inDegree.size() != originalArray.length) {
            return false;
        }

        //find all sources i.e , all vertices with 0 in-degree
        List<Integer> sources = new ArrayList<>();

        for (Map.Entry<Integer, Integer> entry : inDegree.entrySet()) {
            if (entry.getValue() == 0) {
                sources.add(entry.getKey());
            }
        }
        System.out.println("sources = " + sources);

        /***
         * for each source , add it to the sortedOrder and subtract one from
         * all in-degrees.
         * if a childs in-degree become 0 then add it to sources queue.
         */

        while (!sources.isEmpty()) {
            // If there are more than one source
            if (sources.size() > 1) {
                // Multiple sequences exist
                return false;
            }

            //if the next source is different from the origin

            if (originalArray[sortedOrder.size()] != sources.get(0)) {
                return false;
            }

            int vertex = sources.get(0);
            sources.remove(0);
            sortedOrder.add(vertex);
            List<Integer> children = graph.get(vertex);

            for (int child : children) {
                //decrement the nodes in-degrees
                inDegree.put(child, inDegree.get(child) - 1);
                if (inDegree.get(child) == 0) {
                    sources.add(child);
                }
            }
        }

        return sortedOrder.size() == originalArray.length;

    }

    public static void main(String[] args) {

        System.out.println("Srikanth is preparing the Google Interview");
        int[] arr = { 1, 2, 6, 7, 3, 5, 4 };
        int[][] seqs = { { 1, 2, 3 },
                { 7, 3, 5 },
                { 1, 6, 3, 4 },
                { 2, 6, 5, 4 } };

       /* int [] arr = {1,3, 9, 5};
        int [][]seqs = {
                {1, 9, 5},
                {1, 3, 9}

        };*/

        /*int[] arr = {1, 2};
        int[][] seqs = {
                {1},
                {2}
        };*/
        boolean result = canReConstruct(arr, seqs);
        if (result)
            System.out.println("Yes");
        else
            System.out.println("No");
    }
}
