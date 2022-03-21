class Solution {
    public List<Integer> partitionLabels(String s) {
        HashMap<Character, Integer> map = new HashMap();
        for (int i=0; i<s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i),0)+1);
        }
        
        List<Integer> ans = new ArrayList();
        for (int i=0; i<s.length(); i++) {
            HashMap<Character, Integer> lmap = new HashMap();
            int j=i;
            // System.out.println(String.format("j: %d", j));
            for (; j<s.length(); j++) {
                lmap.put(s.charAt(j), lmap.getOrDefault(s.charAt(j),0)+1);
                boolean isValid = true;
                for (char c : lmap.keySet()) {
                    if (lmap.get(c) != map.get(c)) {
                        isValid = false;
                        break;
                    }
                }
                if (isValid) {
                    ans.add(j-i+1);
                    break;
                }
            }
            i = j;
        }
        return ans;
    }
}