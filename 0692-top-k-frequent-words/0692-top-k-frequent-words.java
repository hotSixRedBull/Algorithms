class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        HashMap<String, Integer> map = new HashMap();
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        
        Unit[] units = new Unit[map.size()];
        int index = 0;
        for (String key : map.keySet()) {
            units[index++] = new Unit(key, map.get(key));
        }
        
        Arrays.sort(units, (a, b) -> {
            if (a.cnt == b.cnt) {
                return a.name.compareTo(b.name);
            }
            return b.cnt-a.cnt;
        });
        
        List<String> answer = new ArrayList();
        for (int i=0; i<k; i++) {
            answer.add(units[i].name);
        }
        
        return answer;
    }
}

class Unit {
    String name;
    int cnt;
    public Unit(String name, int cnt) {
        this.name = name;
        this.cnt = cnt;
    }
}