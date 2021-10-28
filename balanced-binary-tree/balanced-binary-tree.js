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
 * @return {boolean}
 */
var isBalanced = function(root) {
    function getHight(node) {
        if (node == null) return 0;
        let left = getHight(node.left);
        let right = getHight(node.right);
        return Math.max(left, right)+1;
    }
    function isValid(node) {
        if (node != null) {
            let leftValid = isValid(node.left);
            let rightValid = isValid(node.right);
            if (leftValid && rightValid) {
                let left = getHight(node.left);
                let right = getHight(node.right);
                return Math.abs(left-right) <= 1;
            }
            else {
                return false;
            }
        }
        else {
            return true;
        }
    }
    return isValid(root);
    
};