/*
// Definition for a QuadTree node.
class Node {
    public boolean val;
    public boolean isLeaf;
    public Node topLeft;
    public Node topRight;
    public Node bottomLeft;
    public Node bottomRight;

    
    public Node() {
        this.val = false;
        this.isLeaf = false;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }
    
    public Node(boolean val, boolean isLeaf) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }
    
    public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = topLeft;
        this.topRight = topRight;
        this.bottomLeft = bottomLeft;
        this.bottomRight = bottomRight;
    }
};
*/

class Solution {
    public Node construct(int[][] grid) {
        return constructNode(grid, 0, grid.length-1, 0, grid[0].length);
    }
    public Node constructNode(int[][] grid,
                             int topR,
                             int bottomR,
                             int leftC,
                             int rightC) {
        if (topR == bottomR) {
            return new Node(grid[topR][leftC] == 1 ? true : false, true);
        }
        Node cur = new Node(true, false);
        int midUpperR = (bottomR+topR-1)/2;
        int midLeftC = (rightC+leftC-1)/2;
        cur.topLeft = constructNode(grid, topR, midUpperR, leftC, midLeftC);
        cur.topRight = constructNode(grid, topR, midUpperR, midLeftC+1, rightC);
        cur.bottomLeft = constructNode(grid, midUpperR+1, bottomR, leftC, midLeftC);
        cur.bottomRight = constructNode(grid, midUpperR+1, bottomR, midLeftC+1, rightC);
        if (cur.topLeft.isLeaf && cur.topRight.isLeaf
           && cur.bottomLeft.isLeaf && cur.bottomRight.isLeaf
           && cur.topLeft.val == cur.topRight.val
           && cur.topRight.val == cur.bottomLeft.val
           && cur.bottomLeft.val == cur.bottomRight.val) {
            cur = new Node(cur.topLeft.val, true);
        }
        return cur;
    }
}