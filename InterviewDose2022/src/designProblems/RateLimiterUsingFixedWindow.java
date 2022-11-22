package designProblems;

import java.sql.SQLOutput;
import java.time.Duration;
import java.time.Instant;
import java.util.HashMap;
import java.util.Map;

public class RateLimiterUsingFixedWindow {

    private static final Duration WINDOW_SIZE = Duration.ofSeconds(5);
    private static long REQUEST_LIMIT = 1;

    private static final Map<Integer, User> userMap = new HashMap<>();

    boolean rateLimit(int userId)
    {
        //System.out.println("WINDOW_SIZE = "+ WINDOW_SIZE.toMillis());
        long currentWindowNum = Instant.now().toEpochMilli() / WINDOW_SIZE.toMillis();
        //System.out.println(currentWindowNum);
        User user = userMap.computeIfAbsent(userId, (k) -> new User(currentWindowNum));
        //System.out.println("request count: " +userMap.get(111).getRequestCount());
        //System.out.println("Request Window number: "+userMap.get(111).getWindowNum());

        if(currentWindowNum > user.getWindowNum())
        {
            user.reset(currentWindowNum);
        }

        if(user.getRequestCount() < REQUEST_LIMIT)
        {
            user.setRequestCount(user.getRequestCount()+1);
            return true;
        }

        return false;
    }

    public static void main(String[] args) {
       User user1 = new User(Duration.ofSeconds(5).toMillis());
        userMap.put(111, user1);

        RateLimiterUsingFixedWindow fixedWindow = new RateLimiterUsingFixedWindow();
        for (int i = 0; i < user1.getRequestCount() + 1; i++)
        {
            if(fixedWindow.rateLimit(111))
            {
                System.out.println("Rate limiter is still taking the requests");
            }
            else
            {
                System.out.println("For a fixed window time, No of requests crossed, so rate limiter is not taking any request in the window span");
            }
        }
    }
}
