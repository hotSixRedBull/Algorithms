/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return empty list if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
public class NestedIterator implements Iterator<Integer> {
    List<Integer> list;
    int index;
    
    public NestedIterator(List<NestedInteger> nestedList) {
        list = new ArrayList();
        index = 0;
        Stack<List<NestedInteger>> stk = new Stack();
        Stack<Integer> indexStk = new Stack();
        stk.add(nestedList);
        indexStk.add(index);
        while (stk.size() > 0) {
            List<NestedInteger> cur = stk.pop();
            int curIndex = indexStk.pop();
            if (cur.size() <= curIndex) {
                continue;
            }
            for (int i=curIndex; i<cur.size(); i++) {
                if (cur.get(i).isInteger() == false) {
                    stk.push(cur);
                    indexStk.push(i+1);
                    stk.push(cur.get(i).getList());
                    indexStk.push(0);
                    break;
                }
                else {
                    list.add(cur.get(i).getInteger());
                }
            }
        }
        // System.out.println(list);
    }

    @Override
    public Integer next() {
        return list.get(index++);
    }

    @Override
    public boolean hasNext() {
        return index < list.size();
    }
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */