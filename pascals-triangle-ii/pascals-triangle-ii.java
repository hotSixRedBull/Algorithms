class Solution {
    public List<Integer> getRow(int rowIndex) {
        ArrayList<List<Integer>> triangle = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        list.add(1);
        triangle.add(list);
        list = new ArrayList<>();
        list.add(1);
        list.add(1);
        triangle.add(list);
        if (rowIndex > 1) {
            for (int row = 2; row<=rowIndex; row++) {
                list = new ArrayList<>();
                list.add(1);
                List<Integer> parentList = triangle.get(row-1);
                for (int i=0; i<parentList.size()-1; i++) {
                    list.add(parentList.get(i)+parentList.get(i+1));
                }
                list.add(1);
                triangle.add(list);
            }
        }
        return triangle.get(rowIndex);
    }
}