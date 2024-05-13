//saw solution
class Solution {
    public int matrixScore(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        // Set first column
        for (int i = 0; i < m; i++) {
            if (grid[i][0] == 0) {
                // Flip row
                for (int j = 0; j < n; j++) {
                    grid[i][j] = 1 - grid[i][j];
                }
            }
        }

        // Optimize columns except first column
        for (int j = 1; j < n; j++) {
            int countZero = 0;
            // Count zeros
            for(int i = 0; i < m; i++) {
                if(grid[i][j] == 0) {
                    countZero++;
                }
            }
            // Flip the column if there are more zeros for better score
            if(countZero > m-countZero) {
                for(int i = 0; i < m; i++) {
                    grid[i][j] = 1 - grid[i][j];
                }
            }
        }

        // Calculate the final score considering bit positions
        int score = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // Left shift bit by place value of column to find column contribution
                int columnScore = grid[i][j] << (n - j - 1);
                // Add contribution to score
                score += columnScore;
            }
        }

        // return final result
        return score;
    }
}

/*
greedy하게 풀 수 있을까?
1. 첫번째 자리를 어떻게든 1로 만든다.
   1-1. 일단 가장 많은 1이 존재하게끔 col1을 뒤집고
   1-2. 나머지 맨앞이 0인 것들을 flip
2. col을 돌면서, 1 개수가 제일 많도록 flip

dp로 풀 수 있을까?
어디까지 절대 안변하게 고정해두고, 나머지 것들을 움직인다면.
--> 안변하는 구간을 만들수가 있을까

BFS?


*경우의 수가 너무 많아서 포기
--> 이래서 그리디한 방법을 풀었어야 하는구나.
*/