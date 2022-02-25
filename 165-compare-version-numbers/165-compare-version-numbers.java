class Solution {
    public int compareVersion(String version1, String version2) {
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");
        // System.out.println(String.format("v1.length: %d, v2.length: %d", v1.length, v2.length));
        int min = Math.min(v1.length, v2.length);
        for (int i=0; i<min; i++) {
            v1[i] = stripZero(v1[i]);
            v2[i] = stripZero(v2[i]);
            int v1Int = Integer.parseInt(v1[i]);
            int v2Int = Integer.parseInt(v2[i]);
            // System.out.println(String.format("v1Int: %d, v2Int: %d", v1Int, v2Int));
            if (v1Int > v2Int) {
                return 1;
            }
            else if (v1Int < v2Int) {
                return -1;
            }
        }
        if (v1.length > v2.length) {
            for (int i=v2.length; i<v1.length; i++) {
                v1[i] = stripZero(v1[i]);
                int v1Int = Integer.parseInt(v1[i]);
                if (v1Int != 0) {
                    return 1;
                }
            }
        }
        else if (v1.length < v2.length) {
            for (int i=v1.length; i<v2.length; i++) {
                v2[i] = stripZero(v2[i]);
                int v2Int = Integer.parseInt(v2[i]);
                if (v2Int != 0) {
                    return -1;
                }
            }
        }
        return 0;
    }
    
    public String stripZero(String v) {
        int j = 0;
        for (j=0; j<v.length(); j++) {
            if (v.charAt(j) != '0') {
                break;
            }
        }
        String newV = "";
        if (j >= v.length()) {
            newV = "0";
        }
        else {
            for (; j<v.length(); j++) {
                newV += v.charAt(j);
            }
        }
        return newV;
    }
}