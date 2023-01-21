class Solution {
    List<String> ans;
    public List<String> restoreIpAddresses(String s) {
        ans = new ArrayList();
        if (s.length() > 12) {
            return ans;
        }
        recursive(s, 0, 4, new ArrayList());
        return ans;
    }
    public void recursive(String s, int cur, int left, List<String> built) {
        if (left == 0) {
            if (cur != s.length()) {
                return;
            }
            if (built.size() != 4) {
                return;
            }
            // System.out.println(built);
            for (int i=0; i<4; i++) {
                if (built.get(i).charAt(0) == '0'
                   && built.get(i).length() != 1) {
                    return; //leading zeros
                }
                int val = Integer.parseInt(built.get(i));
                if (val < 0 || val > 255) {
                    return; // over the range
                }
            }
            ans.add(String.join(".", built.toArray(new String[3])));
            return;
        }
        for (int i=1; i<=3 && s.length() >= cur+i; i++) {
            // System.out.println(String.format("s.substring(cur, cur+i): %s",s.substring(cur, cur+i)));
            built.add(s.substring(cur, cur+i));
            recursive(s, cur+i, left-1, built);
            built.remove(built.size()-1);
        }
    }
}