package Atlassian.ratelimiter;

public interface RateLimiter {
    boolean grantAccess();
}
