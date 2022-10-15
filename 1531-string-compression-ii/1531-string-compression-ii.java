//saw solution
class Solution {
    private Map<Integer, Integer> memo = new HashMap<>();
    Set<Integer> add = Set.of(1, 9, 99);
    public int getLengthOfOptimalCompression(String s, int k) {
        return dp(s, 0, (char) ('a' + 26), 0, k);
    }

    private int dp(String s, int idx, char lastChar, int lastCharCount, int k) {
        if (k < 0) {
            return Integer.MAX_VALUE / 2;
        }

        if (idx == s.length()) {
            return 0;
        }

        int key = idx * 101 * 27 * 101 + (lastChar - 'a') * 101 * 101 + lastCharCount * 101 + k;

        if (memo.containsKey(key)) {
            return memo.get(key);
        }

        int keepChar;
        int deleteChar = dp(s, idx + 1, lastChar, lastCharCount, k - 1);
        if (s.charAt(idx) == lastChar) {
            keepChar = dp(s, idx + 1, lastChar, lastCharCount + 1, k) + (add.contains(lastCharCount) ? 1 : 0);
        } else {
            keepChar = dp(s, idx + 1, s.charAt(idx), 1, k) + 1;
        }
        int res = Math.min(keepChar, deleteChar);
        memo.put(key, res);

        return res;
    }
}
/*
class Solution {
    public int getLengthOfOptimalCompression(String s, int k) {
        List<Unit> units = new ArrayList();
        char prev = s.charAt(0);
        int size = 1;
        for (int i=1; i<s.length(); i++) {
            if (prev == s.charAt(i)) {
                size++;
            }
            else {
                units.add(new Unit(prev, size));
                prev = s.charAt(i);
                size = 1;
            }
        }
        units.add(new Unit(prev, size));
        // System.out.println("units: "+units);
        
        int min = Integer.MAX_VALUE;
        for (int i=0; i<units.size(); i++) {
            min = Math.min(min, getLengthOfOptimalCompression(units,k,i));
        }
        
        return min;
    }
    public int getLengthOfOptimalCompression(List<Unit> units,
                                             int k,
                                             int start) {
        System.out.println(String.format("k: %d, start: %d, units: %s",
                                         k,
                                         start,
                                         units));
        if (start == units.size()) {
            return getLength(units);
        }
        
        // skip
        int min = getLengthOfOptimalCompression(units, k, start+1);
        
        // merge
        int required = 0;
        char name = units.get(start).name;
        int size = units.get(start).size;
        for (int i=start+1; i<units.size(); i++) {
            Unit cur = units.get(i);
            if (cur.name == name) {
                // merge
                List<Unit> newList = new ArrayList(units.subList(0, start));
                newList.add(new Unit(name, size+cur.size));
                int newStart = newList.size()-1;
                if (i+1 < units.size()) {
                    newList.addAll(units.subList(i+1, units.size()));
                }
                if (newStart < newList.size()) {
                    min = Math.min(min, getLengthOfOptimalCompression(newList,
                                                                     k-required,
                                                                     newStart));
                }
                else {
                    min = Math.min(min, getLength(newList));
                }
                break;
            }
            else {
                required += units.get(i).size;
                if (required > k) {
                    break;
                }
            }
        }
        
        // remove what i can
        TreeMap<Integer, List<Unit>> map = new TreeMap();
        for (int i=units.size()-1; i>=0; i--) {
            if (map.containsKey(units.get(i).size) == false) {
                map.put(units.get(i).size, new LinkedList());
            }
            map.get(units.get(i).size).add(new Unit(units.get(i)));
        }
        // System.out.println("map: "+map);
        int left = required > k ? k : k-required;
        Integer floorKey = map.floorKey(left);
        while (floorKey != null) {
            left -= floorKey;
            List<Unit> largest = map.get(floorKey);
            largest.remove(0);
            if (largest.size() == 0) {
                map.remove(floorKey);
            }
            floorKey = map.floorKey(left);
        }
        // decrease longer keys (like a11 -> a9)
        while (left > 0) {
            //remove log10(x) >= 1
            Integer ceilKey =  map.ceilingKey(10);
            if (ceilKey == null) {
                break;
            }
            List<Unit> smallest = map.get(ceilKey);
            int toRemove = left <= ceilKey-9 ? left : ceilKey-9;
            // System.out.println("toRemove: "+ toRemove);
            Unit unit = smallest.get(0);
            smallest.remove(0);
            if (smallest.size() == 0) {
                map.remove(ceilKey);
            }
            unit.size -= toRemove;
            left -= toRemove;
            // System.out.println("toRemove unit: "+ unit);
            // System.out.println("left: "+ left);
            if (map.containsKey(unit.size) == false) {
                map.put(unit.size, new ArrayList());
            }
            map.get(unit.size).add(unit);
        }
        
        // System.out.println("map after decrease longer keys : "+map);
        
        if (left > 0) {
            //remove left for longer keys
            Integer ceilKey =  map.ceilingKey(left);
            if (ceilKey != null) {
                List<Unit> smallest = map.get(ceilKey);
                Unit unit = smallest.get(0);
                smallest.remove(0);
                if (smallest.size() == 0) {
                    map.remove(ceilKey);
                }
                unit.size -= left;
                if (unit.size != 0) {
                    if (map.containsKey(unit.size) == false) {
                        map.put(unit.size, new ArrayList());
                    }
                    map.get(unit.size).add(unit);
                }
            }
        }
        // System.out.println("removed map: \n"+map);
        int lengthAfterRemove = 0;
        for (int key : map.keySet()) {
            lengthAfterRemove += getLength(map.get(key));
        }
        // System.out.println(String.format("lengthAfterRemove: %d", lengthAfterRemove));
        min = Math.min(min, lengthAfterRemove);
        return min;
    }
    
    public int getLength(List<Unit> units) {
        int len = 0;
        for (Unit u : units) {
            if (u.size == 0) {
                continue;
            }
            if (u.size != 1) {
                len += Math.log10(u.size)+1;
            }
            len++;
        }
        return len;
    }
}

class Unit {
    char name;
    int size;
    public Unit(char c, int s) {
        name = c;
        size = s;
    }
    public Unit(Unit u) {
        name = u.name;
        size = u.size;
    }
    public String toString() {
        return String.format("{%c%d}", name, size);
    }
}

/* 
Inputs:

"aaabcccd"
2
"aabbaa"
2
"aaaaaaaaaaa"
0
"abcabc"
4
"abcbca"
4
"aaab"
1
"aaba"
1
"a"
1
"abcdeafagaha"
4
"aaaaaaaaaaa"
2
"bbabbbabbbbcbb"
4
"aaaaaaaaaaabbbbbbbbbbb"
4
"aaaaaaaaaabbbbbbbbbbb"
3


Error 1: TLE
"aaba"
1

Error 2: WA
"bbabbbabbbbcbb"
4

Error 3: WA
"aabaabbcbbbaccc"
6
*/