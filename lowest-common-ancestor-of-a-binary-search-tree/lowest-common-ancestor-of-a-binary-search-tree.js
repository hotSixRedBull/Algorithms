/**
 * Definition for a binary tree node.
 * function TreeNode(val) {
 *     this.val = val;
 *     this.left = this.right = null;
 * }
 */

/**
 * @param {TreeNode} root
 * @param {TreeNode} p
 * @param {TreeNode} q
 * @return {TreeNode}
 */
var lowestCommonAncestor = function(root, p, q) {
    function findAndBuildPath(node, target, depth, pathMap) {
        console.log(pathMap)
        if (node == null) return;
        if (node.val == target.val) {
            pathMap.set(depth, new TreeNode(node.val));
            return pathMap;
        }
        else if (node.val < target.val) {
            pathMap.set(depth, new TreeNode(node.val));
            return findAndBuildPath(node.right,target,depth+1,pathMap);
        }
        else {
            pathMap.set(depth, new TreeNode(node.val));
            return findAndBuildPath(node.left,target,depth+1,pathMap);
        }
        
    }
    let pPathObj = new Map();
    pPathObj = findAndBuildPath(root, p, 0, pPathObj);
    let qPathObj = new Map();
    qPathObj = findAndBuildPath(root, q, 0, qPathObj);
    //console.log(`pPath: ${pPathObj}\nqPath: ${qPathObj}`)
    //console.log(`pPathObj.size: ${pPathObj.size}\nqPathObj.size: ${qPathObj.size}`)
    for (let i=Math.min(pPathObj.size,qPathObj.size)-1; i>= 0; i--) {
        //console.log(`pPath.get(i).val: ${pPathObj.get(i).val}\nqPath.get(i).val: ${qPathObj.get(i).val}`)
        if (pPathObj.get(i).val == qPathObj.get(i).val) {
            return pPathObj.get(i);
        }
    }
};