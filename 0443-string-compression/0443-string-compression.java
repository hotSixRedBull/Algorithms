class Solution {
    public int compress(char[] chars) {
        int cnt = 1;
        int pos = 0;
        for (int i=1; i<chars.length; i++) {
            if (chars[i-1] != chars[i]) {
                // System.out.println(String.format("%c is %dth", chars[i-1], cnt));
                chars[pos] = chars[i-1];
                pos++;
                if (cnt != 1) {
                    int end = pos + (int)Math.log10(cnt);
                    for (int j=end; j >= pos; j--) {
                        int digit = cnt % 10;
                    // System.out.println(String.format("digit: %d", digit));
                        chars[j] = (char)(digit + '0');
                        cnt /= 10;
                    }
                    pos = end+1;
                }
                cnt=1;
            }
            else {
                cnt++;
            }
            // System.out.println(Arrays.toString(chars));
        }
        if (chars.length == 1 || cnt != 1 || chars[chars.length-1] != chars[chars.length-2]) {
            chars[pos] = chars[chars.length-1];
            pos++;
            if (cnt != 1) {
                int end = pos + (int)Math.log10(cnt);
                for (int j=end; j >= pos; j--) {
                    int digit = cnt % 10;
                // System.out.println(String.format("digit: %d", digit));
                    chars[j] = (char)(digit + '0');
                    cnt /= 10;
                }
                pos = end+1;
            }
            cnt=1;
        }
        return pos;
    }
}

/*
self-made test cases
["a","a","a","a","a","a","a","a","a","a","a","a","a","b","b","c","c","c"]
["a"]
["a","a","b"]
["a","b","b"]
["b","b"]
["a","b"]
*/