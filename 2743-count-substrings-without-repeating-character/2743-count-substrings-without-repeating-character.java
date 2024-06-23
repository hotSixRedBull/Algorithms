class Solution {
    public int numberOfSpecialSubstrings(String s) {
        Set<Character> set = new HashSet();
        
        int start = 0;
        int cnt = 0;
        for (int i=0; i<s.length(); i++) {
            if (set.contains(s.charAt(i))) {
                while (set.contains(s.charAt(i))) {
                    set.remove(s.charAt(start));
                    start++;
                }
            }
            set.add(s.charAt(i));
            cnt += set.size();
        }
        return cnt;
    }
}

/*
"abab"에서 중간 ba를 셀 때, "b", "a", "ba"라고 세버려서 "b"가 중복으로 세어지는 걸 막을 수 없다.
--> i에서 끝나는 조합을 더하면 된다. 그건 set의 size.
*/