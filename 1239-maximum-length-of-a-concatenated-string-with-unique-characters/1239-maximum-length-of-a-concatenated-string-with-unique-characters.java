class Solution {
    public int maxLength(List<String> arr) {
        Unit[] units = new Unit[arr.size()];
        for (int i=0; i<arr.size(); i++) {
            units[i] = new Unit(i, arr.get(i));
            if (units[i].val == -1) {
                units[i] = null;
            }
        }
        HashMap<Unit, List<Unit>> neighbors = new HashMap();
        boolean[] visited = new boolean[arr.size()];
        for (int i=0; i<arr.size(); i++) {
            if (units[i] == null) {
                visited[i] = true;
                continue;
            }
            for (int j=i+1; j<arr.size(); j++) {
                if (units[j] == null) {
                    visited[j] = true;
                    continue;
                }
                if ((units[i].val & units[j].val) == 0) {
                    if (neighbors.containsKey(units[i]) == false) {
                        neighbors.put(units[i], new ArrayList());
                    }
                    neighbors.get(units[i]).add(units[j]);
                }
            }
        }
        // System.out.println(neighbors);
        int longest = Integer.MIN_VALUE;
        for (int i=0; i<arr.size(); i++) {
            if (units[i] == null) {
                continue;
            }
            Queue<Unit> q = new ArrayDeque();
            Queue<Integer> lenq = new ArrayDeque();
            Queue<Integer> valq = new ArrayDeque();
            q.add(units[i]);
            lenq.add(units[i].len);
            valq.add(units[i].val);
            visited[i] = true;
            while (q.size() > 0) {
                Unit cur = q.poll();
                int len = lenq.poll();
                int val = valq.poll();
                longest = Math.max(longest, len);
                if (neighbors.containsKey(cur) == false) {
                    continue;
                }
                for (Unit nei : neighbors.get(cur)) {
                    // System.out.println(String.format("val : %s, nei.val: %s, nei.val&val: %s",
                    //                                  Integer.toString(val, 2),
                    //                                 Integer.toString(nei.val, 2),
                    //                                 Integer.toString(nei.val&val, 2)));
                    if ((nei.val & val) == 0) {
                        q.add(nei);
                        lenq.add(len + nei.len);
                        valq.add(val | nei.val);
                        visited[nei.ind] = true;
                    }
                }
            }
        }
        return longest < 0 ? 0 : longest;
    }
}

class Unit {
    int ind;
    int len;
    int val;
    public Unit(int index, String str) {
        ind = index;
        len = str.length();
        for (int i=0; i<str.length(); i++) {
            int newVal = 1 << (str.charAt(i)-'a');
            if ((val & newVal) != 0) {
                val = -1;
                break;
            }
            val += newVal;
        }
        // System.out.println(String.format("str: %s, val: %s", str, Integer.toString(val, 2)));
    }
    public String toString() {
        return String.format("len: %d, val: %s", len, Integer.toString(val, 2));
    }
}

/*
["aa", "bb"]
["ab","cd","cde","cdef","efg","fgh","abxyz"]
*/