class Solution {
    public int minMeetingRooms(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> {
           if (a[0] == b[0]) {
               return a[1]-b[1];
           } 
           return a[0]-b[0];
        });
        int cnt = 0;
        TreeMap<Integer, Integer> map = new TreeMap();
        for (int[] interval : intervals) {
            Integer smaller = map.floorKey(interval[0]);
            if (smaller == null) {
                cnt++;
            }
            else {
                if (map.get(smaller) == 1) {
                    map.remove(smaller);
                }
                else {
                    map.put(smaller, map.get(smaller)-1);
                }
            }
            map.put(interval[1], map.getOrDefault(interval[1], 0)+1);
        }
        return cnt;
    }
}