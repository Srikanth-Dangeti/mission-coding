package Atlassian;

import java.util.HashMap;

/***
 * voting problem
 * 1 person can vote 3 votes
 * Condition : 1st persons vote have more points > 2nd > 3rd
 * output : - list of candidtates in the descending order votes
 *
 *
 * let say the persons are A , B , C
 * Now input  no of voters = 5
 * votes can be : listofvotes ABC, BAC, ACB, ABC, BAC (Input)
 *
 *  weightage : 1 st : 3 , 2nd : 2 , 3rd : 1
 *
 *      1 2 3
 *   A  3 2 0
 *   B  2 2 1
 *   C  0 1 4
 *
 *   so now,
 *
 *
 */
import java.util.*;
public class Test {

    public static class Candidate{
        String candidateName;
        Integer numberOfVotes;

        Candidate(String candidateName, Integer numberOfVotes)
        {
            this.candidateName = candidateName;
            this.numberOfVotes = 0;
        }
    }

    public static void main(String[] args) {

        addCandidate(new Candidate("a", 0));
                addCandidate(new Candidate("b", 0));
                addCandidate(new Candidate("c", 0));

                String votes [] = {"123", "321", "213"};

                rankingCandidates(votes, 3);


    }
    private static int candidateCount = 0;
    private static Map<Integer,Candidate> candidateList = new HashMap<>();
    private static Map<Integer,Integer> rankMap  = new HashMap<>(); //
    public static void rankingCandidates(String[] votes, int numberOfCandidates){
        int numberOfVotes = votes[0].length();

        int[] voteMap2DArray = new int[numberOfCandidates];

        int[][] voteMap = new int[numberOfCandidates][numberOfVotes+1];
        System.out.println(candidateList.get(0).candidateName);


        for(int i =0;i<votes.length;i++){
            String s = votes[i];
            for(int j = 0;j<numberOfVotes;j++){
                //voteMap2DArray[Integer.parseInt(s.charAt(j)+"")] = voteMap2DArray[Integer.parseInt(s.charAt(j)+"")]+rankMap.get(j);
                System.out.println(s.charAt(j));
                candidateList.get(Integer.parseInt(s.charAt(j)+"")).numberOfVotes+= rankMap.get(j);
            }
        }

        //Sorting here
        List<Map.Entry<Integer,Candidate>>  newList = new ArrayList<>(candidateList.entrySet());
        Collections.sort(newList,(a,b)-> b.getValue().numberOfVotes- a.getValue().numberOfVotes);

        LinkedHashMap<Integer,Candidate> sortedCandidateList = new LinkedHashMap<>();

        for(Map.Entry<Integer,Candidate> entry: newList){
            sortedCandidateList.put(entry.getKey(),entry.getValue());
        }


        for(Map.Entry<Integer,Candidate> entry: sortedCandidateList.entrySet()){
            System.out.println(entry.getValue().candidateName);
        }

        //System.out.println(sortedCandidateList);
        System.out.println("Checking this code");

    }

    public static void addCandidate(Candidate candidate){
        candidateCount++;
        candidateList.put(candidateCount,candidate);
    }
}
