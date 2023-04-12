class Solution {
    public String simplifyPath(String path) {
        String[] split = path.split("/");
        Stack<String> stk = new Stack();
        for (String s : split) {
            if (s.equals("..")) {
                if (stk.size() > 0) {
                    stk.pop();
                }
            }
            else if (s.equals(".")) {
                continue;
            }
            else if (s.length() == 0) { // "//" case
                continue;
            }
            else {
                stk.push(s);
            }
        }
        String result =  stk.size() == 0 ? "/" : "";
        List<String> list = new ArrayList(stk);
        for (String s : list) {
            result = result + "/" +  s;
        }
        return result;
    }
}