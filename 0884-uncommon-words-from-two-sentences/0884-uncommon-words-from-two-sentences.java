class Solution {
    public String[] uncommonFromSentences(String s1, String s2) {
        Map<String, Integer> m1 = new HashMap();
        Map<String, Integer> m2 = new HashMap();
        String[] ss1 = s1.split(" ");
        String[] ss2 = s2.split(" ");
        for (String s : ss1) {
            m1.put(s, m1.getOrDefault(s, 0)+1);
        }
        for (String s : ss2) {
            m2.put(s, m2.getOrDefault(s, 0)+1);
        }
        List<String> result = new ArrayList();
        for (String s : ss1) {
            if (m1.get(s) == 1
               && m2.containsKey(s) == false) {
                result.add(s);
            }
        }
        for (String s : ss2) {
            if (m2.get(s) == 1
               && m1.containsKey(s) == false) {
                result.add(s);
            }
        }
        String[] ans = new String[result.size()];
        for (int i=0; i<result.size(); i++) {
            ans[i] = result.get(i);
        }
        return ans;
    }
}