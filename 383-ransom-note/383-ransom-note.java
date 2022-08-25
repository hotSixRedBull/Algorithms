class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] rMap = new int[26];
        int[] mMap = new int[26];
        for (int i=0; i<ransomNote.length(); i++) {
            rMap[ransomNote.charAt(i)-'a']++;
        }
        for (int i=0; i<magazine.length(); i++) {
            mMap[magazine.charAt(i)-'a']++;
        }
        
        for (int i=0; i<26; i++) {
            mMap[i] -= rMap[i];
            if (mMap[i] < 0) {
                return false;
            }
        }
        return true;
    }
}