class Solution {
    public String reversePrefix(String word, char ch) {
        String ans = "";
        Stack<Character> stk = new Stack();
        for (int i=0; i<word.length(); i++) {
            stk.push(word.charAt(i));
            if (stk.peek() == ch) {
                while (stk.size() > 0) {
                    ans += stk.pop();
                }
                ans += word.substring(i+1, word.length());
                break;
            }
            
        }
        if (ans.length() == 0) {
            return word;
        }
        return ans;
    }
}