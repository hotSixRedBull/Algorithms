class Solution {
    public boolean winnerOfGame(String colors) {
        int aliceTurn = 0;
        int bobTurn = 0;
        int sequence = 0;
        char prev = 'c';
        for (char c : colors.toCharArray()) {
            if (c == prev) {
                sequence++;
            }
            else {
                if (sequence > 2) {
                    if (prev == 'A') {
                        aliceTurn += sequence-2;
                    }
                    else {
                        bobTurn += sequence-2;
                    }
                }
                sequence = 1;
                prev = c;
            }
        }
        
        if (sequence > 2) {
            if (prev == 'A') {
                aliceTurn += sequence-2;
            }
            else {
                bobTurn += sequence-2;
            }
        }
        // System.out.println(String.format("alice: %d, bob: %d", aliceTurn, bobTurn));
        return aliceTurn > bobTurn;
    }
}