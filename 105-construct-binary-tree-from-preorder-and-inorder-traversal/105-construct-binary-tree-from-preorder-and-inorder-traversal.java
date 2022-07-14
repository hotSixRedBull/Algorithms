// saw solution
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int preorderIndex;
    Map<Integer, Integer> inorderIndexMap;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        preorderIndex = 0;
        // build a hashmap to store value -> its index relations
        inorderIndexMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inorderIndexMap.put(inorder[i], i);
        }

        return arrayToTree(preorder, 0, preorder.length - 1);
    }

    private TreeNode arrayToTree(int[] preorder, int left, int right) {
        // if there are no elements to construct the tree
        if (left > right) return null;

        // select the preorder_index element as the root and increment it
        int rootValue = preorder[preorderIndex++];
        TreeNode root = new TreeNode(rootValue);

        // build left and right subtree
        // excluding inorderIndexMap[rootValue] element because it's the root
        root.left = arrayToTree(preorder, left, inorderIndexMap.get(rootValue) - 1);
        root.right = arrayToTree(preorder, inorderIndexMap.get(rootValue) + 1, right);
        return root;
    }
}
/*
class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer, Integer> inorderIndexMap = new HashMap();
        HashMap<Integer, TreeNode> nodeMap = new HashMap();
        for (int i=0; i<inorder.length; i++) {
            inorderIndexMap.put(inorder[i], i);
            nodeMap.put(inorder[i], new TreeNode(inorder[i]));
        }
        TreeNode root = nodeMap.get(preorder[0]);
        int prevIndex = inorderIndexMap.get(preorder[0]);
        int prevPrevIndex = -1;
        for (int i=1; i<preorder.length; i++) {
            int curIndex = inorderIndexMap.get(preorder[i]);
            TreeNode newNode = nodeMap.get(preorder[i]);
            if (curIndex < prevIndex) {
                TreeNode parent = nodeMap.get(inorder[prevIndex]);
                parent.left = newNode;
            }
            else {
                TreeNode parent = null;
                if (prevPrevIndex == -1
                   && nodeMap.get(inorder[prevIndex]).right == null) {
                    parent = nodeMap.get(inorder[prevIndex]);
                }
                else {
                    parent = nodeMap.get(inorder[prevPrevIndex]);
                }
                parent.right = newNode;
            }
            prevPrevIndex = prevIndex;
            prevIndex = curIndex;
        }
        return root;
    }
}
*/
/*
[3,9,20,15,7]
[9,3,15,20,7]
[-1]
[-1]
[1,2]
[1,2]
[1,2]
[2,1]
[1,2,3]
[1,2,3]
[1,2,3]
[1,3,2]
[1,2,3]
[2,1,3]
*/