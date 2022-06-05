/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        if (root == null) {
            return null;
        }
        Queue<Node> q = new ArrayDeque();
        Queue<Node> nextQ = new ArrayDeque();
        q.add(root);
        while (q.size() > 0) {
            Node cur = q.poll();
            if (cur.left != null) {
                nextQ.add(cur.left);
            }
            if (cur.right != null) {
                nextQ.add(cur.right);
            }
            if (q.size() > 0) {
                cur.next = q.peek();
            }
            else {
                cur.next = null;
                q = nextQ;
                nextQ = new ArrayDeque();
            }
        }
        return root;
    }
}