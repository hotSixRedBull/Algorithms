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
    List<Node> li;
    public Node inorderSuccessor(Node node) {
        li = new ArrayList();
        Node parent = node;
        while (parent.parent != null) {
            parent = parent.parent;
        }
        inOrderTraversal(parent);
        // System.out.println(li);
        int lo=0;
        int hi=li.size();
        while (lo <= hi) {
            int mid = lo - (lo - hi)/2;
            if (li.get(mid).val == node.val) {
                if (mid + 1 < li.size()) {
                    return li.get(mid+1);
                }
                else {
                    return null;
                }
            }
            else if(li.get(mid).val < node.val) {
                lo = mid+1;
            }
            else {
                hi = mid-1;
            }
        }
        return null;
    }
    public void inOrderTraversal(Node node) {
        if (node == null) {
            return;
        }
        // System.out.println(node.val);
        inOrderTraversal(node.left);
        li.add(node);
        inOrderTraversal(node.right);
    }
}