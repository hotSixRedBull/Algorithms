class Solution {
    public int countPoints(String rings) {
        Set<Character>[] sets = new HashSet[10];
        for (int i=0; i<10; i++) {
            sets[i] = new HashSet();
        }
        for (int i=0; i<rings.length(); i+=2) {
            int ring = Character.getNumericValue(rings.charAt(i+1));
            sets[ring].add(rings.charAt(i));
        }
        
        int cnt = 0;
        for (Set<Character> set : sets) {
            if (set.size() == 3) {
                cnt++;
            }
        }
        return cnt;
    }
}