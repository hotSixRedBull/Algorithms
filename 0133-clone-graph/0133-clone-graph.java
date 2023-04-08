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
        HashMap<Node, Node> map = new HashMap();
        Queue<Node> q = new ArrayDeque();
        Set<Node> visit = new HashSet();
        q.add(node);
        visit.add(node);
        while (q.size() > 0) {
            Node cur = q.poll();
            Node clone = map.containsKey(cur) ? map.get(cur) : new Node(cur.val);
            map.put(cur, clone);
            for (Node nei : cur.neighbors) {
                if (!map.containsKey(nei)) {
                    Node cloneNei = new Node(nei.val);
                    map.put(nei, cloneNei);
                }
                clone.neighbors.add(map.get(nei));    
                if (!visit.contains(nei)) {
                    visit.add(nei);
                    q.add(nei);
                }
            }
        }
        return map.get(node);
    }
}