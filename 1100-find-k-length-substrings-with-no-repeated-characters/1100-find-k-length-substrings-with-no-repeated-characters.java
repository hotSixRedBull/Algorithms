class Solution {
    public int numKLenSubstrNoRepeats(String s, int k) {
        if (s.length() < k) {
            return 0;
        }
        int cnt = 0;
        HashMap<Character, Integer> freqMap = new HashMap();
        for (int i=0; i<k; i++) {
            freqMap.put(s.charAt(i), freqMap.getOrDefault(s.charAt(i), 0) + 1);
        }
        if (!hasRepeatedChar(freqMap)) {
            cnt++;
        }
        for (int i=k; i<s.length(); i++) {
            int stored = freqMap.getOrDefault(s.charAt(i-k), 1);
            if (stored == 1) {
                freqMap.remove(s.charAt(i-k));
            }
            else {
                freqMap.put(s.charAt(i-k), freqMap.getOrDefault(s.charAt(i-k), 0) - 1);
            }
            freqMap.put(s.charAt(i), freqMap.getOrDefault(s.charAt(i), 0) + 1);
            if (!hasRepeatedChar(freqMap)) {
                cnt++;
            }
        }
        return cnt;
    }
    
    public boolean hasRepeatedChar(HashMap<Character, Integer> map) {
        for (char key : map.keySet()) {
            if (map.get(key) > 1) {
                return true;
            }
        }
        return false;
    }
}