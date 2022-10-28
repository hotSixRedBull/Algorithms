class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap();
        for (String str : strs) {
            char[] arr = str.toCharArray();
            Arrays.sort(arr);
            String newStr = new String(arr);
            if (map.containsKey(newStr) == false) {
                map.put(newStr, new ArrayList());
            }
            map.get(newStr).add(str);
        }
        
        List<List<String>> ans = new ArrayList();
        for (String key : map.keySet()) {
            ans.add(map.get(key));           
        }
        return ans;
    }
}

/*
A1. sort and store
T: O(k*l), k = 10^4, l = 100
*/