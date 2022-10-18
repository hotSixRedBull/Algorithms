class Solution {
    public String similarRGB(String color) {
        String maxString = null;
        int max = Integer.MIN_VALUE;
        int ab = Integer.parseInt(color.substring(1,3), 16);
        int cd = Integer.parseInt(color.substring(3,5), 16);
        int ef = Integer.parseInt(color.substring(5,7), 16);
        for (int i=-1; i<=1; i++) {
            for (int j=-1; j<=1; j++) {
                for (int k=-1; k<=1; k++) {
                    char u = color.charAt(1);
                    char w = color.charAt(3);
                    char y = color.charAt(5);
                    if (u == '0' && i == -1) {
                        continue;
                    }
                    if (u == 'f' && i == 1) {
                        continue;
                    }
                    if (w == '0' && j == -1) {
                        continue;
                    }
                    if (w == 'f' && j == 1) {
                        continue;
                    }
                    if (y == '0' && k == -1) {
                        continue;
                    }
                    if (y == 'f' && k == 1) {
                        continue;
                    }
                    if (u == 'a' && i == -1) {
                        u = '9';
                    }
                    else if (u == '9' && i == 1) {
                        u = 'a';
                    }
                    else {
                        u = (char)(u + i);
                    }
                    if (w == 'a' && j == -1) {
                        w = '9';
                    }
                    else if (w == '9' && j == 1) {
                        w = 'a';
                    }
                    else {
                        w = (char)(w + j);
                    }
                    if (y == 'a' && k == -1) {
                        y = '9';
                    }
                    else if (y == '9' && k == 1) {
                        y = 'a';
                    }
                    else {
                        y = (char)(y + k);
                    }
                    int uv = convertShortenToInt(u);
                    int wx = convertShortenToInt(w);
                    int yz = convertShortenToInt(y);
                    int calculated = getSimilarity(ab, cd, ef, uv, wx, yz);
                    if (max < calculated) {
                        max = calculated;
                        char[] newCharArray = new char[]{
                            '#',
                            u, 
                            u,
                            w,
                            w,
                            y,
                            y
                        };
                        maxString = new String(newCharArray);
                    }
                }
            }
        }
        return maxString;
    }
    public int convertShortenToInt(char c) {
        int parsed = Integer.parseInt(c+"", 16);
        parsed += parsed*16;
        return parsed;
    }
    public int getSimilarity(int ab, int cd, int ef,
                            int uv, int wx, int yz) {
        return - (int) Math.pow(ab-uv,2) - (int) Math.pow(cd-wx,2) - (int) Math.pow(ef-yz,2);
    }
}

/*
"#a0c63f"

*/