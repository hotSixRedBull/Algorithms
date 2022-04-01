class Solution {
    static List<List<Character>> list = new ArrayList();
    static List<String> ansList = new ArrayList();
    
    public String[] expand(String s) {
        list = new ArrayList();
        ansList = new ArrayList();
        int len = s.length();
        for (int i=0; i<len; i++) {
            List<Character> newList = new ArrayList();
            if (s.charAt(i) == '{') {
                int start = i+1;
                while (s.charAt(i) != '}') {
                    i++;
                }
                newList = new ArrayList(Arrays.asList(s.substring(start, i).split(",")));
                Collections.sort(newList);
            }
            else {
                newList.add(s.charAt(i));
            }
            list.add(newList);
        }
        recursive(0, "");
        // System.out.println(ansList);
        String[] ans = ansList.toArray(new String[0]);
        return ans;
    }
    
    public static void recursive(int cur, String built) {
        if (cur == list.size()) {
            ansList.add(built);
            return;
        }
        List<Character> cList = list.get(cur);
        for (int i=0; i<cList.size(); i++) {
            recursive(cur+1, built + cList.get(i));
        }
    }
}