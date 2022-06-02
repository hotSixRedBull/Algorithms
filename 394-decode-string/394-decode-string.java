class Solution {
    public String decodeString(String s) {
        String ret = "";
        for (int i=0; i<s.length(); i++) {
            int num = 0;
            while (s.charAt(i) >= '0'
                   && s.charAt(i) <= '9') {
                num *= 10;
                num += s.charAt(i)-'0';
                i++;
            }
            if (num != 0) {
                // System.out.println(num);
                int braceCnt = 1;
                i++;
                for (int j=i; j<s.length(); j++) {
                    if (s.charAt(j) == '[') {
                        braceCnt++;
                    }
                    else if (s.charAt(j) == ']') {
                        braceCnt--;
                        if (braceCnt == 0) {
                            ret += recursive(s.substring(i,j), num);
                            i = j;
                            break;
                        }
                    }
                }
            }
            else {
                ret += s.charAt(i);
            }
        }
        return ret;
    }
    public String recursive(String s, int n) {
        String ret = "";
        for (int i=0; i<s.length(); i++) {
            int num = 0;
            while (s.charAt(i) >= '0'
                   && s.charAt(i) <= '9') {
                num *= 10;
                num += s.charAt(i)-'0';
                i++;
            }
            if (num != 0) {
                int braceCnt = 1;
                i++;
                for (int j=i; j<s.length(); j++) {
                    if (s.charAt(j) == '[') {
                        braceCnt++;
                    }
                    else if (s.charAt(j) == ']') {
                        braceCnt--;
                        if (braceCnt == 0) {
                            ret += recursive(s.substring(i,j), num);
                            i = j;
                            break;
                        }
                    }
                }
            }
            else {
                ret += s.charAt(i);
            }
        }
        // System.out.println("2: "+n);
        // System.out.println("2: "+ret);
        String retCopied = "";
        for (int i=0; i<n; i++) {
            retCopied += ret;
        }
        return retCopied;
    }
}