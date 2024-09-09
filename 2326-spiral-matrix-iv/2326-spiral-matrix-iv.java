class Solution {

    public int[][] spiralMatrix(int m, int n, ListNode head) {
        // Store the east, south, west, north movements in a matrix.
        int i = 0, j = 0, cur_d = 0, movement[][] = {
            { 0, 1 },
            { 1, 0 },
            { 0, -1 },
            { -1, 0 },
        };
        int[][] res = new int[m][n];
        for (int[] row : res) {
            Arrays.fill(row, -1);
        }

        while (head != null) {
            res[i][j] = head.val;
            int newi = i + movement[cur_d][0], newj = j + movement[cur_d][1];

            // If we bump into an edge or an already filled cell, change the
            // direction.
            if (
                Math.min(newi, newj) < 0 ||
                newi >= m ||
                newj >= n ||
                res[newi][newj] != -1
            ) cur_d = (cur_d + 1) % 4;
            i += movement[cur_d][0];
            j += movement[cur_d][1];

            head = head.next;
        }

        return res;
    }
}
/*
class Solution {
    public int[][] spiralMatrix(int m, int n, ListNode head) {
        int[][] result = new int[m][n];
        int curR = 0;
        int curC = 0;
        int h = n-1;
        int v = m-1;
        result[0][0] = head.val;
        ListNode cur = head.next;
        int cnt = 2;
        while (cnt < m*n) {
            for (int i=1; i<=h; i++) {
                System.out.println(String.format("1(%d, %d)",curR, curC+i));
                result[curR][curC+i] = cur == null ? -1 : cur.val;
                cur = cur == null ? null : cur.next;
                cnt++;
                if (cnt == m*n) {
                    break;
                }
            }
            if (cnt == m*n) {
                break;
            }
            curC = curC+h;
            h--;
            for (int i=1; i<=v; i++) {
                System.out.println(String.format("2(%d, %d)",curR+i, curC));
                result[curR+i][curC] = cur == null ? -1 : cur.val;
                cur = cur == null ? null : cur.next;
                cnt++;
                if (cnt == m*n) {
                    break;
                }
            }
            if (cnt == m*n) {
                break;
            }
            curR = curR+v;
            v--;
            for (int i=1; i<=h; i++) {
                System.out.println(String.format("3(%d, %d)",curR, curC-i));
                result[curR][curC-i] = cur == null ? -1 : cur.val;
                cur = cur == null ? null : cur.next;
                cnt++;
                if (cnt == m*n) {
                    break;
                }
            }
            if (cnt == m*n) {
                break;
            }
            curC = curC-h+1;
            h--;
            for (int i=1; i<=v; i++) {
                System.out.println(String.format("4(%d, %d)",curR-i, curC));
                result[curR-i][curC] = cur == null ? -1 : cur.val;
                cur = cur == null ? null : cur.next;
                cnt++;
                
                if (cnt == m*n) {
                    break;
                }
            }
            curR = curR-v;
            v--;
            if (cnt == m*n) {
                break;
            }
            print(result);
            System.out.println(cur.val);
        }
        return result;
    }
    public void print(int[][] arr) {
        System.out.println("print");
        for (int r=0; r<arr.length; r++) {
            System.out.println(Arrays.toString(arr[r]));
        }
    }
}
*/