class Solution {
    public int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
        int target = 0;
        if (ruleKey.equals("color")) {
            target = 1;
        }
        else if (ruleKey.equals("name")) {
            target = 2;
        }
        
        int cnt = 0;
        for (List<String> item : items) {
            if (item.get(target).equals(ruleValue)) {
                cnt++;
            }
        }
        
        return cnt;
    }
}