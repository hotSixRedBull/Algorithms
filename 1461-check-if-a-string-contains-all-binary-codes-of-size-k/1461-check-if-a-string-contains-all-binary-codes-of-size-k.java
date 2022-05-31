class Solution {
    public boolean hasAllCodes(String s, int k) {
        Set<Integer> set = new HashSet();
        int val = 0;
        if (s.length() < k) {
            return false;
        }
        for (int i=0; i<k; i++) {
            val <<= 1;
            val += Integer.parseInt(s.charAt(i)+"");
        }
        set.add(val);
        int target = (int)Math.pow(2, k);
        for (int i=k; i<s.length(); i++) {
            val <<= 1;
            val += Integer.parseInt(s.charAt(i)+"");
            val %= target;
            set.add(val);
            if (set.size() == target) {
                return true;
            }
        }
        return false;
    }
}