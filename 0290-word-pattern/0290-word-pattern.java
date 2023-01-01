class Solution {
    public boolean wordPattern(String pattern, String s) {
        HashMap<Character, String> map = new HashMap();
        HashSet<String> set = new HashSet();
        String[] split = s.split(" ");
        if (split.length != pattern.length()) {
            return false;
        }
        for (int i=0; i<split.length; i++) {
            char cur = pattern.charAt(i);
            if (map.containsKey(cur)) {
                if (map.get(cur).equals(split[i]) == false) {
                    return false;
                }
            }
            else {
                if (set.contains(split[i])) {
                    return false;
                }
                set.add(split[i]);
                map.put(cur, split[i]);
            }
        }
        return true;
    }
}