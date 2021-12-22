class Solution {
    public boolean areOccurrencesEqual(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0)+1);
        }
        int cnt = map.get(s.charAt(0));
        for (char key : map.keySet()) {
            if (map.get(key) != cnt) {
                return false;
            }
        }
        return true;
    }
}