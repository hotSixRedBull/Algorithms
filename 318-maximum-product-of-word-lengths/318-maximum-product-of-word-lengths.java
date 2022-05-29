class Solution {
    public int maxProduct(String[] words) {
        int N = words.length;
        int[] masks = new int[N];
        int[] lens = new int[N];
        for (int i=0; i<N; i++) {
            for (char c : words[i].toCharArray()) {
                int pos = (int)c - (int)'a';
                masks[i] = (masks[i] | (1 << pos));
            }
            lens[i] = words[i].length();
        }
        
        int max = 0;
        for (int i=0; i<N; i++) {
            for (int j=i+1; j<N; j++) {
                if ((masks[i]&masks[j]) == 0) {
                    max = Math.max(max, lens[i]*lens[j]);
                }
            }
        }
        return max;
    }
}