/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *     // Constructor initializes an empty nested list.
 *     public NestedInteger();
 *
 *     // Constructor initializes a single integer.
 *     public NestedInteger(int value);
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // Set this NestedInteger to hold a single integer.
 *     public void setInteger(int value);
 *
 *     // Set this NestedInteger to hold a nested list and adds a nested integer to it.
 *     public void add(NestedInteger ni);
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return empty list if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
class Solution {
    public int depthSumInverse(List<NestedInteger> nestedList) {
        //find maxdepth
        int maxDepth = 0;
        Queue<List<NestedInteger>> q = new ArrayDeque<>();
        Queue<Integer> depthQ = new ArrayDeque<>();
        q.add(nestedList);
        depthQ.add(1);
        while (q.size() > 0) {
            List<NestedInteger> cur = q.poll();
            int depth = depthQ.poll();
            for (NestedInteger nested : cur) {
                if (nested.isInteger()) {
                    maxDepth = Math.max(maxDepth, depth);
                }
                else {
                    q.add(nested.getList());
                    depthQ.add(depth+1);
                }
            }
        }
        
        int sum = 0;
        q.clear();
        depthQ.clear();
        q.add(nestedList);
        depthQ.add(1);
        while (q.size() > 0) {
            List<NestedInteger> cur = q.poll();
            int depth = depthQ.poll();
            for (NestedInteger nested : cur) {
                if (nested.isInteger()) {
                    sum += nested.getInteger()*(maxDepth-depth+1);
                }
                else {
                    q.add(nested.getList());
                    depthQ.add(depth+1);
                }
            }
        }
        return sum;
    }
}