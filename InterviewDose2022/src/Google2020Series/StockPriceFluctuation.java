package Google2020Series;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/***
 * https://leetcode.com/problems/stock-price-fluctuation/
 * Input
 * ["StockPrice", "update", "update", "current", "maximum", "update", "maximum", "update", "minimum"]
 * [[], [1, 10], [2, 5], [], [], [1, 3], [], [4, 2], []]
 * Output
 * [null, null, null, 5, 10, null, 5, null, 2]
 * StockPrice stockPrice = new StockPrice();
 * stockPrice.update(1, 10); // Timestamps are [1] with corresponding prices [10].
 * stockPrice.update(2, 5);  // Timestamps are [1,2] with corresponding prices [10,5].
 * stockPrice.current();     // return 5, the latest timestamp is 2 with the price being 5.
 * stockPrice.maximum();     // return 10, the maximum price is 10 at timestamp 1.
 * stockPrice.update(1, 3);  // The previous timestamp 1 had the wrong price, so it is updated to 3.
 *                           // Timestamps are [1,2] with corresponding prices [3,5].
 * stockPrice.maximum();     // return 5, the maximum price is 5 after the correction.
 * stockPrice.update(4, 2);  // Timestamps are [1,2,4] with corresponding prices [3,5,2].
 * stockPrice.minimum();     // return 2, the minimum price is 2 at timestamp 4.
 *
 * Time Complexity : O(NlogN)
 * Space Complexity: O(N)
 */
public class StockPriceFluctuation {

    int latestTime;

    //store the price of each stock at each timestamp
    Map<Integer, Integer> timeStampPriceMap;

    //store the price in the increasing order to get the minimum and maximum price
    TreeMap<Integer, Integer> priceFrequency;

    public StockPriceFluctuation() {
        latestTime = 0;
        timeStampPriceMap = new HashMap<>();
        priceFrequency = new TreeMap<>();
    }

    /***
     * Time complexity: O(NlogN)
     *
     * In the update function, we add and remove a record in both hashmap and sorted map.
     * In hashmap, both operations take constant time, but in the sorted map they take O(\log N)O(logN) time.
     * Each call to the maximum, minimum, or current function will take only constant time to return the result.
     *
     * But in Java, getting first or last element of tree map takes log(N) time. Thus, here maximum, minimum
     * functions will take O(log(N)) time for each function call.
     *
     * In the worst-case scenario, all NN calls will be to the update function, which will require a
     * total of O(N \log N)O(NlogN) time.
     *
     * Space complexity: O(N)O(N)
     *
     * In the update function, we add and remove a record in both the hashmap and sorted map.
     * Thus each function call takes O(1)O(1) space. So for NN update calls, it will take O(N)O(N) space.
     * @param timeStamp
     * @param price
     */
    public void update(int timeStamp, int price) {
        // Update the timeStamp to latest timeStamp
        latestTime = Math.max(latestTime, timeStamp);

        //If the timeStamp occurs again then previous price was wrong.
        if (timeStampPriceMap.containsKey(timeStamp)) {
            int oldPrice = timeStampPriceMap.get(timeStamp);

            priceFrequency.put(oldPrice, priceFrequency.get(oldPrice) - 1);
            //remove the entry from the map
            if (priceFrequency.get(oldPrice) == 0) {
                priceFrequency.remove(oldPrice);
            }
        }

        //Add the latest price for the timeStamp
        timeStampPriceMap.put(timeStamp, price);
        priceFrequency.put(price, priceFrequency.getOrDefault(price, 0) + 1);
    }

    /***
     * Time Complexity : O(1)
     * @return
     */
    public int current() {
        //return the latest price at latest time
        return timeStampPriceMap.get(latestTime);
    }

    /***
     * Time Complexity : O(1)
     * @return
     */
    public int minimum() {
        //return the minium price stored
        return priceFrequency.firstKey();
    }

    /***
     * Time Complexity : O(1)
     * @return
     */
    public int maximum() {
        return priceFrequency.lastKey();
    }

    public static void main(String[] args) {

        StockPriceFluctuation stockPrice = new StockPriceFluctuation();
        stockPrice.update(1, 10); // Timestamps are [1] with corresponding prices [10].
        stockPrice.update(2, 5);  // Timestamps are [1,2] with corresponding prices [10,5].
        System.out.println(stockPrice.current());     // return 5, the latest timestamp is 2 with the price being 5.
        System.out.println(stockPrice.maximum());    // return 10, the maximum price is 10 at timestamp 1.
        stockPrice.update(1, 3);  // The previous timestamp 1 had the wrong price, so it is updated to 3.
        // Timestamps are [1,2] with corresponding prices [3,5].
        System.out.println(stockPrice.maximum());     // return 5, the maximum price is 5 after the correction.
        stockPrice.update(4, 2);  // Timestamps are [1,2,4] with corresponding prices [3,5,2].
        System.out.println(stockPrice.minimum());     // return 2, the minimum price is 2 at timestamp 4.

    }
}
