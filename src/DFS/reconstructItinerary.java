package DFS;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * Created by yangw on 2019/7/15.
 */
public class reconstructItinerary {
    Map<String, PriorityQueue<String>> flights = new HashMap();
    List<String> path = new LinkedList();
    // 利用贪心的思想，先把最近的arrival 加入，因为一定存在一条路，所以不用担心完不成
    public List<String> findItinerary(String[][] tickets) {
        for (String[] oneway: tickets) {
            flights.putIfAbsent(oneway[0], new PriorityQueue());
            flights.get(oneway[0]).add(oneway[1]);
        }
        dfs("JFK");
        return path;
    }
    public void dfs(String departure) {
        PriorityQueue<String> arrivals = flights.get(departure);
        while (arrivals != null && !arrivals.isEmpty()) dfs(arrivals.poll());
//        path.addFirst(departure);
    }
}
