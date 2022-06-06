class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> answer = new ArrayList();
        answer.add(List.of(1));
         for (int i=1; i<numRows; i++) {
             List<Integer> newRow = new ArrayList();
             List<Integer> prev = answer.get(i-1);
             for (int j=0; j<=i; j++) {
                int left = j > 0 ? prev.get(j-1) : 0;
                int right = prev.size() > j ? prev.get(j) : 0;
                newRow.add(left+right);
             }
             answer.add(newRow);
         }
        return answer;
    }
}