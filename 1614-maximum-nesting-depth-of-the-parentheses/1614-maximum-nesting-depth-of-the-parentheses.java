class Solution {
    public int maxDepth(String s) {
        StringBuilder sb = new StringBuilder();
        int max = 0;
        int depth = 0;
        for (int i=0; i<s.length(); i++) {
            if (s.charAt(i) == '('
               || s.charAt(i) == ')') {
                sb.append(s.charAt(i));
            }
            else {
                continue;
            }
            if (s.charAt(i) == '(') {
                depth++;
                max = Math.max(max, depth);
            }
            else {
                depth--;
            }
        }
        // System.out.println(sb.toString());
        return max;
    }
}