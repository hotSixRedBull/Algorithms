class Solution {
    public int countPalindromicSubsequence(String s) {
        Map<Character, TreeSet<Integer>> map = new HashMap();
        for (char c = 'a'; c<='z'; c++) {
            map.put(c, new TreeSet());
        }
        for (int i=0; i<s.length(); i++) {
            map.get(s.charAt(i)).add(i);
        }
        Set<String> set = new HashSet();
        for (char side = 'a'; side<='z'; side++) {
            TreeSet<Integer> sideSet = map.get(side);
            if (sideSet.size() < 2) {
                continue;
            }
            int lo = sideSet.first();
            int hi = sideSet.last();
            for (char middle = 'a'; middle<='z'; middle++) {
                TreeSet<Integer> middleSet = map.get(middle);
                if (middleSet.size() == 0) {
                    continue;
                }
                middleSet = new TreeSet<>(middleSet.tailSet(lo, false));
                middleSet = new TreeSet<>(middleSet.headSet(hi, false));
                if (middleSet.size() > 0) {
                    set.add("" + side + middle + side);
                }
            }
        }
        return set.size();
    }
}