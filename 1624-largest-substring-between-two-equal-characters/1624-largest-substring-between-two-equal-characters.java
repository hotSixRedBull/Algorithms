class Solution {
    public int maxLengthBetweenEqualCharacters(String s) {
        Map<Integer, List<Integer>> map = new HashMap();
        for (int i=0; i<26; i++) {
            map.put(i, new ArrayList());
        }
        for (int i=0; i<s.length(); i++) {
            map.get(s.charAt(i)-'a').add(i);
        }
        int max = -1;
        for (int i=0; i<26; i++) {
            List<Integer> li = map.get(i);
            for (int j=0; j<li.size()-1; j++) {
                max = Math.max(max, li.get(j+1)-li.get(0)-1);
            }
        }
        return max;
    }
}