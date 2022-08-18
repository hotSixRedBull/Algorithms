class Solution {
    public int minSetSize(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap();
        for (int num : arr) {
            map.put(num, map.getOrDefault(num, 0)+1);
        }
        
        int left = arr.length;
        PriorityQueue<int[]> pq = new PriorityQueue(new Comparator<int[]>() {
           @Override
            public int compare(int[] a, int[] b) {
                return b[1]-a[1];
            }
        });
        for (int key : map.keySet()) {
            pq.add(new int[]{key, map.get(key)});
        }
        int cnt = 0;
        while (left > arr.length/2) {
            int[] top = pq.poll();
            left -= top[1];
            cnt++;
        }
        return cnt;
    }
}