/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }
        
        Map<Node, Node> nodeMap = new HashMap();
        Queue<Node> q = new ArrayDeque();
        q.add(node);
        while (q.size() > 0) {
            Node cur = q.poll();
            Node copy = null;
            if (nodeMap.containsKey(cur)) {
                copy = nodeMap.get(cur);
            }
            else {
                copy = new Node(cur.val);
                nodeMap.put(node, copy);
            }
            
            for (Node nei : cur.neighbors) {
                if (!nodeMap.containsKey(nei)) {
                    q.add(nei);
                    Node newNode = new Node(nei.val);
                    nodeMap.put(nei, newNode);
                }
                copy.neighbors.add(nodeMap.get(nei));
            }
        }
        
        return nodeMap.get(node);
    }
}