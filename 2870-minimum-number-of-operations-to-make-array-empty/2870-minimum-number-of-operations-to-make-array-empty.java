class Solution {
    public int minOperations(int[] nums) {
        Map<Integer, Integer> cnt = new HashMap();
        for (int num : nums) {
            cnt.put(num, cnt.getOrDefault(num, 0)+1);
        }
        // System.out.println(cnt);
        
        int min = 0;
        for (int num : cnt.keySet()) {
            int eachCnt = cnt.get(num);
            // System.out.println(String.format("%d %% 3 == %d", eachCnt, eachCnt%3));
            if (eachCnt % 3 == 0) {
                min += eachCnt/3;
            }
            else if (eachCnt % 3 == 1) {
                if (eachCnt == 1) {
                    return -1;
                }
                // System.out.println(String.format("(int)Math.floor(%d/3) == %d", eachCnt, (int)Math.floor(eachCnt/3)));
                min += (int) Math.floor(eachCnt/3) + 1;
            }
            else {
                // System.out.println(String.format("(int)Math.floor(%d/3) == %d", eachCnt, (int)Math.floor(eachCnt/3)));
                min += (int)Math.floor(eachCnt/3)+1;
            }
        }
        return min;
    }
}