class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((a,b) -> a[0]-b[0]);
        HashMap<Integer, Integer> map = new HashMap();
        int[] nextGreater = new int[nums2.length];
        Arrays.fill(nextGreater, -1);
        for (int i=0; i<nums2.length; i++) {
            int num2 = nums2[i];
            map.put(num2, i);
            while (pq.size() > 0
               && pq.peek()[0] < num2) {
                nextGreater[pq.poll()[1]] = num2;
            }
            pq.add(new int[]{num2, i});
        }
        
        int[] answer = new int[nums1.length];
        // Arrays.fill(answer, -1);
        for (int i=0; i<nums1.length; i++) {
            int num1 = nums1[i];
            answer[i] = nextGreater[map.get(num1)];
        }
        
        // System.out.println(Arrays.toString(nextGreater));
        return answer;
    }
}