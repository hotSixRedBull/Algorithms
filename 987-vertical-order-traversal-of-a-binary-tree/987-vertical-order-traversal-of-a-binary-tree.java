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
    TreeMap<Integer, List<Integer>> map;
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        map = new TreeMap();
        PriorityQueue<Node> q = new PriorityQueue(new Comparator<Node>(){
            @Override
            public int compare(Node a, Node b) {
                if (a.vPos == b.vPos) {
                    return a.node.val - b.node.val;
                }
                return a.vPos-b.vPos;
            }
        });
        q.add(new Node(0, 0, root));
        while (q.size() > 0) {
            Node cur = q.poll();
            if (map.containsKey(cur.hPos) == false) {
                map.put(cur.hPos, new ArrayList());
            }
            map.get(cur.hPos).add(cur.node.val);
            if (cur.node.left != null) {
                q.add(new Node(cur.hPos-1, cur.vPos+1, cur.node.left));
            }
            if (cur.node.right != null) {
                q.add(new Node(cur.hPos+1, cur.vPos+1, cur.node.right));
            }
        }
        List<List<Integer>> answer = new ArrayList();
        for (List<Integer> eachList : map.values()) {
            answer.add(eachList);
        }
        return answer;
    }
}

class Node {
    public int hPos;
    public int vPos;
    public TreeNode node;
    Node(int hp, int vp, TreeNode n) {
        hPos = hp;
        vPos = vp;
        node = n;
    }
}

/*
[3,1,4,0,2,2]
*/