/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    Map<TreeNode, Boolean> pMap;
    Map<TreeNode, Boolean> qMap;
    TreeNode p;
    TreeNode q;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        this.p = p;
        this.q = q;
        pMap = new HashMap();
        qMap = new HashMap();
        find(root, p, pMap);
        find(root, q, qMap);
        return recursive(root);
    }
    
    public boolean find(TreeNode cur, TreeNode p, Map<TreeNode, Boolean> map) {
        if (cur == null) {
            return false;
        }
        if (map.containsKey(cur)) {
            return map.get(cur);
        }
        if (cur == p) {
            map.put(cur, true);
            return true;
        }
        boolean found = false;
        if (cur.left != null) {
            found |= find(cur.left, p, map);
        }
        if (cur.right != null) {
            found |= find(cur.right, p, map);
        }
        map.put(cur, found);
        return found;
    }
    
    public TreeNode recursive(TreeNode cur) {
        if (cur == p) {
            if (cur.left != null) {
                if (qMap.getOrDefault(cur.left, false)) {
                    return cur;
                }
            }
            if (cur.right != null) {
                if (qMap.getOrDefault(cur.right, false)) {
                    return cur;
                }
            }
        }
        else if (cur == q) {
            if (cur.left != null) {
                if (pMap.getOrDefault(cur.left, false)) {
                    return cur;
                }
            }
            if (cur.right != null) {
                if (pMap.getOrDefault(cur.right, false)) {
                    return cur;
                }
            }
        }
        else {
            if (cur.left != null) {
                if (cur.right != null) {
                    if ((pMap.getOrDefault(cur.left, false) 
                         && qMap.getOrDefault(cur.right, false)) || 
                        (pMap.getOrDefault(cur.right, false) 
                         && qMap.getOrDefault(cur.left, false))) {
                        return cur;
                    }
                    if (pMap.getOrDefault(cur.right, false) 
                         && qMap.getOrDefault(cur.right, false)) {
                        return recursive(cur.right);
                    }
                }
                if (pMap.getOrDefault(cur.left, false) 
                     && qMap.getOrDefault(cur.left, false)) {
                    return recursive(cur.left);
                }
            }
            else if (cur.right != null) {
                if (pMap.getOrDefault(cur.right, false) 
                     && qMap.getOrDefault(cur.right, false)) {
                    return recursive(cur.right);
                }
            }
        }
        return null;
    }
}