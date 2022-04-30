/**
 * The read4 API is defined in the parent class Reader4.
 *     int read4(char[] buf4); 
 */

public class Solution extends Reader4 {
    static char[] saved;
    static int savedSiz;
    public Solution() {
        saved = new char[4];
        savedSiz = 0;
    }
    /**
     * @param buf Destination buffer
     * @param n   Number of characters to read
     * @return    The number of actual characters read
     */
    public int read(char[] buf, int n) {
        int index = 0;
        if (savedSiz > 0) {
            if (savedSiz >= n) {
                for (int i=0; i<n; i++) {
                    buf[i] = saved[i];
                }
                for (int i=n; i<savedSiz; i++) {
                    saved[i-n] = saved[i];
                }
                savedSiz -= n;
                return n;
            }
            else {
                for (int i=0; i<savedSiz; i++) {
                    buf[index++] = saved[i];
                    n--;
                }
                savedSiz = 0;
            }
        }
        char[] buf4 = new char[4];
        while (n > 0) {
            int readed = read4(buf4);
            if (readed == 0) {
                break;
            }
            for (int i=0; i<readed; i++) {
                buf[index++] = buf4[i];
                n--;
                if (n == 0) {
                    if (i < readed) {
                        for (int j=i+1; j<readed; j++) {
                            saved[savedSiz++] = buf4[j];
                        }
                    }
                    break;
                }
            }
        }
        return index;
    }
}