package leetcode;

import java.util.*;

/**
 * 功能描述:
 * Given a list of airline tickets represented by pairs of departure and arrival airports [from, to], reconstruct the itinerary in order. All of the tickets belong to a man who departs from JFK. Thus, the itinerary must begin with JFK.
 * <p/>
 * Note:
 * If there are multiple valid itineraries, you should return the itinerary that has the smallest lexical order when read as a single string. For example, the itinerary ["JFK", "LGA"] has a smaller lexical order than ["JFK", "LGB"].
 * All airports are represented by three capital letters (IATA code).
 * You may assume all tickets form at least one valid itinerary.
 * Example 1:
 * tickets = [["MUC", "LHR"], ["JFK", "MUC"], ["SFO", "SJC"], ["LHR", "SFO"]]
 * Return ["JFK", "MUC", "LHR", "SFO", "SJC"].
 * Example 2:
 * tickets = [["JFK","SFO"],["JFK","ATL"],["SFO","ATL"],["ATL","JFK"],["ATL","SFO"]]
 * Return ["JFK","ATL","JFK","SFO","ATL","SFO"].
 * Another possible reconstruction is ["JFK","SFO","ATL","JFK","ATL","SFO"]. But it is larger in lexical order.
 *
 * @Author ewnit
 * @Date 16/12/4.
 */
public class Reconstruct_Itinerary_332 {

    /**
     * sort first then dfs?
     * <p/>
     * use Map and List
     * <p/>
     * 有权有向图 遍历边问题
     */

    class Flight {
        String place;
        boolean isVisited = false;

        public Flight(String place) {
            this.place = place;
        }
    }

    public List<String> findItineraryFail(String[][] tickets) {
        List<String> ans = new ArrayList<>();
        Map<String, List<Flight>> map = new HashMap<>();
        Set<String> set = new HashSet<String>();
        for (int i = 0; i < tickets.length; i++) {
            String key = tickets[i][0];
            String val = tickets[i][1];
            set.add(key);
            set.add(val);
            List<Flight> list;
            if (map.get(key) == null) list = new ArrayList<>();
            else list = map.get(key);

            list.add(new Flight(val));
            Collections.sort(list, new Comparator<Flight>() {
                @Override
                public int compare(Flight o1, Flight o2) {
                    String a = o1.place;
                    String b = o2.place;
                    for (int i = 0; i < a.length(); i++) {
                        if ((a.charAt(i) - 'A') != (b.charAt(i) - 'A')) {
                            if ((a.charAt(i) - 'A') < (b.charAt(i) - 'A')) {
                                return -1;
                            } else return 1;
                        }
                    }
                    return 1;
                }
            });
            map.put(key, list);
        }

        String cur = "JFK";
        ans = dfs(map, cur);
        Iterator<String> it = set.iterator();
        if (!ans.containsAll(set)) {
            while (it.hasNext()) {
                String str = it.next();
                if (!ans.contains(str)) {
                    ans.add(str);
                }
            }
        }
        return ans;
    }

    public List<String> dfs(Map<String, List<Flight>> map, String cur) {
        List<String> ans = new ArrayList<>();
        ans.add(cur);
        List<Flight> list = map.get(cur);
        if (list == null) return null;
        if (list.size() >= 1) {
            for (int i = 0; i < list.size(); i++) {
                Flight f = list.get(i);
                if (!f.isVisited) {
                    f.isVisited = true;
                    List<String> ne = dfs(map, f.place);
                    if (ne == null) {
                        f.isVisited = false;
                    } else ans.addAll(ne);
                }
            }

        }
        return ans;
    }

    /**
     * https://discuss.leetcode.com/topic/36383/share-my-solution/2
     */
    Map<String, PriorityQueue<String>> flights;
    LinkedList<String> path;

    public List<String> findItinerary(String[][] tickets) {
        flights = new HashMap<>();
        path = new LinkedList<>();
        for (String[] ticket : tickets) {
            flights.putIfAbsent(ticket[0], new PriorityQueue<>());
            flights.get(ticket[0]).add(ticket[1]);
        }
        dfs("JFK");
        return path;
    }

    public void dfs(String departure) {
        PriorityQueue<String> arrivals = flights.get(departure);
        while (arrivals != null && !arrivals.isEmpty())
            dfs(arrivals.poll());
        path.addFirst(departure);
    }

    public static void main(String[] args) {
//        String[][] tickets = {{"JFK", "SFO"}, {"JFK", "ATL"}, {"SFO", "ATL"}, {"ATL", "JFK"}, {"ATL", "SFO"}};
//        String[][] tickets = {{"JFK", "KUL"}, {"JFK", "NRT"}, {"NRT", "JFK"}};

//        String[][] tickets = {{"EZE", "TIA"}, {"EZE", "AXA"}, {"AUA", "EZE"}, {"EZE", "JFK"}, {"JFK", "ANU"}, {"JFK", "ANU"}
//                , {"AXA", "TIA"}, {"JFK", "AUA"}, {"TIA", "JFK"}, {"ANU", "EZE"}, {"ANU", "EZE"}, {"TIA", "AUA"}};

        String[][] tickets = {{"EZE", "TIA"}, {"EZE", "HBA"}, {"AXA", "TIA"}, {"JFK", "AXA"}, {"ANU", "JFK"}, {"ADL", "ANU"}, {"TIA", "AUA"},
                {"ANU", "AUA"}, {"ADL", "EZE"}, {"ADL", "EZE"}, {"EZE", "ADL"}, {"AXA", "EZE"}, {"AUA", "AXA"}, {"JFK", "AXA"}, {"AXA", "AUA"},
                {"AUA", "ADL"}, {"ANU", "EZE"}, {"TIA", "ADL"}, {"EZE", "ANU"}, {"AUA", "ANU"}};

        List<String> list = new Reconstruct_Itinerary_332().findItinerary(tickets);
        for (String s : list) {
            System.out.println(s);
        }
    }


}
