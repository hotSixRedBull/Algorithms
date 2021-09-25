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
 * @param {TreeNode} subRoot
 * @return {boolean}
 */
var isSubtree = function(root, subRoot) {
    function isSameNode(aNode, bNode) {
        if (!aNode && !bNode) {
            return true;
        }
        //console.log(`aNode: ${JSON.stringify(aNode)},\nbNode: ${JSON.stringify(bNode)}\n`)
        let res = true;
        if ((!!aNode && !bNode) 
            || (!!bNode && !aNode)
            || !(!!aNode && !!bNode && aNode.val == bNode.val)) {
            return false;
        }
        res &= isSameNode(aNode.left, bNode.left);
        res &= isSameNode(aNode.right, bNode.right);
        //console.log(`result: ${res}`)
        return res;
    }
    function searchRoot(node) {
        if (!node) {
            return false;
        }
        let res = false;
        if (node.val == subRoot.val && isSameNode(node, subRoot)) {
            return true;
        }
        if (!!node.left) {
            res |= searchRoot(node.left);
        }
        if (!!node.right) {
            res |= searchRoot(node.right);
        }
        return res;
    }
    return searchRoot(root);
};