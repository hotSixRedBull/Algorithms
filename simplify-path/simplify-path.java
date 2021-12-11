class Solution {
    public String simplifyPath(String path) {
        Stack<String> stk = new Stack<String>();
        path = path.replaceAll("//", "/");
        String[] split = path.split("/");
        for (String str : split) {
            if (str.equals("..")) {
                if (stk.size() > 0) {
                    stk.pop();
                }
            }
            else if (str.equals(".") || str.equals("")) {
                continue;
            }
            else {
                stk.push(str);
            }
        }
        return "/" + String.join("/", stk);
    }
}
//"/a/./b/../../c/"