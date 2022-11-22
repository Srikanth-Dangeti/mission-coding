package Atlassian.ratelimiter.leakyBucket;

import Atlassian.ratelimiter.RateLimiter;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/***
 * Using the blocking queue.Most important thing is
 * blocking queue is thread safe.
 */
public class LeakyBucket implements RateLimiter {

    private BlockingQueue<Integer> queue ;//make it private

    public LeakyBucket(int capacity)
    {
        this.queue = new LinkedBlockingQueue<>(capacity);
    }

    @Override
    public boolean grantAccess() {

        if(queue.remainingCapacity() > 0)
        {
            queue.add(1);
            return true;
        }

        return false;
    }
}
