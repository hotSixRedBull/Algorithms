class Solution {
    public String predictPartyVictory(String senate) {
        // System.out.println(String.format(">>%s", senate));
        String round = senate;
        while (round.length() > 1) {
            round = buildString(round);
        }
        if (round.charAt(0) == 'R') {
            return "Radiant";
        }
        return "Dire";
    }
    public String buildString(String round) {
        ArrayDeque<Character> q = new ArrayDeque();
        int rCnt = 0;
        int dCnt = 0;
        int rRight = 0;
        int dRight = 0;
        for (int i=0; i<round.length(); i++) {
            if (round.charAt(i) == 'R') {
                rCnt++;
                if (dRight > 0) {
                    dRight--;
                    continue;
                }
                rRight++;
                q.add('R');
            }
            else {
                dCnt++;
                if (rRight > 0) {
                    rRight--;
                    continue;
                }
                dRight++;
                q.add('D');
            }
        }
        if (rCnt == 0) {
            return "D";
        }
        if (dCnt == 0) {
            return "R";
        }
        StringBuilder sb = new StringBuilder();
        while (q.size() > 0) {
            if (q.getFirst() == 'R'
               && dRight > 0) {
                q.poll();
                dRight--;
                continue;
            }
            if (q.getFirst() == 'D'
               && rRight > 0) {
                q.poll();
                rRight--;
                continue;
            }
            sb.append(q.poll());
        }
        // System.out.println(String.format("buildString(%s): %s", round, sb.toString()));
        return sb.toString();
    }
}

/*
"RD"
"RDD"
"DDRRR"
"RDDR"
"DDRR"
"DRRD"
"DRD"
"RDR"
"RDD"
"DRR"
"DDD"
"RRR"
"RRDDR"
"DDRRD"
"DRDRDRD"
"DRRDRDRDRDDRDRDR"
*/