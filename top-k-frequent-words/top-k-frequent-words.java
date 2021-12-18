class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        HashMap<String, Integer> map = new HashMap<>();
        HashMap<String, Integer> pqMap = new HashMap<>();
        ArrayList<String> pq = new ArrayList<>();
        for (String word : words) {
            int freq = 1;
            if (map.containsKey(word)) {
                freq = map.get(word)+1;
                map.put(word, freq);
            }
            else {
                map.put(word, 1);
            }
        }
        //System.out.println(map);
        List<Map.Entry<String, Integer>> mapEntry = new ArrayList<>(map.entrySet());
        Collections.sort(mapEntry, new Comparator<Map.Entry<String, Integer>>() {
            // compare로 값을 비교
			public int compare(Map.Entry<String, Integer> obj1, Map.Entry<String, Integer> obj2) {
				// 오름 차순 정렬
                if (obj1.getValue() == obj2.getValue()) {
                    return obj1.getKey().compareTo(obj2.getKey());
                }
				return obj2.getValue().compareTo(obj1.getValue());
			}
        });
        //System.out.println(mapEntry);
        
        for (int i=0; i<k; i++) {
            pq.add(mapEntry.get(i).getKey());
        }
        return pq;
    }
}