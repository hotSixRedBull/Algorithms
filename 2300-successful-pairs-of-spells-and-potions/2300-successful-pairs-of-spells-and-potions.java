class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        int n = spells.length;
        int m = potions.length;
        
        int[] result = new int[n];
        Arrays.sort(potions);
        for (int i=0; i<n; i++) {
            long spell = (long) spells[i];
            int lo = 0;
            int hi = m-1;
            while (lo < hi) {
                int mid = lo - (lo - hi)/2;
                if (spell*(long)potions[mid] < success) {
                    lo = mid+1;
                }
                else {
                    hi = mid;
                }
            }
            if (spell*(long)potions[lo] >= success) {
                result[i] = m-lo;
            }
        }
        
        return result;
    }
}

/*
sort potions
sort spells? no. spells are related with the order of the result
*/