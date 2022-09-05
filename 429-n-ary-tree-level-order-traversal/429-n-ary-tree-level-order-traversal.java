/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> levels = new ArrayList();
        if (root == null) {
            return levels;
        }
        Queue<Node> q = new ArrayDeque();
        q.add(root);
        while (q.size() > 0) {
            List<Integer> level = new ArrayList();
            Queue<Node> nq = new ArrayDeque();
            while (q.size() > 0) {
                Node cur = q.poll();
                level.add(cur.val);
                for (Node child : cur.children) {
                    nq.add(child);
                }
            }
            levels.add(level);
            q = nq;
        }
        return levels;
    }
}