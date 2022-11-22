package Atlassian.ratelimiter.leakyBucket;

import java.util.HashMap;
import java.util.Map;

public class UserBucketCreator {
 // this class is not thread safe
    /***
     * Make the constructor private and create a factory method, which is thread safe.
     */
    Map<Integer, LeakyBucket> bucket;//TODO Make it private and if you are making it thread safe we have to make it concurrent hashmap
    public UserBucketCreator(int id)
    {
        bucket = new HashMap<>();
        bucket.put(id, new LeakyBucket(10));
    }
    void accessApplication(int id)
    {
        if(bucket.get(id).grantAccess())
        {
            System.out.println(Thread.currentThread().getName() +" ->Able to access the application");
        }
        else
        {
            System.out.println(Thread.currentThread().getName() +" ->Too many requests , Please try after sometime.");
        }
    }
}
