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
    private List<Integer> ans;
    public List<Integer> preorder(Node root) {
        if (root == null) {
            return new ArrayList();
        }
        ans = new ArrayList();
        recursive(root);
        return ans;
    }
    
    public void recursive(Node node) {
        if (node == null) {
            return;
        }
        ans.add(node.val);
        if (
            node.children != null
            && node.children.size() != 0
           ) {
            for (int i=0; i<node.children.size(); i++) {
                recursive(node.children.get(i));
            }
        }
    }
}