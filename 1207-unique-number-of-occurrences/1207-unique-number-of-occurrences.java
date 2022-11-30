class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        int[] cnt = new int[2001];
        Set<Integer> toCheck = new HashSet();
        for (int i=0; i<arr.length; i++) {
            cnt[arr[i]+1000]++;
            toCheck.add(arr[i]+1000);
        }
        Set<Integer> cntSet = new HashSet();
        for (int check : toCheck) {
            if (cntSet.contains(cnt[check])) {
                return false;
            }
            cntSet.add(cnt[check]);
        }
        return true;
    }
}