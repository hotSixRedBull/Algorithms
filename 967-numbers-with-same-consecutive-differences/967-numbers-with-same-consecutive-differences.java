class Solution {
    List<Integer> answerList;
    public int[] numsSameConsecDiff(int n, int k) {
        answerList = new ArrayList();
        for (int i=1; i<10; i++) {
            makeValidNumber(i, i, 1, n, k);
        }
        
        int[] ansArr = new int[answerList.size()];
        int index = 0;
        for (int answer : answerList) {
            ansArr[index++] = answer;
        }
        return ansArr;
    }
    public void makeValidNumber(int built, int prev, int len, int n, int k) {
        if (len == n) {
            answerList.add(built);
            return;
        }
        if (prev + k < 10) {
            int newBuilt = built;
            newBuilt *= 10;
            newBuilt += prev+k;
            makeValidNumber(newBuilt, prev+k, len+1, n, k);
        }
        if (prev - k >= 0
           && k != 0) {
            int newBuilt = built;
            newBuilt *= 10;
            newBuilt += prev-k;
            makeValidNumber(newBuilt, prev-k, len+1, n, k);
        }
    }
}