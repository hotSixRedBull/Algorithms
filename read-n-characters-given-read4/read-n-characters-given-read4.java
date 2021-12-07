/**
 * The read4 API is defined in the parent class Reader4.
 *     int read4(char[] buf4);
 */

public class Solution extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Number of characters to read
     * @return    The number of actual characters read
     */
    public int read(char[] buf, int n) {
        int readCnt = 0;
        int read4Cnt = 0;
        char[] read4Buf = new char[10];
        do {
            read4Cnt = read4(read4Buf);
            //System.out.println(String.format("read4Cnt = %d, read4Buf = %S", read4Cnt, read4Buf));
            for (int i = 0; i < read4Cnt && readCnt < n; i++) {
                buf[readCnt] = read4Buf[i];
                //System.out.println(String.format("read4Buf[%d] = %c, buf[%d] = %c", i, read4Buf[i], readCnt, buf[readCnt]));
                readCnt++;
            }
        } while(read4Cnt > 0);
        return readCnt;
    }
}