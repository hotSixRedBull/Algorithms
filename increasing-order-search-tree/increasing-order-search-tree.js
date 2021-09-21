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
 * @return {TreeNode}
 */
var increasingBST = function(root) {
    let q = new TreeNode(0,null,null)
    let tail = q
    function readInOrder(node) {
        if (node.left != null) {
            readInOrder(node.left)
        }
        node.left = null
        tail.right = node
        tail = tail.right
        if (node.right != null) {
            readInOrder(node.right)
        }
    }
    readInOrder(root)
    return q.right
};