class Solution {
    public boolean canBeEqual(int[] target, int[] arr) {
        int n = target.length;
        Map<Integer, Integer> tcnt = new HashMap();
        Map<Integer, Integer> acnt = new HashMap();
        for (int i=0; i<n; i++) {
            tcnt.put(target[i], tcnt.getOrDefault(target[i], 0)+1);
            acnt.put(arr[i], acnt.getOrDefault(arr[i], 0)+1);
        }
        if (acnt.keySet().size() != tcnt.keySet().size()) {
            return false;
        }
        for (int key : tcnt.keySet()) {
            if (acnt.containsKey(key) == false) {
                return false;
            }
            if (acnt.get(key) != tcnt.get(key)) {
                return false;
            }
        }
        return true;
    }
}