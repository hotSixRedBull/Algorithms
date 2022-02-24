class Solution {
    public String kthDistinct(String[] arr, int k) {
        HashMap<String, Integer> freqMap = new HashMap();
        Set<String> set = new HashSet();
        List<String> list = new ArrayList();
        for (String str : arr) {
            if(freqMap.containsKey(str) == false) {
                set.add(str);
                list.add(str);
            }
            freqMap.put(str, freqMap.getOrDefault(str, 0)+1);
        }
        for (int i=0; i<list.size(); i++) {
            if (freqMap.get(list.get(i)) == 1) {
                k--;
                if (k == 0) {
                    return list.get(i);
                }
            }
        }
        return "";
    }
}