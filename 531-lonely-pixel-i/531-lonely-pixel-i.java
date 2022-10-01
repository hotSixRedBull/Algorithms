class Solution {
    public int findLonelyPixel(char[][] picture) {
        int n = picture.length;
        int m = picture[0].length;
        int[][] calculated = new int[n][m];
        int cnt = 0;
        for (int r=0; r<n; r++) {
            for (int c=0; c<m; c++) {
                if (calculated[r][c] != 0) {
                    continue;
                }
                if (picture[r][c] == 'B') {
                    // System.out.println("?");
                    boolean isLonely = true;
                    Queue<Integer> rq = new ArrayDeque();
                    Queue<Integer> cq = new ArrayDeque();
                    rq.add(r);
                    cq.add(c);
                    calculated[r][c] = -1;
                    while (rq.size() > 0) {
                        int curR = rq.poll();
                        int curC = cq.poll();
                        for (int i=0; i<n; i++) {
                            if (picture[i][curC] == 'B'
                               && calculated[i][curC] != -1) {
                                isLonely = false;
                                calculated[i][curC] = -1;
                                rq.add(i);
                                cq.add(curC);
                            }
                        }
                        for (int i=0; i<m; i++) {
                            if (picture[curR][i] == 'B'
                               && calculated[curR][i] != -1) {
                                isLonely = false;
                                calculated[curR][i] = -1;
                                rq.add(curR);
                                cq.add(i);
                            }
                        }
                    }
                    if (isLonely) {
                        cnt++;
                    }
                }
            }
        }
        return cnt;
    }
}

/*
[["B","B","B"]]
*/