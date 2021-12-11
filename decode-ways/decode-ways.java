class Solution {
    private int[] dp = new int[100];
    public int numDecodings(String s) {
        Arrays.fill(dp, 0);
        if (s.charAt(0) != '0') {
            dp[0] = 1;
        }
        else {
            dp[0] = 0;
        }
        countDecode(1, s);
        //System.out.println(Arrays.toString(dp));
        return dp[s.length()-1];
    }
    public void countDecode(int index, String s) {
        if (index >= s.length()) {
            return ;
        }
        
        //dp[index]는 index까지의 경우의 수
        int calc = 0;
        if (index > 0) {
            int before = Integer.parseInt(s.charAt(index-1)+"");
            int current = Integer.parseInt(s.charAt(index)+"");
            if (before < 3 && before != 0 && before*10+current < 27) {
                if (index < 2) {
                    calc++;
                }
                else {
                    calc+=dp[index-2];
                }
            }
            if (current != 0) {
                calc+=dp[index-1];
            }
        }
        dp[index] = calc;
        countDecode(index+1, s);
        return ;
    }
}