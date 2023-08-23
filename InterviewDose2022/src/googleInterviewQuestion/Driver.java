package googleInterviewQuestion;

import java.util.*;
public class Driver {
    public static void main(String[] args) {

        Router r1 = new Router("A", 0, 0);
        Router r2 = new Router("B", 0, 9);
        Router r3 = new Router("C", 0, 19);
        Router r4 = new Router("D", 0, 20);

        List<Router>  routers = new ArrayList<>();
        routers.add(r1);
        routers.add(r2);
        routers.add(r3);
        routers.add(r4);

        System.out.println(new RouterManager(routers, 10).canReach("A", "D"));

    }
}
