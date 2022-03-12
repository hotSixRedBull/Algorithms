/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        HashMap<Node, Node> map = new HashMap();
        Node cur = head;
        while (cur != null) {
            map.put(cur, new Node(cur.val));
            cur = cur.next;
        }
        cur = head;
        while (cur != null) {
            if (cur.random != null) {
                map.get(cur).random = map.get(cur.random);
            }
            if (cur.next != null) {
                map.get(cur).next = map.get(cur.next);
            }
            cur = cur.next;
        }
        
        return map.get(head);
    }
}