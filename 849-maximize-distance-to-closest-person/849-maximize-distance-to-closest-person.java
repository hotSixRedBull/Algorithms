class Solution {
    public int maxDistToClosest(int[] seats) {
        int maxStarts = -1;
        int maxLen = -1;
        int len = 0;
        for (int i=0; i<seats.length; i++) {
            if (seats[i] == 1) {
                if (i-len == 0) {
                    maxStarts = i-len;
                    maxLen = len;
                }
                if (maxStarts == 0) {
                    if (len % 2 == 0) {
                        if (maxLen <= len/2) {
                            maxStarts = i-len;
                            maxLen = len/2;
                        }
                    }
                    else {
                        if (maxLen <= len/2+1) {
                            maxStarts = i-len;
                            maxLen = len/2+1;
                        }
                    }
                }
                else {
                    if (len % 2 == 0) {
                        if (maxLen <= len/2) {
                            maxStarts = i-len;
                            maxLen = len/2;
                        }
                    }
                    else {
                        if (maxLen <= len/2+1) {
                            maxStarts = i-len;
                            maxLen = len/2+1;
                        }
                    }
                }
                len = 0;
            }
            else {
                len++;
            }
        }
        // System.out.println(maxLen);
        if (len != 0 && maxLen <= len) {
            return len;
        }
        return maxLen;
    }
}
/*
[1,0,0,0,1,0,1]
[1,0,0,0]
[0,0,0,1]
[1,0,0,1]
[0,1]
[0,0,0,0,0,1,0,1,1,1,0,0,0,0,0,0,1,0,0,0,0,1]
[1,0,0,1,0,0,0,1,1,1,0,0,0,0,0,0,1,0,0,0,0,0]
*/