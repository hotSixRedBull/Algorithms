class Solution {
    public List<List<String>> groupStrings(String[] strings) {
        HashMap<String, List<Integer>> stringMap = new HashMap();
        for (int i=0; i<strings.length; i++) {
            String key = getKey(strings[i]);
            if (!stringMap.containsKey(key)) {
                stringMap.put(key, new ArrayList());
            }
            stringMap.get(key).add(i);
        }
        
        List<List<String>> ans = new ArrayList();
        for (String key : stringMap.keySet()) {
            List<Integer> localList = stringMap.get(key);
            List<String> stringList = new ArrayList();
            for (int i=0; i<localList.size(); i++) {
                stringList.add(strings[localList.get(i)]);
            }
            ans.add(stringList);
        }
        return ans;
    }
    
    public String getKey(String str) {
        int base = str.charAt(0);
        StringBuilder sb = new StringBuilder();
        for (char c : str.toCharArray()) {
            int target = c-base;
            if (target < 0) {
                target = 26+target;
            }
            target += 'a';
            sb.append((char)target);
        }
        System.out.println(str+": "+sb.toString());
        return sb.toString();
    }
}