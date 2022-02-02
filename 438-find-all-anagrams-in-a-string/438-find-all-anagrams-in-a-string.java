class Solution {
    int[] map;
    public List<Integer> findAnagrams(String s, String p) {
        map = new int[26];
        for (char c : p.toCharArray()) {
            map[c-'a']++;
        }
        
        List<Integer> list = new ArrayList();
        for (int i=0; i<s.length(); i++) {
            if (i+p.length() <= s.length()) {
                String substring = s.substring(i, i+p.length());
                if (isAnagram(substring)) {
                    list.add(i);
                }
            }
        }
        return list;
    }
    
    public boolean isAnagram(String s) {
        int[] mapClone = Arrays.copyOf(map, 26);
        // System.out.println(Arrays.toString(mapClone));
        for (char c : s.toCharArray()) {
            if (mapClone[c-'a'] == 0) {
                return false;
            }
            else {
                mapClone[c-'a']--;
            }
        }
        
        for (int i=0; i<26; i++) {
            if (mapClone[i] != 0) {
                return false;
            }
        }
        
        return true;
    }
}