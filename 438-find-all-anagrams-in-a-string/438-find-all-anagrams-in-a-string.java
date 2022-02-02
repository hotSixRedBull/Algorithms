class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int[] pMap = new int[26];
        for (char c : p.toCharArray()) {
            pMap[c-'a']++;
        }
        
        List<Integer> list = new ArrayList();
        int[] sMap = new int[26];
        for (int i=0; i<s.length(); i++) {
            sMap[s.charAt(i)-'a']++;
            if (i >= p.length()) {
                sMap[s.charAt(i-p.length())-'a']--;
            }
            boolean isAnagram = true;
            for (int check=0; check<26; check++) {
                if (sMap[check] != pMap[check]) {
                    isAnagram = false;
                    break;
                }
            }
            if (isAnagram) {
                list.add(i-p.length()+1);
            }
        }
        return list;
    }
}