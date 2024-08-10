//saw solution
//wrong answer on 3,3 testcase
class Solution {

    public int numberOfPatterns(int m, int n) {
        int[][] jump = new int[10][10];

        // Initialize the jump over numbers for all valid jumps
        jump[1][3] = jump[3][1] = 2;
        jump[4][6] = jump[6][4] = 5;
        jump[7][9] = jump[9][7] = 8;
        jump[1][7] = jump[7][1] = 4;
        jump[2][8] = jump[8][2] = 5;
        jump[3][9] = jump[9][3] = 6;
        jump[1][9] = jump[9][1] = jump[3][7] = jump[7][3] = 5;

        int visitedNumbers = 0;
        int totalPatterns = 0;
        Integer[][] dp = new Integer[10][1 << 10];

        // Count patterns starting from corner numbers (1, 3, 7, 9) and multiply by 4 due to symmetry
        totalPatterns +=
        countPatternsFromNumber(1, 1, m, n, jump, visitedNumbers, dp) * 4;

        // Count patterns starting from edge numbers (2, 4, 6, 8) and multiply by 4 due to symmetry
        totalPatterns +=
        countPatternsFromNumber(2, 1, m, n, jump, visitedNumbers, dp) * 4;

        // Count patterns starting from the center number (5)
        totalPatterns +=
        countPatternsFromNumber(5, 1, m, n, jump, visitedNumbers, dp);

        return totalPatterns;
    }

    private int countPatternsFromNumber(
        int currentNumber,
        int currentLength,
        int minLength,
        int maxLength,
        int[][] jump,
        int visitedNumbers,
        Integer[][] dp
    ) {
        // Base case: if current pattern length exceeds maxLength, stop exploring
        if (currentLength > maxLength) return 0;

        if (
            dp[currentNumber][visitedNumbers] != null
        ) return dp[currentNumber][visitedNumbers];

        int validPatterns = 0;
        // If current pattern length is within the valid range, count it
        if (currentLength >= minLength) {
            validPatterns++;
        }

        visitedNumbers = setBit(visitedNumbers, currentNumber);

        // Explore all possible next numbers
        for (int nextNumber = 1; nextNumber <= 9; nextNumber++) {
            int jumpOverNumber = jump[currentNumber][nextNumber];
            // Check if the next number is unvisited and either:
            // 1. There's no number to jump over, or
            // 2. The number to jump over has been visited
            if (
                !isSet(visitedNumbers, nextNumber) &&
                (jumpOverNumber == 0 || isSet(visitedNumbers, jumpOverNumber))
            ) {
                validPatterns +=
                countPatternsFromNumber(
                    nextNumber,
                    currentLength + 1,
                    minLength,
                    maxLength,
                    jump,
                    visitedNumbers,
                    dp
                );
            }
        }

        // Backtrack: unmark the current number before returning
        visitedNumbers = clearBit(visitedNumbers, currentNumber);

        return dp[currentNumber][visitedNumbers] = validPatterns;
    }

    private int setBit(int num, int position) {
        num |= 1 << (position - 1);
        return num;
    }

    private int clearBit(int num, int position) {
        num ^= 1 << (position - 1);
        return num;
    }

    private boolean isSet(int num, int position) {
        int bitAtPosition = (num >> (position - 1)) & 1;
        return bitAtPosition == 1;
    }
}
/*
class Solution {
    Map<Integer, List<Integer>> map;
    public Solution() {
        map = new HashMap();
        map.put(1, List.of(2,4,5,6,8));
        map.put(2, List.of(1,3,4,5,6,7,9));
        map.put(3, List.of(2,4,5,6,8));
        map.put(4, List.of(1,2,3,5,7,8,9));
        map.put(5, List.of(1,2,3,4,6,7,8,9));
        map.put(6, List.of(1,2,3,5,7,8,9));
        map.put(7, List.of(2,4,5,6,8));
        map.put(8, List.of(1,3,4,5,6,7,9));
        map.put(9, List.of(2,4,5,6,8));
    }
    public int numberOfPatterns(int m, int n) {
        Queue<Integer> q = new ArrayDeque();
        Queue<Set<Integer>> used = new ArrayDeque();
        for (int i=1; i<=9; i++) {
            q.add(i);
            Set<Integer> path = new HashSet();
            path.add(i);
            used.add(path);
        }
        
        int cnt = 0;
        while (q.size() > 0) {
            int cur = q.poll();
            Set<Integer> path = used.poll();
            if (path.size() >= m) {
                cnt++;
            }
            if (path.size() == n) {
                continue;
            }
            for (int adj : map.get(cur)) {
                if (path.contains(adj)) {
                    continue;
                }
                q.add(adj);
                Set<Integer> newPath = new HashSet(path);
                newPath.add(adj);
                used.add(newPath);
            }
        }
        return cnt;
    }
}
*/