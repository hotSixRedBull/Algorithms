class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> freq = new HashMap();
        for (int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }
        
        Stack<Integer> indexStk = new Stack();
        for (int key : freq.keySet()) {
            if (indexStk.size() == 0) {
                indexStk.push(key);
            }
            else if (freq.get(indexStk.peek()) < freq.get(key)) {
                Stack<Integer> tmp = new Stack();
                while (indexStk.size() > 0 
                       && freq.get(indexStk.peek()) < freq.get(key)) {
                    tmp.push(indexStk.pop());
                }
                indexStk.push(key);
                int threshold = 0;
                if (indexStk.size()+tmp.size() > k) {
                    threshold = 1;
                }
                while (tmp.size() > threshold) {
                    indexStk.push(tmp.pop());
                }
            }
            else if (indexStk.size() < k) {
                indexStk.push(key);
            }
            // System.out.println(indexStk);
        }
        
        int[] arr = new int[indexStk.size()];
        for (int i=indexStk.size()-1; i>=0; i--) {
            arr[i] = indexStk.pop();
        }
        return arr;
    }
}