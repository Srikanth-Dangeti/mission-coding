package Atlassian.loadblancerImplemnetation;

import java.util.*;
public class RandomAlgo implements LoadBalance{

    public String getServer(String clientIp) {

        Set<String> servers = IpAddressPool.ipMap.keySet();
        List<String> serverList = new ArrayList<String>(servers);

        int randomIndex = new Random().nextInt(serverList.size());

        String target = serverList.get(randomIndex);

        return target;
    }
}
