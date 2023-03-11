class Solution {
    public int shortestWay(String source, String target) {
        HashMap<Character, TreeSet<Integer>> map = new HashMap();
        for (int i=0; i<source.length(); i++) {
            char c = source.charAt(i);
            map.putIfAbsent(c, new TreeSet());
            map.get(c).add(i);
        }
        
        int result = 1;
        int sourceIndex = -1;
        for (int i=0; i<target.length(); i++) {
            char c = target.charAt(i);
            if (map.containsKey(c) == false) {
                return -1;
            }
            Integer pos = map.get(c).higher(sourceIndex);
            if (pos == null) {
                result++;
                sourceIndex = -1;
                pos = map.get(c).higher(sourceIndex);
            }
            sourceIndex = pos;
        }
            
        return result;
    }
}