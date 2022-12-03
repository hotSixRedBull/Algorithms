class Solution {
    public String frequencySort(String s) {
        HashMap<Character, Integer> map = new HashMap();
        for (int i=0; i<s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0)+1);
        }
        PriorityQueue<Unit> units = new PriorityQueue<Unit>((a, b) -> b.freq-a.freq);
        for (char key : map.keySet()) {
            units.add(new Unit(key, map.get(key)));
        }
        StringBuilder sb = new StringBuilder();
        while (units.size() > 0) {
            Unit cur = units.poll();
            StringBuilder newSb = new StringBuilder();
            newSb.append(cur.c);
            sb.append(newSb.toString().repeat(cur.freq));
        }
        return sb.toString();
    }
}
class Unit {
    public char c;
    public int freq;
    public Unit(char ch, int fr) {
        c = ch;
        freq = fr;
    }
}