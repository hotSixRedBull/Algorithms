/**
 * Definition for a binary tree node.
 * function TreeNode(val, left, right) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.left = (left===undefined ? null : left)
 *     this.right = (right===undefined ? null : right)
 * }
 */
/**
 * @param {TreeNode} p
 * @param {TreeNode} q
 * @return {boolean}
 */
var isSameTree = function(p, q) {
    let pCur = p;
    let qCur = q;
    let pStk = [p];
    let qStk = [q];
    while (pStk.length > 0) {
        pCur = pStk.pop();
        qCur = qStk.pop();
        if (pCur == null && qCur == null) {
            return true;
        }
        if (pCur != null && qCur == null
           || pCur == null && qCur != null
           || pCur.val != qCur.val
           || (pCur.left != undefined && qCur.left == null)
           || (pCur.left == undefined && qCur.left != null)
           || (pCur.right != undefined && qCur.right == null)
           || (pCur.right == undefined && qCur.right != null)) {
            return false;
        }
        if (pCur.left != null && qCur.left != null) {
            pStk.push(pCur.left);
            qStk.push(qCur.left);
        }
        if (pCur.right != null && qCur.right != null) {
            pStk.push(pCur.right);
            qStk.push(qCur.right);
        }
    }
    return true;
};