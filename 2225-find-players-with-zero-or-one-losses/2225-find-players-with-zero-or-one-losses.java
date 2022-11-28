class Solution {
    public List<List<Integer>> findWinners(int[][] matches) {
        boolean[] playedMatch = new boolean[100001];
        int[] lost = new int[100001];
        for (int[] match : matches) {
            playedMatch[match[0]] |= true;
            playedMatch[match[1]] |= true;
            lost[match[1]]++;
        }
        List<List<Integer>> answer = new ArrayList();
        answer.add(new ArrayList());
        answer.add(new ArrayList());
        for (int i=0; i<100001; i++) {
            if (playedMatch[i]) {
                if (lost[i] == 0) {
                    answer.get(0).add(i);
                }
                else if (lost[i] == 1) {
                    answer.get(1).add(i);
                }
            }
        }
        return answer;
    }
}