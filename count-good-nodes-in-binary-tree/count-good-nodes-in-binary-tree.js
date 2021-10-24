/**
 * Definition for a binary tree node.
 * function TreeNode(val, left, right) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.left = (left===undefined ? null : left)
 *     this.right = (right===undefined ? null : right)
 * }
 */
/**
 * @param {TreeNode} root
 * @return {number}
 */
var goodNodes = function(root) {
    function getGoodNodesRecursive(cur, maxOnPath) {
        let res = 0;
        let max = maxOnPath;
        if (max == null) {
            max = cur.val;
        }
        if (cur.val >= maxOnPath) {
            res++;
            max = cur.val;
        }
        if (cur.left != null) {
            res += getGoodNodesRecursive(cur.left, max);
        }
        if (cur.right != null) {
            res += getGoodNodesRecursive(cur.right, max);
        }
        return res;
    }
    return getGoodNodesRecursive(root, root.val);
};