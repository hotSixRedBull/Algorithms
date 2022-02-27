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
    public int widthOfBinaryTree(TreeNode root) {
        Queue<TreeNode> q = new ArrayDeque();
        Queue<Integer> levelq = new ArrayDeque();
        Queue<String> pathq = new ArrayDeque();
        List<List<String>> minmax = new ArrayList();
        q.add(root);
        levelq.add(0);
        List<String> item = new ArrayList();
        item.add("S");
        item.add("S");
        pathq.add("S");
        minmax.add(item);
        while (q.size() > 0) {
            TreeNode cur = q.poll();
            int level = levelq.poll();
            String path = pathq.poll();
            // System.out.println(String.format("cur: %d", cur.val));
            
            if (minmax.size() <= level) {
                item = new ArrayList();
                item.add(path);
                item.add(path);
                minmax.add(item);
            }
            else {
                item = minmax.get(level);
                if (isbigger(item.get(0), path)) {
                    item.set(0, path);
                }
                if (!isbigger(item.get(1), path)) {
                    item.set(1, path);
                }
            }
            if (cur.left != null) {
                q.add(cur.left);
                levelq.add(level+1);
                pathq.add(path+"L");
            }
            if (cur.right != null) {
                q.add(cur.right);
                levelq.add(level+1);
                pathq.add(path+"R");
            }
        }
        // System.out.println("minmax: "+minmax);
        int ans = 0;
        for (List<String> elem : minmax) {
            ans = Math.max(ans, getDiff(elem.get(0), elem.get(1)));
        }
        return ans;
    }
    
    public boolean isbigger(String s, String t) {
        int i=0;
        while (i < s.length()
              && s.charAt(i) == t.charAt(i)) {
            i++;
        }
        for (; i<s.length(); i++) {
            if (s.charAt(i) == 'R'
                && t.charAt(i) == 'L') {
                return true;
            }
            if (s.charAt(i) == 'L'
               && t.charAt(i) == 'R') {
                return false;
            }
        }
        if (i >= s.length()) {
            return false;
        }
        return true;
    }
    /*
    LL
    RR
    4가 나와야 함
    L이면 0,
    R이면 +1하고 bit shift.
    */
    public int getDiff(String s, String t) {
        int i=0;
        while (i < s.length()
              && s.charAt(i) == t.charAt(i)) {
            i++;
        }
        int sPos = 0;
        int tPos = 0;
        for (; i<s.length(); i++) {
            sPos <<= 1;
            tPos <<= 1;
            if (s.charAt(i) == 'R') {
                sPos += 1;
            }
            if (t.charAt(i) == 'R') {
                tPos += 1; 
            }
        }
        // System.out.println(String.format("s: %s, t: %s, diff: %d",s,t,tPos-sPos+1));
        return tPos-sPos+1;
    }
}
/*
[2,1,4,3,null,5]
*/