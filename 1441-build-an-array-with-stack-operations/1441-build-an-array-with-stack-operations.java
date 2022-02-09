class Solution {
    public List<String> buildArray(int[] target, int n) {
        int targetIndex = 0;
        List<String> ans = new ArrayList();
        for (int i=1; i<=n && targetIndex < target.length; i++) {
            ans.add("Push");
            if (i == target[targetIndex]) {
                targetIndex++;
            }
            else {
                ans.add("Pop");
            }
        }
        return ans;
    }
}