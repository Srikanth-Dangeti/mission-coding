package Atlassian.loadblancerImplemnetation;

import java.util.*;

public class RoundRobinAlgo implements LoadBalance {

    private static Integer position = 0;

    @Override
    public String getServer(String clientIp) {
        Set<String> servers = IpAddressPool.ipMap.keySet();
        List<String> serverList = new ArrayList<>(servers);
        String target = null;
        synchronized (position) {
            if (position > serverList.size() - 1) {
                position = 0;
            }
            target = serverList.get(position);
            position++;
        }
        return target;
    }
}

