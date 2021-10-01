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
 * @return {number[]}
 */
var findMode = function(root) {
    let map = {};
    let max = Number.MIN_SAFE_INTEGER;
    function buildMap(node) {
        if (!map[node.val]) {
            map[node.val] = 0; 
        }
        map[node.val]++;
        if (map[node.val] > max) {
            max = map[node.val];
        }
        if (!!node.left) {
            buildMap(node.left);
        }
        if (!!node.right) {
            buildMap(node.right);
        }
    }
    if (!!root) {
        buildMap(root);
    }
    //console.log(map,max);
    let res = [];
    for (let key of Object.keys(map)) {
        if (map[key] == max) {
            res.push(key);
        }
    }
    return res;
};