class Solution {
    public int compareVersion(String version1, String version2) {
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");
        int min = Math.min(v1.length, v2.length);
        for (int i=0; i<min; i++) {
            int a = Integer.parseInt(v1[i], 10);
            int b = Integer.parseInt(v2[i], 10);
            if (a < b) {
                return -1;
            }
            else if (a > b) {
                return 1;
            }
        }
        
        if (v1.length == v2.length) {
            return 0;
        }
        else if (v1.length < v2.length) {
            for (int i=v1.length; i<v2.length; i++) {
                if (Integer.parseInt(v2[i], 10) > 0) {
                    return -1;
                }
            }
            return 0;
        }
        else {
            for (int i=v2.length; i<v1.length; i++) {
                if (Integer.parseInt(v1[i], 10) > 0) {
                    return 1;
                }
            }
            return 0;
        }
    }
}