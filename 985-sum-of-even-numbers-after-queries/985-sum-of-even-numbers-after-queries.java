class Solution {
    public int[] sumEvenAfterQueries(int[] nums, int[][] queries) {
        int[] answer = new int[queries.length];
        int sum = 0;
        int sumIndex = 0;
        for (int num : nums) {
            if (num % 2 == 0) {
                sum += num;
            }
        }
        for (int[] query : queries) {
            if (Math.abs(nums[query[1]])%2 == 1) {
               if (Math.abs(query[0])%2 == 1) {
                sum += nums[query[1]] + query[0];
               }
            }
            else if (Math.abs(nums[query[1]])%2 == 0) {
                if (Math.abs(query[0])%2 == 0) {
                    sum += query[0];
                }
                else {
                    sum -= nums[query[1]];
                }
            }
            nums[query[1]] += query[0];
            // System.out.println(Arrays.toString(nums));
            answer[sumIndex++] = sum;
        }
        return answer;
    }
}

/*
[-10,2,-4,5,-3,3]
[[-4,2],[9,0],[-8,1],[5,4],[1,4],[9,0]]

[-1,3,-3,9,-6,8,-5]
[[-5,1],[10,2],[-6,3],[3,2],[9,5],[7,5],[8,0]]

[-10,2,-8,5,-3,3]
[-1,2,-8,5,-3,3]
[-1,-6,-8,5,-3,3]
[-1,-6,-8,5,2,3]
[-1,-6,-8,5,3,3]
[8,-6,-8,5,3,3]
*/