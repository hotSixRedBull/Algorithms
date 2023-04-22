class Solution {
    String s;
    int[][] cache;
    public int minInsertions(String s) {
        this.s = s;
        cache = new int[s.length()][s.length()];
        for (int i=0; i<s.length(); i++) {
            Arrays.fill(cache[i], -1);
        }
        return recursive(0, s.length()-1, 0, 0);
    }
    public int recursive(int start, int end, int left, int right) {
        if (start == end) {
            if (left == right) {
                return 0;
            }
            return 1;
        }
        if (end - start == 1) {
            if (s.charAt(start) == s.charAt(end)) {
                return 0;
            }    
        }
        if (cache[start][end] != -1) {
            return cache[start][end];
        }
        if (s.charAt(start) == s.charAt(end)) {
            return cache[start][end] = recursive(start+1, end-1, left+1, right+1);
        }
        return cache[start][end] = Math.min(1+recursive(start+1, end, left+1, right+1), 1+recursive(start, end-1, left+1, right+1));
    }
}
/*
짝수인데 홀수로 마무리해야할 경우는 있을 것 같다.
홀수인데 짝수로 마무리를 해야하는 경우도 있을까?
abb면,
abba로 마무리하는게 좋을듯.

recursive(start, end)로 맨 끝부터 비교해서 나가면 될 것 같은데,
start != end면 할 수 있는 경우의 수.
1. start문자를 맨 뒤에 추가하고 recursive(start+1,end)
2. end문자를 맨 앞에 추가하고 recursive(end, start+1)

그럼 abb로 해보면,
1. a(bb)a
2. b(ab)b

이렇게 됐을 때, 기저사건은
1. end == start, return 0;
2. end - start == 1,
   2-1. if (start == end) return 0;
   2-2. if (start != end) return recursive(...);
   근데 둘 중에 하나는 그냥 둬도 되면..?
*/