/**
 * Definition for Node.
 * public class Node {
 *     int val;
 *     Node left;
 *     Node right;
 *     Node random;
 *     Node() {}
 *     Node(int val) { this.val = val; }
 *     Node(int val, Node left, Node right, Node random) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *         this.random = random;
 *     }
 * }
 */

class Solution {
    public NodeCopy copyRandomBinaryTree(Node root) {
        if (root == null) {
            return null;
        }
        HashMap<Node, NodeCopy> map = new HashMap();
        map.put(root, new NodeCopy(root.val));
        Queue<Node> q = new ArrayDeque();
        q.add(root);
        while (q.size() > 0) {
            Node cur = q.poll();
            map.put(cur, new NodeCopy(cur.val));
            if (cur.left != null) {
                q.offer(cur.left);
            }
            if (cur.right != null) {
                q.offer(cur.right);
            }
        }
        q.add(root);
        while (q.size() > 0) {
            Node cur = q.poll();
            NodeCopy copyCur = map.get(cur);
            if (cur.left != null) {
                copyCur.left = map.get(cur.left);
                q.add(cur.left);
            }
            if (cur.right != null) {
                copyCur.right = map.get(cur.right);
                q.add(cur.right);
            }
            if (cur.random != null) {
                copyCur.random = map.get(cur.random);
            }
        }
        return map.get(root);
    }
}