class Solution {
    public int minimumRounds(int[] tasks) {
        HashMap<Integer, Integer> map = new HashMap();
        for (int task : tasks) {
            if (!map.containsKey(task)) {
                map.put(task, 0);
            }
            map.put(task, map.get(task) + 1);
        }
        
        int cnt = 0;
        for (int key : map.keySet()) {
            int cur = map.get(key);
            if (cur == 1) {
                return -1;
            }
            else {
                cnt += cur/3;
                if (cur % 3 != 0) {
                    cnt++;
                }
            }
            // System.out.println(String.format("key: %d, cnt: %d", key, cnt));
        }
        
        return cnt;
    }
}