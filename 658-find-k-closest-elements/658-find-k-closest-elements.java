class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>((a, b) -> Math.abs(a-x) == Math.abs(b-x) ? b - a : Math.abs(b-x)-Math.abs(a-x));
        for (int num : arr) {
            if (pq.size() < k) {
                pq.add(num);
            }
            else {
                pq.add(num);
                pq.poll();
            }
        }
        List<Integer> answer = new ArrayList(pq);
        Collections.sort(answer);
        return answer;
    }
}