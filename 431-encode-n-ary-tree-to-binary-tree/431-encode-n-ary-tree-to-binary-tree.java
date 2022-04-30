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

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Codec {
    // Encodes an n-ary tree to a binary tree.
    public TreeNode encode(Node root) {
        // System.out.println(">>> encode");
        if (root == null) {
            return null;
        }
        Queue<Node> inputq = new ArrayDeque();
        Queue<TreeNode> outputq = new ArrayDeque();
        inputq.add(root);
        TreeNode encoded = new TreeNode(-1);
        outputq.add(encoded);
        
        while (inputq.size() > 0) {
            Node inputcur = inputq.poll();
            TreeNode outputcur = outputq.poll();
            // printNode(inputcur, "inputcur");
            if (outputcur.left == null) {
                outputcur.left = new TreeNode(inputcur.val);
            }
            outputcur.right = new TreeNode(inputcur.children.size());
            TreeNode childNode = outputcur.right;
            for (Node child : inputcur.children) {
                childNode.left = new TreeNode(child.val);
                inputq.add(child);
                outputq.add(childNode);
                childNode = childNode.left;
            }
            // printTreeNode(outputcur, "outputcur");
        }
        
        return encoded;
    }
	
    // Decodes your binary tree to an n-ary tree.
    public Node decode(TreeNode root) {
        // System.out.println(">>> decode");
        if (root == null) {
            return null;
        }
        Queue<TreeNode> inputq = new ArrayDeque();
        Queue<Node> outputq = new ArrayDeque();
        inputq.add(root);
        Node decoded = new Node(-1);
        outputq.add(decoded);
        
        while (inputq.size() > 0) {
            TreeNode inputcur = inputq.poll();
            Node outputcur = outputq.poll();
            outputcur.children = new ArrayList();
            if (inputcur.left != null) {
                outputcur.val = inputcur.left.val;
            }
            // printTreeNode(inputcur, "inputcur");
            if (inputcur.right != null
               && inputcur.right.val != 0) {
                TreeNode child = inputcur.right;
                for (int i=0; i<inputcur.right.val; i++) {
                    // printTreeNode(child, "child");
                    inputq.add(child);
                    Node childOutput = new Node(child.val);
                    outputcur.children.add(childOutput);
                    outputq.add(childOutput);
                    child = child.left;
                }
            }
            // printNode(outputcur, "outputcur");
        }
        
        return decoded;
    }
    
    void printNode(Node node, String name) {
        if (node == null) {
            System.out.println(String.format("%s: null",name));
        }
        else {
            System.out.print(String.format("%s: %d",name, node.val));
            if (node.children != null) {
                System.out.print(" children: [ ");
                for (Node child : node.children) {
                    System.out.print(child.val+" ");
                }
                System.out.print("]");
            }
            else {
                System.out.print(" children: [ ]");
            }
            System.out.println("");
        }
    }
    
    void printTreeNode(TreeNode node, String name) {
        if (node == null) {
            System.out.println(String.format("%s: null",name));
        }
        else {
            System.out.print(String.format("%s: %d",name, node.val));
            if (node.left != null) {
                System.out.print(String.format(" %s.left: %d",name, node.left.val));
            }
            else {
                System.out.print(String.format(" %s.left: null",name));
            }
            if (node.right != null) {
                System.out.print(String.format(" %s.right: %d",name, node.right.val));
            }
            else {
                System.out.print(String.format(" %s.right: null",name));
            }
            System.out.println("");
        }
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(root));