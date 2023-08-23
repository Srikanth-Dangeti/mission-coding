package googleInterviewQuestion;

import java.util.*;

public class RouterManager {
private List<Router> routers;
private double wirelessRange ;
private Map<String, List<String>> routerMap;
    RouterManager(List<Router> routers, double wirelessRange){
        this.routers = routers;
        this.wirelessRange = wirelessRange;
        this.routerMap = new HashMap<>();
    }
    Map<String, Boolean> visitedRoute =  new HashMap<>();
boolean canReach(String source,String dest){

        for(Router src: this.routers){
            visitedRoute.put(src.getName(),true);
            for(Router dst: this.routers){
                if(src.getName()!= dst.getName()){
                    double distance = calculateDistance(src,dst);
                    if(distance<=wirelessRange){
                        if(routerMap.containsKey(src.getName())){
                            routerMap.get(src.getName()).add(dst.getName());
                        }
                        else{
                            List<String> ex = new LinkedList<>();
                            ex.add(dst.getName());
                            routerMap.put(src.getName(),ex);
                        }
                    }
                }
            }
        }
    System.out.println(routerMap);
    Queue<String> queue = new LinkedList<>();
        queue.add(source);
        while(!queue.isEmpty()){
            System.out.println(queue);
            String x = queue.poll();

            if(visitedRoute.get(x)) {
                List<String> temp = new LinkedList<>(routerMap.get(x));
                for (String tmp : temp) {
                    if (tmp == dest) {
                        return true;
                    }
                    if (!queue.contains(tmp) && visitedRoute.get(tmp)) {
                        queue.add(tmp);
                    }
                }
                visitedRoute.put(x,false);
            }

        }




return false;
}

double calculateDistance(Router src , Router dest){
        return Math.sqrt((dest.getX()-src.getX())*(dest.getX()-src.getX())+(dest.getY()-src.getY())*(dest.getY()-src.getY()));
}
}
