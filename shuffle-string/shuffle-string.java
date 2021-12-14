class Solution {
    public String restoreString(String s, int[] indices) {
        char[] cArr = new char[indices.length];
        for (int i=0; i<indices.length; i++) {
            cArr[indices[i]] = s.charAt(i);
        }
        return String.valueOf(cArr);
    }
}