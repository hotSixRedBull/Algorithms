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
        q.add(root);
        q.add(new Node(-101));
        
        Node prev = null;
        while (q.size() > 0) {
            Node cur = q.poll();
            if (cur.val == -101) {
                if (prev != null) {
                    prev.next = null;
                }
                prev = null;
                if (q.size() != 0) {
                    q.add(new Node(-101));
                }
                continue;
            }
            if (prev != null) {
                prev.next = cur;
            }
            if (cur.left != null) {
                q.add(cur.left);
            }
            if (cur.right != null) {
                q.add(cur.right);
            }
            prev = cur;
        }
        return root;
    }
}