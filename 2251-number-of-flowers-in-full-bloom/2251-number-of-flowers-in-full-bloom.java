/*saw solution
class Solution {
    public int[] fullBloomFlowers(int[][] flowers, int[] people) {
        TreeMap<Integer,TreeMap<Integer, Integer>> map = new TreeMap();
        for (int[] flower : flowers) {
            int start = flower[0];
            int end = flower[1];
            map.putIfAbsent(start, new TreeMap());
            map.get(start).put(end, map.get(start).getOrDefault(end, 0)+1);
        }
        
        int n = people.length;
        int[] result = new int[n];
        for (int i=0; i<n; i++) {
            int p = people[i];
            Map<Integer,TreeMap<Integer, Integer>> smallerMap = map.headMap(p, false);
            for (int key : smallerMap.keySet()) {
                Map<Integer, Integer> biggerMap = smallerMap.get(key).tailMap(p, true);
                for (int val : biggerMap.values()) {
                    result[i] += val;
                }
            }
            if (map.containsKey(p)) {
                for (int val : map.get(p).values()) {
                    result[i] += val;
                }
            }
        }
        return result;
    }
}
*/
class Solution {
    public int[] fullBloomFlowers(int[][] flowers, int[] people) {
        int[] sortedPeople = Arrays.copyOf(people, people.length);
        Arrays.sort(sortedPeople);
        
        Arrays.sort(flowers, (a, b) -> Arrays.compare(a, b));
        Map<Integer, Integer> dic = new HashMap();
        PriorityQueue<Integer> heap = new PriorityQueue();
        
        int i = 0;
        for (int person : sortedPeople) {
            while (i < flowers.length && flowers[i][0] <= person) {
                heap.add(flowers[i][1]);
                i++;
            }
            
            while (!heap.isEmpty() && heap.peek() < person) {
                heap.remove();
            }
            
            dic.put(person, heap.size());
        }
        
        int[] ans = new int[people.length];
        for (int j = 0; j < people.length; j++) {
            ans[j] = dic.get(people[j]);
        }
        
        return ans;
    }
}