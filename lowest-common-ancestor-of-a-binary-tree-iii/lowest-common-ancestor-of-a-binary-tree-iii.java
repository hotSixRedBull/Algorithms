/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node parent;
};
*/

class Solution {
    public Node lowestCommonAncestor(Node p, Node q) {
        HashMap<Node, Boolean> pMap = new HashMap<>();
        while (p != null && p.parent != null) {
            pMap.put(p, true);
            p = p.parent;
        }
        
        while (q != null && q.parent != null) {
            if (pMap.containsKey(q)) {
                return q;
            }
            q = q.parent;
        }
        return p;
    }
}