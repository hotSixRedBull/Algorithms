class Solution {
    public int findRotateSteps(String ring, String key) {
        int[][] dp = new int[key.length()][ring.length()];
        
        Map<Character, List<Integer>> map = new HashMap();
        for (int i=0; i<ring.length(); i++) {
            char c = ring.charAt(i);
            map.putIfAbsent(c, new ArrayList());
            map.get(c).add(i);
        }
        
        for (int index : map.get(key.charAt(0))) {
            dp[0][index] = Math.min(index, ring.length()-index) + 1;
        }
        // // System.out.println(String.format("dp[0]: %s", Arrays.toString(dp[0])));
        
        for (int k=1; k<key.length(); k++) {
            for (int index : map.get(key.charAt(k))) {
                dp[k][index] = Integer.MAX_VALUE;
                for (int prevIndex : map.get(key.charAt(k-1))) {
                    int minDiff = Integer.MAX_VALUE;
                    if (prevIndex == index) {
                        minDiff = 0;
                    }
                    else if (prevIndex < index) {
                        minDiff = Math.min(index-prevIndex, ring.length()-index+prevIndex);
                    }
                    else {
                        minDiff = Math.min(prevIndex-index, ring.length()-prevIndex+index);
                    }
                    dp[k][index] = Math.min(dp[k][index], dp[k-1][prevIndex]+minDiff);
                }
                dp[k][index]++;
            }
        }
        int lastIndex = key.length()-1;
        // System.out.println(String.format("dp[%d]: %s", lastIndex,  Arrays.toString(dp[lastIndex])));
        
        int result = Integer.MAX_VALUE;
        for (int i : map.get(key.charAt(key.length()-1))) {
            result = Math.min(result, dp[key.length()-1][i]);
        }
        return result;
    }
}

/*
각 알파벳 기준으로 최단으로만 가도 될까(그리디)?
--> x. 좀 더 먼 곳에 있는 글자로 맞췄더니(반대방향) 다음 글자가 가까워 질 수 있음.

현재 상태를 나타내는 표현은
(key 어디까지 해독했는지, 지금 커서 위치) ==> 최소 rotate step.
*/