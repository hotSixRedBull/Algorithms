class Solution {
    public boolean isCovered(int[][] ranges, int left, int right) {
        Set<Integer> set = new HashSet();
        for (int i=left; i<=right; i++) {
            set.add(i);
        }
        
        for (int[] range : ranges) {
            for (int i=range[0]; i<=range[1]; i++) {
                if (set.contains(i)) {
                    set.remove(i);
                }
            }
        }
        
        return set.size() == 0;
    }
}