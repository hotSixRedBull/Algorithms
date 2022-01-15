class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Queue<List<Integer>> q = new ArrayDeque<>();
        Queue<Integer> sumQ = new ArrayDeque<>();
        Queue<Integer> indexQ = new ArrayDeque<>();
        for (int i=0; i<candidates.length; i++) {
            List<Integer> list = new ArrayList<>();
            if (candidates[i] <= target) {
                list.add(candidates[i]);
                q.add(list);
                sumQ.add(candidates[i]);
                indexQ.add(i);
            }
        }
        
        List<List<Integer>> ret = new ArrayList<>();
        while (q.size() > 0) {
            List<Integer> curList = q.poll();
            int curSum = sumQ.poll();
            int curIdx = indexQ.poll();
            if (curSum == target) {
                ret.add(curList);
                continue;
            }
            if (curSum > target) {
                continue;
            }
            
            for (int i=curIdx; i<candidates.length; i++) {
                if (curSum+candidates[i] <= target) {
                    List<Integer> list = new ArrayList<>(curList);
                    list.add(candidates[i]);
                    q.add(list);
                    sumQ.add(curSum+candidates[i]);
                    indexQ.add(i);
                }
            }
        }
        
        return ret;
    }
}