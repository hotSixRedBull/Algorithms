class Solution {
    public int findLucky(int[] arr) {
        TreeSet<Integer> set = new TreeSet<>();
        HashMap<Integer, Integer> freqMap = new HashMap<>();
        for (int num : arr) {
            set.add(num);
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }
        
        
        for (int num : set.descendingSet()) {
            // System.out.println(num);
            if (freqMap.get(num) == num) {
                return num;
            }
        }
        
        return -1;
    }
}