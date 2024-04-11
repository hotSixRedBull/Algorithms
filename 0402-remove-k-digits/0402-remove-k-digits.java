//saw solution
class Solution {
  public String removeKdigits(String num, int k) {
    LinkedList<Character> stack = new LinkedList<Character>();
        
    for(char digit : num.toCharArray()) {
      while(stack.size() > 0 && k > 0 && stack.peekLast() > digit) {
        stack.removeLast();
        k -= 1;
      }
      stack.addLast(digit);
    }
        
    for(int i=0; i<k; ++i) {
      stack.removeLast();
    }
        
    StringBuilder ret = new StringBuilder();
    boolean leadingZero = true;
    for(char digit: stack) {
      if(leadingZero && digit == '0') continue;
      leadingZero = false;
      ret.append(digit);
    }
        
    if (ret.length() == 0) return "0";
    return ret.toString();
  }
}