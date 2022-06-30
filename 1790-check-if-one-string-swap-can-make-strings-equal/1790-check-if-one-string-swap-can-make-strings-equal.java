class Solution {
    public boolean areAlmostEqual(String s1, String s2) {
        List<Integer> diffIndex = new ArrayList();
        for (int i=0; i<s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                diffIndex.add(i);
                if (diffIndex.size() > 2) {
                    return false;
                }
            }
        }
        if (diffIndex.size() == 0) {
            return true;
        }
        if (diffIndex.size() == 1) {
            return false;
        }
        int i = diffIndex.get(0);
        int j = diffIndex.get(1);
        return s1.charAt(j) == s2.charAt(i) && s1.charAt(i) == s2.charAt(j);
    }
}