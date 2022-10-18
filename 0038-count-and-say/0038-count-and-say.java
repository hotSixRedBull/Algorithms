class Solution {
    public String countAndSay(int n) {
        if (n == 1) {
            return "1";
        }
        String answer = new String();
        String toRead = countAndSay(n-1);
        char prev = toRead.charAt(0);
        int cnt = 1;
        for (int i=1; i<toRead.length(); i++) {
            if (prev != toRead.charAt(i)) {
                answer = answer + Integer.toString(cnt) + prev;
                prev = toRead.charAt(i);
                cnt = 1;
            }
            else {
                cnt++;
            }
        }
        answer = answer + Integer.toString(cnt) + prev;
        
        return answer;
    }
}

/*
1
11
12
1121
*/