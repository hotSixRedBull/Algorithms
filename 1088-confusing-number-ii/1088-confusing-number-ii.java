class Solution {
    public char reverseChar(char c) {
        switch(c) {
            case '0':case '1':case'8': return c;
            case '6': return '9';
            case '9': return '6';
            default: return '?';
        }
    }
    public int confusingNumberII(int n) {
        String nStr = Integer.toString(n);
        int[] li = new int[]{0,1,6,8,9};
        char[] charLi = new char[10];
        charLi[0] = '0';
        charLi[1] = '1';
        charLi[6] = '6';
        charLi[8] = '8';
        charLi[9] = '9';
        
        Stack<String> stack = new Stack();
        Stack<Boolean> bstk = new Stack();
        stack.push("");
        bstk.push(false);

        int ans = 0;
        while (stack.size() > 0) {
            String sCur = stack.pop();
            boolean b = bstk.pop();
            if (sCur.length() == nStr.length()) {
                // System.out.println(String.format("> sCur: %s", sCur));
                if(!isSameReverseInteger(sCur)) {
                    ans++;
                }
                continue;
            }
                // System.out.println(String.format("sCur: %s", sCur));
            for (int key : li) {
                if (!b && charLi[key] > nStr.charAt(sCur.length())) {
                    break;
                }
                stack.add(sCur+charLi[key]);
                bstk.add(b || charLi[key] < nStr.charAt(sCur.length()));
            }
        }
        return ans;
    }
    
    public boolean isSameReverseInteger(String s) {
        int l = 0;
        while (l < s.length()
               && s.charAt(l) == '0') {
            l++;
        }
        int r = s.length()-1;
        while (l <= r) {
            if (reverseChar(s.charAt(l)) != s.charAt(r)) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
}