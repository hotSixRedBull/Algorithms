class Solution {
    public String parseTernary(String expression) {
        // System.out.println(String.format("expression: %s", expression));
        if (expression.length() == 1) {
            return expression;
        }
        if (expression.charAt(0) == 'T') {
            return parseTernary(findT(expression.substring(2,expression.length())));
        }
        else {
            return parseTernary(findF(expression.substring(2,expression.length())));
        }
    }
    public String findT(String exp) {
        // System.out.println(String.format("findT: %s", exp));
        int score = 0;
        for (int i=0; i<exp.length(); i++) {
            if (exp.charAt(i) == '?') {
                score--;
            }
            else if (exp.charAt(i) == ':') {
                score++;
            }
            if (score == 1) {
                return exp.substring(0, i);
            }
        }
        return "";
    }
    public String findF(String exp) {
        // System.out.println(String.format("findF: %s", exp));
        int score = 0;
        for (int i=0; i<exp.length(); i++) {
            if (exp.charAt(i) == '?') {
                score--;
            }
            else if (exp.charAt(i) == ':') {
                score++;
            }
            if (score == 1) {
                return exp.substring(i+1, exp.length());
            }
        }
        return "";
    }
}