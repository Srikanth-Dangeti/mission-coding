package Atlassian.loadblancerImplemnetation;
import java.util.*;
public class WeightRoundRobinAlgo implements LoadBalance{
    private static Integer position = 0;

    @Override
    public String getServer(String clientIp) {
        Set<String> servers = IpAddressPool.ipMap.keySet();
        List<String> serverList = new ArrayList<>();

        Iterator<String> iterator = servers.iterator();
        while (iterator.hasNext()) {
            String serverItem = iterator.next();
            Integer weight = IpAddressPool.ipMap.get(serverItem);
            if (weight > 0) {
                for (int i = 0; i < weight; i++) {
                    serverList.add(serverItem);
                }
            }

        }

        synchronized (position) {
            if (position > serverList.size()) {
                position = 0;
            }

            String target = serverList.get(position);
            position++;
            return target;
        }
    }
}
