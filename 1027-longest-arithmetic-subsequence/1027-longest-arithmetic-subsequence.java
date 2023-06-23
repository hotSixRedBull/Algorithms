class Solution {
    public int longestArithSeqLength(int[] nums) {
        int n = nums.length;
        Map<Integer, TreeSet<Integer>> map = new HashMap();
        for (int i=0; i<n; i++) {
            int num = nums[i];
            map.putIfAbsent(num, new TreeSet());
            map.get(num).add(i);
        }
        
        int maxLen = 2;
        boolean[][] visited = new boolean[501][1001];
        for (int i=0; i<n; i++) {
// System.out.println("start: "+nums[i]+",");
            for (int j=i+1; j<n; j++) {
                int diff = nums[j]-nums[i];
                if (visited[nums[i]][diff+500]) {
                    continue;
                }
// System.out.print("  "+nums[j]+",");
                visited[nums[i]][diff+500] = true;
                int len = 2;
                int nextValue = nums[j]+diff;
                Integer nextIndex = map.getOrDefault(nextValue, new TreeSet<Integer>()).higher(j);
                while (nextIndex != null) {
// System.out.print(nextValue+",");
                    len++;
                    // visited[nextIndex] = true;
                    nextValue += diff;
                    nextIndex = map.getOrDefault(nextValue, new TreeSet<Integer>()).higher(nextIndex);
                }
                maxLen = Math.max(maxLen, len);
// System.out.println("len: "+len);
            }
        }
        return maxLen;
    }
}