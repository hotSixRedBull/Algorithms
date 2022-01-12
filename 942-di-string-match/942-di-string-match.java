class Solution {
    public int[] diStringMatch(String s) {
        //greedy
        int pos = 0;
        int index = 0;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        HashMap<Integer, List<Integer>> hashMap = new HashMap<>();
        List<Integer> first = new ArrayList<>();
        first.add(index++);
        hashMap.put(0, first);
        min = Math.min(min, 0);
        max = Math.max(max, 0);
        for (char c : s.toCharArray()) {
            if (c == 'D') {
                pos--;
            }
            else {
                pos++;
            }
            min = Math.min(min, pos);
            max = Math.max(max, pos);
            List<Integer> list = hashMap.getOrDefault(pos, new ArrayList<>());
            list.add(index);
            hashMap.put(pos, list);
            index++;
        }
        
        int[] ans = new int[s.length()+1];
        int cur = 0;
        for (int i=min; i<=max; i++) {
            List<Integer> indexList = hashMap.get(i);
            for (int ind : indexList) {
                ans[ind] = cur++;
            }
        }
        
        return ans;
    }
}

/*
"DDIIDIDIID"
-1 -2 -1 0 -1 0 -1 0 1 0 -1
0 -1 -2 

-2 -1 -1 -1 -1 -1 0 0 0 0 1
10  9  8  7  6 5 4 3 2 1  0
*/