class Solution {
    HashMap<Character, List<Integer>> map = new HashMap();
    public int numOfStrings(String[] patterns, String word) {
        for (int i=0; i<word.length(); i++) {
            if (!map.containsKey(word.charAt(i))) {
                List<Integer> list = new ArrayList();
                list.add(i);
                map.put(word.charAt(i), list);
            }
            else {
                map.get(word.charAt(i)).add(i);
            }
        }
        
        int cnt = 0;
        for (String str : patterns) {
            List<Integer> candidates = map.getOrDefault(str.charAt(0), new ArrayList());
            for (int candidate : candidates) {
                if (candidate+str.length() <= word.length()
                   && word.substring(candidate, candidate+str.length()).equals(str)) {
                    cnt++;
                    break;
                }
             }
        }
        return cnt;
    }
}