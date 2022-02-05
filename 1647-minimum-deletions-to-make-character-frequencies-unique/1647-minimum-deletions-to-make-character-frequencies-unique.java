class Solution {
    public int minDeletions(String s) {
        // System.out.println("start");
        HashMap<Character, Integer> freqMap = new HashMap();
        for (int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);
        }
        
        HashMap<Integer, Integer> freqCntMap = new HashMap();
        for (int i=0; i<s.length(); i++) {
            freqCntMap.put(i, 0);
        }
        
        for (char c : freqMap.keySet()) {
            freqCntMap.put(freqMap.get(c), freqCntMap.getOrDefault(freqMap.get(c), 0) + 1);
        }
        // System.out.println("freqCntMap: "+freqCntMap);
        
        int cnt = 0;
        for (int freq : freqCntMap.keySet()) {
            int curCnt = freqCntMap.get(freq);
            while (curCnt > 1) {
                // System.out.println(freq+" need change, curCnt: "+curCnt); 
                for (int i=freq-1; i>=0; i--) {
                    if (freqCntMap.get(i) == 0) {
                        cnt += freq-i;
                        if (i != 0) {
                            freqCntMap.put(i, 1);
                        }
                        break;
                    }
                }
                curCnt--;
                freqCntMap.put(freq, curCnt);
            }
        }
        
        return cnt;
    }
}

/* TC
"aab"
"aaabbbcc"
"ceabaacb"
"abcabc"
"bbcebab"
*/