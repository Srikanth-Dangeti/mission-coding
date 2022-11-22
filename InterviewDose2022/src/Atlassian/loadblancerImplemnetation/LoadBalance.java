package Atlassian.loadblancerImplemnetation;

public interface LoadBalance {
    String getServer(String clientIp);
}
