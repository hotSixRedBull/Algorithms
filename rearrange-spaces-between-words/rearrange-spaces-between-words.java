class Solution {
    public String reorderSpaces(String text) {
        char[] chars = text.toCharArray();
        int spaceCnt = 0;
        ArrayList<String> strs = new ArrayList<>();
        for (int i=0; i<chars.length; i++) {
            if (chars[i] == ' ') {
                spaceCnt++;
            }
            else {
                String word = "";
                while (i < chars.length && chars[i] != ' ') {
                    word += chars[i];
                    i++;
                }
                i--;
                strs.add(word);
            }
        }
        if (strs.size() == 1) {
            return strs.get(0) + " ".repeat(spaceCnt);
        }
        int width = spaceCnt/(strs.size()-1);
        int remainder = spaceCnt%(strs.size()-1);
        String ans = strs.get(0);
        for (int i=1; i<strs.size(); i++) {
            ans += " ".repeat(width);
            ans += strs.get(i);
        }
        ans += " ".repeat(remainder);
        return ans;
    }
}