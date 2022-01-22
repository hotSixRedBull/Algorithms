class Solution {
    public int minTimeToType(String word) {
        int keyPos = 1;
        int move = 0;
        for (char keyToType : word.toCharArray()) {
            int targetPos = keyToType-'a'+1;
            int clockwise = keyPos <= targetPos ? Math.abs(keyPos-targetPos) : Math.abs(keyPos-targetPos-26);
            int counterwise = keyPos <= targetPos ?  Math.abs((26+keyPos-targetPos)%27):Math.abs((26+keyPos-targetPos-26)%27);
            int minimumMove = Math.min(clockwise, counterwise);
            move += minimumMove+1;
            keyPos = targetPos;
        }
        return move;
    }
}