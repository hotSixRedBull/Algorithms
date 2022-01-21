class Solution {
    public String[] uncommonFromSentences(String s1, String s2) {
        HashMap<String, Integer> freqMap1 = new HashMap<>();
        HashMap<String, Integer> freqMap2 = new HashMap<>();
        String[] s1Arr = s1.split(" ");
        String[] s2Arr = s2.split(" ");
        for (int i=0; i<s1Arr.length; i++) {
            freqMap1.put(s1Arr[i], freqMap1.getOrDefault(s1Arr[i], 0) + 1);
        }
        
        ArrayList<String> ansList = new ArrayList<>();
        for (int i=0; i<s2Arr.length; i++) {
            freqMap2.put(s2Arr[i], freqMap2.getOrDefault(s2Arr[i], 0) + 1);
        }
        
        for (String key : freqMap1.keySet()) {
            if (freqMap1.get(key) == 1 && !freqMap2.containsKey(key)) {
                ansList.add(key);
            }
        }
        
        for (String key : freqMap2.keySet()) {
            if (freqMap2.get(key) == 1 && !freqMap1.containsKey(key)) {
                ansList.add(key);
            }
        }
        return ansList.stream().toArray(String[]::new);
    }
}