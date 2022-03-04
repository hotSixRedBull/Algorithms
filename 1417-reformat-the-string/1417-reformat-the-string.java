class Solution {
    public String reformat(String s) {
        List<Character> nums = new ArrayList();
        List<Character> chars = new ArrayList();
        for (int i=0; i<s.length(); i++) {
            char cur = s.charAt(i);
            if (cur >= '0'
               && cur <= '9') {
                nums.add(cur);
            }
            else {
                chars.add(cur);
            }
        }
        if (Math.abs(chars.size()-nums.size()) > 1) {
            return "";
        }
        else {
            String ans = "";
            if (chars.size() > nums.size()) {
                ans += chars.get(0);
                for (int i=0; i<nums.size(); i++) {
                    ans += nums.get(i);
                    ans += chars.get(i+1);
                }
                return ans;
            }
            else {
                ans += nums.get(0);
                for (int i=0; i<chars.size(); i++) {
                    ans += chars.get(i);
                    if (i+1 < nums.size()) {
                        ans += nums.get(i+1);
                    }
                }
                // if (chars.size() == nums.size()) {
                //     ans += chars.get(chars.size()-1);
                // }
                return ans;
            }
        }
    }
}