/**
 * Definition for polynomial singly-linked list.
 * class PolyNode {
 *     int coefficient, power;
 *     PolyNode next = null;
 
 *     PolyNode() {}
 *     PolyNode(int x, int y) { this.coefficient = x; this.power = y; }
 *     PolyNode(int x, int y, PolyNode next) { this.coefficient = x; this.power = y; this.next = next; }
 * }
 */

class Solution {
    public PolyNode addPoly(PolyNode poly1, PolyNode poly2) {
        PolyNode sentinel = new PolyNode(0, 0);
        PolyNode cur = sentinel;
        PolyNode p1 = poly1;
        PolyNode p2 = poly2;
        while (p1 != null && p2 != null) {
            if (p1.power > p2.power) {
                cur.next = new PolyNode(p1.coefficient, p1.power);
                cur = cur.next;
                p1 = p1.next;
            }
            else if (p1.power < p2.power) {
                cur.next = new PolyNode(p2.coefficient, p2.power);
                cur = cur.next;
                p2 = p2.next;
            }
            else {
                int sum = p1.coefficient+p2.coefficient;
                if (sum != 0) {
                    cur.next = new PolyNode(sum, p1.power);
                    cur =cur.next;
                }
                p1 = p1.next;
                p2 = p2.next;
            }
        }
        while (p1 != null) {
            cur.next = new PolyNode(p1.coefficient, p1.power);
            cur = cur.next;
            p1 = p1.next;
        }
        while (p2 != null) {
            cur.next = new PolyNode(p2.coefficient, p2.power);
            cur = cur.next;
            p2 = p2.next;
        }
        return sentinel.next;
    }
}