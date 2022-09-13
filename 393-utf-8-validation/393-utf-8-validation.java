class Solution {
    public boolean validUtf8(int[] data) {
        int bit = 255;
        for (int i=0; i<data.length; i++) {
            if ((data[i] & 128) == 0) {
                // System.out.println("0xxxxxxx");
                continue;
            }
            else if ((data[i] & 248) == 240) {
                // System.out.println("11110xxx");
                if (i < data.length-3) {
                    if ((data[i+1] & 192) == 128
                       && (data[i+2] & 192) == 128
                       && (data[i+3] & 192) == 128) {
                        i += 3;
                    }
                    else {
                        return false;
                    }
                }
                else {
                    return false;
                }
            }
            else if ((data[i] & 240) == 224) {
                // System.out.println("1110xxxx");
                if (i < data.length-2) {
                    if ((data[i+1] & 192) == 128
                       && (data[i+2] & 192) == 128) {
                        i += 2;
                    }
                    else {
                        return false;
                    }
                }
                else {
                    return false;
                }
            }
            else if ((data[i] & 224) == 192) {
                // System.out.println("110xxxxx ");
                if (i < data.length-1) {
                    if ((data[i+1] & 192) == 128) {
                        i++;
                    }
                    else {
                        return false;
                    }
                }
                else {
                    return false;
                }
            }
            else {
                return false;
            }
        }
        return true;
    }
}
/*

[115,100,102,231,154,132,13,10]
*/