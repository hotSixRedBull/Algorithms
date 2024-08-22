class Solution {
    List<String> result;
    public List<String> generateAbbreviations(String word) {
        result = new ArrayList();
        gen(word, 0, "");
        return result;
    }
    public void gen(String word, int cur, String built) {
        if (cur == word.length()) {
            result.add(built);
            return;
        }
        if (built.length() != 0 
            && isNumber(built.charAt(built.length()-1))) {
            //cannot use number
            gen(word, cur+1, built+word.charAt(cur));
        }
        else {
            for (int i=1; cur+i<=word.length(); i++) {
                gen(word, cur+i, built+Integer.toString(i));
            }
            gen(word, cur+1, built+word.charAt(cur));
        }
    }
    public boolean isNumber(char c) {
        return c >= '0' && c <= '9';
    }
}