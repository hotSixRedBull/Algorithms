// saw solution
class Solution {
    public boolean verifyPreorder(int[] preorder) {
        int[] i = {0};
        return helper(preorder, i, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    
    public boolean helper(int[] preorder, int[] i, int minLimit, int maxLimit) {
        if (i[0] == preorder.length) {
            return true;
        }
        
        int root = preorder[i[0]];
        if (root <= minLimit || root >= maxLimit) {
            return false;
        }
        
        i[0]++;
        boolean left = helper(preorder, i, minLimit, root);
        boolean right = helper(preorder, i, root, maxLimit);
        return left || right;
    }
}

/*
class Solution {
    public boolean verifyPreorder(int[] preorder) {
        return verify(preorder, 0, preorder.length);
    }
    public boolean verify(int[] p, int left, int right) {
        if (left > right) {
            return false;
        }
        if (left == right) {
            return true;
        }
        boolean result = true;
        int root = p[left];
        int bigger = -1;
        for (int i=left+1; i<right; i++) {
            if (p[i] > root) {
                if (i <= right) {
                    result = result && verify(p, i, right);
                }
                if (left+1 <= i-1) {
                    result = result && verify(p, left+1, i-1);
                }
                bigger = i;
                break;
            }
        }
        if (bigger == -1) {
            return true;
        }
        if (result == false) {
            return false;
        }
        for (int i=bigger+1; i<right; i++) {
            if (p[i] < p[left]) {
                return false;
            }
        }
        return result;
    }
}
*/