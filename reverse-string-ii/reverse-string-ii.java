class Solution {
    public String reverseStr(String s, int k) {
        String answer = "";
        int i=0;
        for (; i<s.length(); i+=2*k) {
            int middle = Math.min(s.length(), i+k);
            for (int cur=middle-1; cur>=i; cur--) {
                answer += s.charAt(cur);
            }
            int end = Math.min(s.length(), i+2*k);
            for (int cur=middle; cur<end; cur++) {
                answer += s.charAt(cur);
            }
        }
        return answer;
    }
}