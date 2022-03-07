/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    
    public Node() {
        children = new ArrayList<Node>();
    }
    
    public Node(int _val) {
        val = _val;
        children = new ArrayList<Node>();
    }
    
    public Node(int _val,ArrayList<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public Node cloneTree(Node root) {
        if (root == null) {
            return null;
        }
        Queue<Node> q = new ArrayDeque();
        Node sentinel = new Node(root.val);
        q.add(sentinel);
        Queue<Node> trackQ = new ArrayDeque();
        trackQ.add(root);
        
        while (trackQ.size() > 0) {
            Node ret = q.poll();
            ret.children = new ArrayList();
            Node track = trackQ.poll();
            for (Node node : track.children) {
                Node tmp = new Node(node.val);
                ret.children.add(tmp);
                q.add(tmp);
                trackQ.add(node);
            }
        }
        
        return sentinel;
    }
    
}