class Solution {
    public boolean validWordSquare(List<String> words) {
        for (int r=0; r<words.size(); r++) {
            String rowWord = words.get(r);
            String colWord = "";
            for (int i=0; i<rowWord.length(); i++) {
                if (words.size() <= i
                    || r >= words.get(i).length()) {
                    return false;
                }
                colWord += words.get(i).charAt(r);
            }
            if (rowWord.equals(colWord) == false) {
                return false;
            }
        }
        return true;
    }
}

/*
["ball","asee","let","lep"]
["abc","b"]
*/