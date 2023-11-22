class Solution {
    public int[] findDiagonalOrder(List<List<Integer>> nums) {
        Map<Integer, List<Integer>> groups = new HashMap();
        int n = 0;
        for (int row = nums.size() - 1; row >= 0; row--) {
            for (int col = 0; col < nums.get(row).size(); col++) {
                int diagonal = row + col;
                if (!groups.containsKey(diagonal)) {
                    groups.put(diagonal, new ArrayList<Integer>());
                }
                
                groups.get(diagonal).add(nums.get(row).get(col));
                n++;
            }
        }
        
        int[] ans = new int[n];
        int i = 0;
        int curr = 0;
        
        while (groups.containsKey(curr)) {
            for (int num : groups.get(curr)) {
                ans[i] = num;
                i++;
            }
            
            curr++;
        }
        
        return ans;
    }
}

//TLE..?
/*
class Solution {
    public int[] findDiagonalOrder(List<List<Integer>> nums) {
        int n = nums.size();
        int max = 0;
        int number_of_elements = 0;
        int[] sizes = new int[n];
        for (int i=0; i<n; i++) {
            sizes[i] = nums.get(i).size();
            number_of_elements += sizes[i];
            max = Math.max(max, i+sizes[i]);
        }
        
        int[] ans = new int[number_of_elements];
        int index = 0;
        for (int sum=0; sum<=max; sum++) {
            int row = Math.min(n-1, sum);
            int col = sum-row-1;
            for (;row>=0; row--) {
                col++;
                if (col >= sizes[row]) {
                    continue;
                }
                ans[index++] = nums.get(row).get(col);
            }
        }
        return ans;
    }
}
*/