class Solution {
    public String removeKdigits(String num, int k) {
        if (k == 0) {
            return num;
        }
        if (k >= num.length()) {
            return "0";
        }
        
        Stack<Character> stk = new Stack<Character>();

        for(char digit : num.toCharArray()) {
          while(stk.size() > 0 && k > 0 && stk.peek() > digit) {
            stk.pop();
            k -= 1;
          }
          stk.push(digit);
        }

        for(int i=0; i<k; ++i) {
          stk.pop();
        }

        //remove leading zero
        StringBuilder sb = new StringBuilder();
        boolean leadingZero = true;
        for(char digit: stk) {
          if(leadingZero && digit == '0') continue;
          leadingZero = false;
          sb.append(digit);
        }

        if (sb.length() == 0) return "0";
        return sb.toString();
    }
}