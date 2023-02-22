class Solution {
    int[] dp;
    int mod;
    public Solution() {
        dp = new int[1001];
        dp[2] = 1;
        mod = 1_000_000_007;
    }
    public int numberOfWays(int numPeople) {
        if (numPeople == 0) {
            return 1;
        }
        if (dp[numPeople] != 0) {
            return dp[numPeople];
        }
        long sum = 0;
        for (int inner=0; inner<=numPeople-2; inner+=2) {
            int outer = numPeople-inner-2;
            long mul = numberOfWays(inner);
            mul *= numberOfWays(outer);
            sum += (int)(mul%mod);
            sum %= mod;
        }
        return dp[numPeople] = (int) sum;
    }
}

/*
부분문제가 생기는 것 같다.

일단 양 옆에 있는거는 붙일 수 있다.
(2개의 경우의 수)

그리고 그 다음부터는, 2칸씩 떨어져야 한다.
(2, 4, 6, ...)
왜냐면 내가 2의 배수로 떨어진 노드와 이어지면, 그 사이에 있는 선들은 서로 연결될 짝이 필요하기 때문.

그럼 만약에, 4칸 멀리있는걸 연결했다고 치자.
예를 들어, 1과 6이 연결됐다. 그럼 나머지 노드는 4개고, 서로 크로스 못하게 잇는 방법은 dp[4]와 같다.
dp[2] = 1;
dp[4] = 2;
dp[6] = 5; 
  - 1-2로 되는 2쌍(dp[0]*dp[4]), 
  - 1-4로 되는 1쌍(dp[2]*dp[2])
  - 1-6으로 되는 2쌍(dp[4]*dp[0]), 
dp[8]
  - 1-2로 되는 5쌍(dp[6])
  - 1-4로 되는 dp[2]*dp[4] => 2쌍
  - 1-6으로 되는 dp[4]*dp[2] => 2쌍
  - 1-8로 되는 5쌍(dp[6])
dp[10]
  - 1-2, dp[8] -> 14
  - 1-10, dp[8] -> 14
  - 1-4, dp[6] -> 5
  - 1-8, dp[6] -> 5
  - 1-6, dp[4]*dp[4] -> 4
*/