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
 * @param {number} x
 * @param {number} y
 * @return {boolean}
 */
var isCousins = function(root, x, y) {
    let map = {};
    function buildMap(node, parentVal, depth) {
        map[node.val] = {
            parentVal,
            depth,
        };
        if (!!node.left) {
            buildMap(node.left, node.val, depth+1);
        }
        if (!!node.right) {
            buildMap(node.right, node.val, depth+1);
        }
    }
    buildMap(root, null, 0);
    return map[x].parentVal !== map[y].parentVal && map[x].depth == map[y].depth;
};