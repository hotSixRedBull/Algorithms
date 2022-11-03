class Solution {
    public int longestPalindrome(String[] words) {
        HashMap<String, Integer> freq = new HashMap();
        int isSameCharTwiceCnt = 0;
        for (String word : words) {
            freq.put(word, freq.getOrDefault(word, 0)+1);
        }
        
        int ans = 0;
        for (String key : freq.keySet()) {
            int keyVal = freq.get(key);
            if (key.charAt(0) == key.charAt(1)) {
                if (keyVal < 2) {
                    continue;
                }
                int min = keyVal/2;
                freq.put(key, keyVal-min*2);
                ans += min*4;
            }
            else {
                if (keyVal <= 0) {
                    continue;
                }
                String mirrorKey = ""+key.charAt(1)+key.charAt(0);
                int mirrorVal = freq.getOrDefault(mirrorKey, 0);
                // System.out.println(String.format("mirrorKey: %s, mirrorVal: %d, key: %s, val: %d",
                //                                 mirrorKey,
                //                                 mirrorVal,
                //                                 key,
                //                                 keyVal));
                int min = Math.min(keyVal, mirrorVal);
                if (min > 0) {
                    ans += min*4;
                    freq.put(key, keyVal-min);
                    freq.put(mirrorKey, mirrorVal-min);
                }
            }
        }
        
        for (String key : freq.keySet()) {
            int keyVal = freq.get(key);
            if (keyVal <= 0) {
                continue;
            }
            if (key.charAt(0) == key.charAt(1)) {
                ans += 2;
                break;
            }
        }
        return ans;
    }
}
/*
the fact is, we can only make even-length palindrome
- same char twice: can be added in the middle
- else, i need to find mirrors

wait,, what if the words are like,
["aa", "aa", "aa"] ?
*/