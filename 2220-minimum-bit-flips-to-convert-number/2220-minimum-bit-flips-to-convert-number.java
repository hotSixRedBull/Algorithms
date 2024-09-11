class Solution {
    public int minBitFlips(int start, int goal) {
        String s = Integer.toBinaryString(start);
        String g = Integer.toBinaryString(goal);
        int cnt = 0;
        if (s.length() > g.length()) {
            for (int i=0; i<g.length(); i++) {
                if (s.charAt(s.length()-1-i) != g.charAt(g.length()-1-i)) {
                    cnt++;
                }
            }
            for (int i=0; i<s.length()-g.length(); i++) {
                if (s.charAt(i) == '1') {
                    cnt++;
                }
            }
            return cnt;
        }
        
        for (int i=0; i<s.length(); i++) {
            if (s.charAt(s.length()-1-i) != g.charAt(g.length()-1-i)) {
                cnt++;
            }
        }
        for (int i=0; i<g.length()-s.length(); i++) {
            if (g.charAt(i) == '1') {
                cnt++;
            }
        }
        return cnt;
    }
}