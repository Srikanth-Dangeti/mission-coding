package dynamicProgramming;

import java.util.*;
class Solution {


    static class Item{
        String item;
        Double amount;

        Item(String item, Double amount){
            this.item = item;
            this.amount = amount;
        }

        @Override
        public String toString(){
            return this.item+ " : "+ this.amount;
        }
    }
    public  static  void backtrack(
            double remain,
            LinkedList<Item> comb,
            int start, Item[] candidates,
            List<List<Item>> results) {

        if (remain == 0) {
            // make a deep copy of the current combination
            results.add(new ArrayList<Item>(comb));
            return;
        } else if (remain < 0) {
            // exceed the scope, stop exploration.
            return;
        }

        for (int i = start; i < candidates.length; ++i) {
            // add the number into the combination
            comb.add(candidates[i]);
            System.out.println(candidates[i]);
            backtrack(remain - candidates[i].amount, comb, i, candidates, results);
            // backtrack, remove the number from the combination
            comb.removeLast();
        }
    }

    public static List<List<Item>> combinationSum(Item[] candidates, double target) {
        List<List<Item>> results = new ArrayList<List<Item>>();
        LinkedList<Item> comb = new LinkedList<Item>();

        backtrack(target, comb, 0, candidates, results);
        return results;
    }

    public static void main(String args[])
    {
        int arr[] = {1};
        double sum = 6.45;
        int n = arr.length;

        Item item1 = new Item("fruit",2.15);
        Item item2= new Item("chicken",2.0);
        Item item3 = new Item("chilli",3.0);
        Item item4 = new Item("onion",4.0);
        Item item5 = new Item("paneer",5.0);

        Item[] itemArr = new Item[5];
        itemArr[0] = item1;
//        itemArr[1] = item2;
//        itemArr[2] = item3;
//        itemArr[3] = item4;
//        itemArr[4] = item5;



        System.out.println(combinationSum( itemArr, sum));

    }
}