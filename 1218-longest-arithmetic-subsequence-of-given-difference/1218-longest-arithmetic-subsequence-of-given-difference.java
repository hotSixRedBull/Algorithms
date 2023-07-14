//saw solution
class Solution {
    public int longestSubsequence(int[] arr, int difference) {
        Map<Integer, Integer> dp = new HashMap<>();
        int answer = 1;
        
        for (int a : arr) {
            int beforeA = dp.getOrDefault(a - difference, 0);
            dp.put(a, beforeA + 1);
            answer = Math.max(answer, dp.get(a));
        }
        
        return answer;
    }
}
/*
class Solution {
    public int longestSubsequence(int[] arr, int difference) {
        int n = arr.length;
        Map<Integer, List<Integer>> map = new HashMap();
        for (int i=n-1; i>=0; i--) {
            map.putIfAbsent(arr[i], new ArrayList());
            map.get(arr[i]).add(i);
        }
        
        for (int key : map.keySet()) {
            Collections.sort(map.get(key));
        }
        
        int max = 1;
        boolean[] visit = new boolean[n];
        for (int i=0; i<n; i++) {
            if (visit[i]) {
                continue;
            }
            // System.out.println(String.format("start from arr[%d]: %d", i, arr[i]));
            int len = 1;
            int pos = i;
            int target = arr[i]+difference;
            while (map.containsKey(target)) {
                visit[pos] = true;
                List<Integer> li = map.get(target);
                // System.out.println(String.format("pos: %d, target: %d, len: %d, li: %s", pos, target, len, li));
                if (li.get(li.size()-1) <= pos) {
                    break;
                }
                
                int nextPos = Collections.binarySearch(map.get(target), pos+1);
                // System.out.println(String.format("nextPos: %d", nextPos));
                if (nextPos < 0) {
                    int insertionPoint = (nextPos+1)*-1;
                    pos = li.get(insertionPoint);
                    // System.out.println(String.format("insertionPoint: %d", insertionPoint));
                }
                else {
                    pos = li.get(nextPos);
                }
                target += difference;
                len++;
            }
            max = Math.max(max, len);
        }
        return max;
    }
}
*/
/*
[4,12,10,0,-2,7,-8,9,-9,-12,-12,8,8]
0
*/