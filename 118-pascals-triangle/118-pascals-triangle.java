class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> li = new ArrayList();
        List<Integer> prev = new ArrayList();
        prev.add(1);
        li.add(prev);
        for (int i=1; i<numRows; i++) {
            List<Integer> newList = new ArrayList();
            newList.add(1);
            for (int j=0; j<prev.size()-1; j++) {
                int upperLeft = prev.get(j);
                int upperRight = j+1 < prev.size() ? prev.get(j+1) : 0;
                newList.add(upperLeft+upperRight);
            }
            newList.add(1);
            li.add(newList);
            prev = newList;
        }
        return li;
    }
}