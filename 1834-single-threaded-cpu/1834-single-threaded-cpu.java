class Solution {
    public int[] getOrder(int[][] tasks) {
        TreeMap<Integer, PriorityQueue<int[]>> map = new TreeMap();
        for (int i=0; i<tasks.length; i++) {
            if (map.containsKey(tasks[i][0]) == false) {
                map.put(tasks[i][0], new PriorityQueue<int[]>(
                        (a, b) -> a[0] == b[0] ? a[1]-b[1] : a[0]-b[0])
                       );
            }
            map.get(tasks[i][0]).offer(new int[]{tasks[i][1], i});   
        }
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((a, b) -> a[0] == b[0] ? a[1]-b[1] : a[0]-b[0]);
        int[] ans = new int[tasks.length];
        int ansIndex = 0;
        int currentTime = map.firstKey();
        for (int processStartTime : map.navigableKeySet()) {
            // System.out.println(String.format("processStartTime: %d", processStartTime));
            if (currentTime >= processStartTime) {
                pq.addAll(map.get(processStartTime));
            }
            else {
                while (pq.size() > 0
                        && currentTime < processStartTime) {
                    int[] top = pq.poll();
                    ans[ansIndex++] = top[1];
                    currentTime += top[0];
                }
                currentTime = Math.max(currentTime, processStartTime);
                pq.addAll(map.get(processStartTime));
            }
        }
        while (pq.size() > 0) {
            int[] top = pq.poll();
            ans[ansIndex++] = top[1];
        }
        return ans;
    }
}