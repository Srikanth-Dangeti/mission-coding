package designProblems;

/***
 * Token Bucket Algorithm for Rate-limiter
 * Java code for Rate-limiter Token Bucket
 * The token bucket algorithm is based on an analogy of a fixed capacity
 * bucket into which tokens are added at a fixed rate.
 * Before allowing an API to proceed, the bucket is inspected to see
 * if it contains at least 1 token at that time.
 * If so, one token is removed from the bucket,
 * the API is allowed to proceed. In case there are no tokens available,
 * the API is returned saying that the quota has exceeded during that window.
 */
public class RateLimiterUsingTokenBucket {

    private long capacity;
    private long windowTimeInSeconds;

    long lastRefillTimeStamp;

    long refillCountPerSecond;

    long availableTokens;

    public RateLimiterUsingTokenBucket(long capacity, long windowTimeInSeconds)
    {
        this.capacity = capacity;
        this.windowTimeInSeconds = windowTimeInSeconds;
        lastRefillTimeStamp = System.currentTimeMillis() - 10;
        refillCountPerSecond = capacity / windowTimeInSeconds;
        availableTokens = 0;
    }

    public long getAvailableTokens() {
        return this.availableTokens;
    }

    public boolean tryConsume()
    {
        refill();
        if(availableTokens > 0)
        {
            --availableTokens;
            return true;

        }
        else
        {
            return false;
        }
    }

    public void refill()
    {
        System.out.println(lastRefillTimeStamp);
        long now = System.currentTimeMillis();
        System.out.println(now);
        if(now > lastRefillTimeStamp)
        {
            long elapsedTime = now - lastRefillTimeStamp;
            //refill tokens for this durations
            long tokensToBeAdded = (elapsedTime/100) * refillCountPerSecond;

            if(tokensToBeAdded > 0)
            {
                availableTokens = Math.min(capacity, availableTokens + tokensToBeAdded);
                lastRefillTimeStamp = now;
            }
        }
    }

    public static void main(String[] args) {
        RateLimiterUsingTokenBucket tokenBucket = new RateLimiterUsingTokenBucket(20, 10);
        System.out.println(tokenBucket.tryConsume());
    }
}
