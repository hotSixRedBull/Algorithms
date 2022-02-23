class Solution {
    public boolean containsPattern(int[] arr, int m, int k) {
        if (arr.length < m
           || arr.length < m*k) {
            return false;
        }
        StringBuilder sb = new StringBuilder();
        HashMap<String, Integer> map = new HashMap();
        for (int i=0; i<m; i++) {
            sb.append(arr[i]);
        }
        map.put(sb.toString(), 1);
        if (k == 1) {
            return true;
        }
        int end = Math.min(2*m, arr.length);
        StringBuilder prev = new StringBuilder();
        for (int i=m; i<end; i++) {
            sb.delete(0,1);
            sb.append(arr[i]);
            prev.append(arr[i-m]);
            String key = sb.toString();
            if (prev.toString().equals(key.toString())) {
                map.put(key, 2);
            }
            else {
                map.put(key, 1);
            }
            if (map.get(key) >= k) {
                return true;
            }
        }
        for (int i=m*2; i<arr.length; i++) {
            sb.delete(0,1);
            sb.append(arr[i]);
            prev.delete(0,1);
            prev.append(arr[i-m]);
            String key = sb.toString();
            if (prev.toString().equals(key.toString())) {
                map.put(key, map.getOrDefault(key, 0)+1);
            }
            else {
                map.put(key, 1);
            }
            if (map.get(key) >= k) {
                return true;
            }
        }
        return false;
    }
}