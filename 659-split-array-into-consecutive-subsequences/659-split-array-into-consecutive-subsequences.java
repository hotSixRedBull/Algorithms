class Solution {
    public boolean isPossible(int[] nums) {
        // System.out.println("start");
        HashMap<Integer, PriorityQueue<Integer>> map = new HashMap();
        for (int num : nums) {
            if (map.containsKey(num-1) == false) {
                if (map.containsKey(num) == false) {
                    map.put(num, new PriorityQueue());
                }
                map.get(num).add(1);
            }
            else {
                PriorityQueue<Integer> smaller = map.get(num-1);
                int top = smaller.poll();
                if (smaller.size() == 0) {
                    map.remove(num-1);
                }
                if (map.containsKey(num) == false) {
                    PriorityQueue<Integer> pq = new PriorityQueue();
                    map.put(num, pq);
                }
                map.get(num).add(top+1);
            }
            // System.out.println(map);
        }
        
        for (int key : map.keySet()) {
            PriorityQueue<Integer> pq = map.get(key);
            for (int each : pq) {
                if (each < 3) {
                    return false;
                }
            }
        }
        return true;
    }
}

/*
1,2,3,3,4,5
{1:[1]}
{2:[2]}
{3:[3]}
{3:[1,3]}
{3:[3], 4:[2]}
{3:[3], 5:[3]}

1,2,3,3,4,4,5,5
{1:[1]}
{2:[2]}
{3:[3]}
{3:[1,3]}
{3:[3],4:[2]}
{4:[2,4]}
{4:[4], 5:[3]}
{5:[3,5]}

1,2,3,4,4,5
*/