class Solution {
    public int countGoodSubstrings(String s) {
        if (s.length() < 3) {
            return 0;
        }
        HashMap<Character, Integer> cntMap = new HashMap();
        for (int i=0; i<3; i++) {
            cntMap.put(s.charAt(i), cntMap.getOrDefault(s.charAt(i), 0)+1);
        }
        int cnt = 0;
        if (isGood(cntMap)) {
            //System.out.println(String.format("%s is good!", s.substring(0, 3)));
            cnt++;
        }
        for (int i=3; i<s.length(); i++) {
            cntMap.put(s.charAt(i-3), cntMap.get(s.charAt(i-3))-1);
            cntMap.put(s.charAt(i), cntMap.getOrDefault(s.charAt(i), 0)+1);
            if (isGood(cntMap)) {
                //System.out.println(String.format("%s is good!", s.substring(i-3, i)));
                cnt++;
            }
        }
        return cnt;
    }
    
    public boolean isGood(HashMap<Character, Integer> map) {
        for (char key : map.keySet()) {
            if (map.get(key) > 1) {
                return false;
            }
        }
        return true;
    }
}