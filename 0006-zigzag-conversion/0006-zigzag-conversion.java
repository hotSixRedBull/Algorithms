class Solution {
    public String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        
        HashMap<Integer, String> map = new HashMap();
        boolean downside = true;
        int row = 0;
        for (int i=0; i<s.length(); i++) {
            map.put(row, map.getOrDefault(row, "")+s.charAt(i));
            if (row == numRows-1) {
                downside = false;
            }
            else if (row == 0) {
                downside = true;
            }
            if (downside) {
                row++;
            }
            else {
                row--;
            }
        }
        
        String ret = "";
        for (int i=0; i<numRows; i++) {
            ret += map.getOrDefault(i, "");
        }
        return ret;
    }
}

/*
"A"
2
"AB"
1
*/