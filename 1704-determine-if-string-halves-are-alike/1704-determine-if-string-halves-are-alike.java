class Solution {
    public boolean halvesAreAlike(String s) {
        int leftCnt = 0;
        int rightCnt = 0;
        Set<Character> set = new HashSet(List.of('a','e','i','o','u','A','E','I','O','U'));
        for (int i=0; i<s.length()/2; i++) {
            if (set.contains(s.charAt(i))) {
                leftCnt++;
            }
            if (set.contains(s.charAt(s.length()-1-i))) {
                rightCnt++;
            }
        }
        return leftCnt == rightCnt;
    }
}