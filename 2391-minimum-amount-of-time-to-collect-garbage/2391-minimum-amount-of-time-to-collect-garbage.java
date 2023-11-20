class Solution {
    public int garbageCollection(String[] garbage, int[] travel) {
        int n = garbage.length;
        int[] lastIndex = new int[3]; //MPG
        int[] cnt = new int[3];
        int[] acc = new int[n+1];
        for (int j=0; j<garbage[0].length(); j++) {
            if (garbage[0].charAt(j) == 'M') {
                cnt[0]++;
                lastIndex[0] = 0;
            }
            else if (garbage[0].charAt(j) == 'P') {
                cnt[1]++;
                lastIndex[1] = 0;
            }
            else {
                cnt[2]++;
                lastIndex[2] = 0;
            }
        }
        for (int i=1; i<n; i++) {
            acc[i] = acc[i-1] + travel[i-1];
            for (int j=0; j<garbage[i].length(); j++) {
                if (garbage[i].charAt(j) == 'M') {
                    cnt[0]++;
                    lastIndex[0] = i;
                }
                else if (garbage[i].charAt(j) == 'P') {
                    cnt[1]++;
                    lastIndex[1] = i;
                }
                else {
                    cnt[2]++;
                    lastIndex[2] = i;
                }
            }
        }
        // System.out.println(String.format("lastIndex: %s, cnt: %s, acc: %s",
        //                                  Arrays.toString(lastIndex),
        //                                  Arrays.toString(cnt),
        //                                  Arrays.toString(acc)));
        
        int answer = 0;
        for (int i=0; i<3; i++) {
            answer += acc[lastIndex[i]];
            answer += cnt[i];
        }
        return answer;
    }
}