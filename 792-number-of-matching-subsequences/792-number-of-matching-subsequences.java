class Solution {
    public int numMatchingSubseq(String s, String[] words) {
        HashMap<Character, List<Integer>> map = new HashMap();
        for (int i=0; i<s.length(); i++) {
            if (map.containsKey(s.charAt(i)) == false) {
                map.put(s.charAt(i), new ArrayList());
            }
            map.get(s.charAt(i)).add(i);
        }
        
        int cnt = 0;
        for (String word : words) {
            int prev = -1;
            int matched = 0;
            for (int i=0; i<word.length(); i++) {
                if (map.containsKey(word.charAt(i)) == false) {
                    continue;
                }
                List<Integer> li = map.get(word.charAt(i));
                int lo = 0;
                int hi = li.size()-1;
                while (lo < hi) {
                    int mid = lo - (lo - hi) / 2;
                    if (prev >= li.get(mid)) {
                        lo = mid+1;
                    }
                    else {
                        hi = mid;
                    }
                }
                // System.out.println(String.format("prev: %d, li.get(lo): %d", prev, li.get(lo)));
                if (li.get(lo) > prev) {
                    prev = li.get(lo);
                    matched++;
                }
                else {
                    break;
                }
            }
            if (matched == word.length()) {
                // System.out.println(word);
                cnt++;
            }
        }
        return cnt;
    }
}