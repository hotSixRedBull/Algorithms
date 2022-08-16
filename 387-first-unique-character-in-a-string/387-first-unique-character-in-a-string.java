class Solution {
    public int firstUniqChar(String s) {
        HashMap<Integer, Integer> map = new HashMap();
        for (int i=0; i<s.length(); i++) {
            map.put(s.charAt(i)-'a', map.getOrDefault(s.charAt(i)-'a', 0)+1);
        }
        for (int i=0; i<s.length(); i++) {
            if (map.get(s.charAt(i)-'a') == 1) {
                return i;
            }
        }
        return -1;
    }
}