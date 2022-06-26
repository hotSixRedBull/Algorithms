class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int max = 0;
        int sum = 0;
        for (int i=0; i<k; i++) {
            sum += cardPoints[i];
        }
        max = sum;
        // System.out.println(max);
        int rightSum = 0;
        for (int i=0; i<k; i++) {
            sum -= cardPoints[k-1-i];
            rightSum += cardPoints[cardPoints.length-1-i];
            // System.out.println(String.format("sum: %d, rightSum: %d", sum, rightSum));
            max = Math.max(max, sum+rightSum);
        }
        
        return max;
    }
}

/*
considerable test cases
[1,1,100,50,50,3]
3
[1,100,3,2]
2
*/