package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 功能描述:
 * Clone an undirected graph. Each node in the graph contains a label and a list of its neighbors.
 * <p>
 * <p>
 * OJ's undirected graph serialization:
 * Nodes are labeled uniquely.
 * <p>
 * We use # as a separator for each node, and , as a separator for node label and each neighbor of the node.
 * As an example, consider the serialized graph {0,1,2#1,2#2,2}.
 * <p>
 * The graph has a total of three nodes, and therefore contains three parts as separated by #.
 * <p>
 * First node is labeled as 0. Connect node 0 to both nodes 1 and 2.
 * Second node is labeled as 1. Connect node 1 to node 2.
 * Third node is labeled as 2. Connect node 2 to node 2 (itself), thus forming a self-cycle.
 * Visually, the graph looks like the following:
 * <p>
 * 1
 * / \
 * /   \
 * 0 --- 2
 * / \
 * \_/
 *
 * @Author chen.yiran
 * @Date 16/12/15.
 */
public class Clone_Graph_133 {
    static class UndirectedGraphNode {
        int label;
        List<UndirectedGraphNode> neighbors;

        UndirectedGraphNode(int x) {
            label = x;
            neighbors = new ArrayList<UndirectedGraphNode>();
        }
    }

    Map<Integer, UndirectedGraphNode> map = new HashMap<>();

    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if(node==null) return null;
        UndirectedGraphNode root = new UndirectedGraphNode(node.label);
        map.put(root.label, root);

        if (node.neighbors.size() > 0) {
            for (int i = 0; i < node.neighbors.size(); i++) {
                UndirectedGraphNode n1 = node.neighbors.get(i);
                if(map.containsKey(n1.label)){
                    root.neighbors.add(map.get(n1.label));
                    continue;
                }
                else root.neighbors.add(cloneGraph(n1));
            }
        }
        return root;
    }

    public static void main(String[] args) {
        UndirectedGraphNode n1 = new UndirectedGraphNode(0);
        UndirectedGraphNode n3 = new UndirectedGraphNode(1);
        UndirectedGraphNode n4 = new UndirectedGraphNode(2);
        n1.neighbors.add(n3);
        n1.neighbors.add(n4);
        n3.neighbors.add(n4);
        n4.neighbors.add(n4);
        UndirectedGraphNode n2 = new Clone_Graph_133().cloneGraph(n1);
    }


}
